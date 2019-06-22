package Vista;

import Juego.AlgoCraft;
import Juego.Jugador.Jugador;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Juego.Mapa.Ubicable;
import javafx.collections.ObservableList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

//Imports para el color de fondo
import javafx.scene.paint.*;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;


public class VistaMapa extends GridPane {
    private static VistaMapa instancia = new VistaMapa();
    Tablero<Ubicable> mapa = AlgoCraft.getInstancia().getMapa();
    Jugador jugador = AlgoCraft.getInstancia().getJugador();

    private VistaMapa() {
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        int filas = mapa.getFilas();
        int columnas = mapa.getColumnas();
        for (int i = 0; i < filas; i++) {
            VistaCelda vistaCelda;
            for (int j = 0; j < columnas; j++) {
                vistaCelda = new VistaCelda(mapa.getCelda(new Posicion(i + 1, j + 1)));
                this.add(vistaCelda, i, j);
            }
        }
    }

    public static VistaMapa getInstancia() {
        return instancia;
    }

    public void actualizarCelda(Posicion posicion) {
        Node resultado = null;
        int fila = posicion.getCoordenadaX() ;
        int columna = posicion.getCoordenadaY() ;
        ObservableList<Node> celdas = getChildren();

        for (Node celda : celdas) {
            if (getRowIndex(celda) == fila
                    && getColumnIndex(celda) == columna) {
                resultado = celda;
                ((VistaCelda) resultado).actualizar();
            }
        }
    }
}

