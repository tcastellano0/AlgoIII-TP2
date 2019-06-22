package Vista;

import Juego.Jugador.Jugador;
import Juego.Mapa.Celda;
import Materiales.Diamante;
import Materiales.Madera;
import Materiales.Metal;
import Materiales.Piedra;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCelda extends Button {
    Celda celda;
    ImageView imageView;
    Image imagenJugador = new Image("Vista/images/menu/jugador.jpg", 25, 25, false, true);
    Image imagenMadera = new Image("Vista/images/menu/madera.jpg", 25, 25, false, true);
    Image imagenPiedra = new Image("Vista/images/menu/piedra.jpg", 25, 25, false, true);
    Image imagenMetal = new Image("Vista/images/menu/metal.jpg", 25, 25, false, true);
    Image imagenDiamante = new Image("Vista/images/menu/diamante.jpg", 25, 25, false, true);
    Image imagenPasto = new Image("Vista/images/menu/pasto.jpg", 25, 25, false, true);

    public VistaCelda() {
        imageView = new ImageView(imagenPasto);
        this.setGraphic(imageView);
    }

    public VistaCelda(Celda celda) {
        this.celda = celda;
        actualizar();
    }

    public void actualizar() {
        try {
            Class<?> clase = celda.ver().getClass();
            if (clase == Madera.class) {
                imageView = new ImageView(imagenMadera);
            }
            if (clase == Piedra.class) {
                imageView = new ImageView(imagenPiedra);
            }
            if (clase == Metal.class) {
                imageView = new ImageView(imagenMetal);
            }
            if (clase == Diamante.class) {
                imageView = new ImageView(imagenDiamante);
            }
            if (clase == Jugador.class) {

                imageView = new ImageView(imagenJugador);
            }
            if (clase == null) {

            }
        } catch (NullPointerException e) {
            imageView = new ImageView(imagenPasto);
        }
        this.setGraphic(imageView);
    }
}
