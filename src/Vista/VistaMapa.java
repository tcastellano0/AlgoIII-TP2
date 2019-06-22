package Vista;

import Juego.AlgoCraft;
import Juego.Jugador.Jugador;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Juego.Mapa.Ubicable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaMapa extends GridPane {
    Tablero<Ubicable> mapa = AlgoCraft.getInstancia().getMapa();
    Jugador jugador = AlgoCraft.getInstancia().getJugador();
    Image imagenJugador = new Image("Vista/images/menu/jugador.jpg", 25, 25, false, true);
    Image imagenMadera = new Image("Vista/images/menu/madera.jpg", 25, 25, false, true);
    Image imagenPiedra = new Image("Vista/images/menu/piedra.jpg", 25, 25, false, true);
    Image imagenMetal = new Image("Vista/images/menu/metal.jpg", 25, 25, false, true);
    Image imagenDiamante = new Image("Vista/images/menu/diamante.jpg", 25, 25, false, true);

    public VistaMapa() {
        int filas = mapa.getFilas();
        int columnas = mapa.getColumnas();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Button boton = (Button) e.getSource();
                boton.setGraphic(new ImageView(imagenJugador));
            }
        };

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                try {
                    String clase = String.valueOf((mapa.ver(new Posicion(i + 1, j + 1)).getClass()));
                    Image fondo = null;
                    switch (clase) {
                        case "class Juego.Jugador.Jugador":
                            fondo = imagenJugador;
                            break;
                        case "class Materiales.Madera":
                            fondo = imagenMadera;
                            break;
                        case "class Materiales.Piedra":
                            fondo = imagenPiedra;
                            break;
                        case "class Materiales.Metal":
                            fondo = imagenMetal;
                            break;
                        case "class Materiales.Diamante":
                            fondo = imagenDiamante;
                            break;
                    }
                    ImageView iw = new ImageView(fondo);
                    Button boton = new Button("", iw);
                    this.add(boton, i, j);
                } catch (NullPointerException e) {
                    Image fondo = new Image("Vista/images/menu/pasto.jpg", 25, 25, false, true);
                    ImageView iw = new ImageView(fondo);
                    Button boton = new Button("", iw);
                    boton.setOnAction(event);
                    this.add(boton, i, j);
                }

            }
        }
    }
}