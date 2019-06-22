package Vista;

import Juego.AlgoCraft;
import Juego.Jugador.Jugador;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Juego.Mapa.Ubicable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class VistaMapa extends GridPane {
    private static VistaMapa instancia = new VistaMapa();
    Tablero<Ubicable> mapa = AlgoCraft.getInstancia().getMapa();
    Jugador jugador = AlgoCraft.getInstancia().getJugador();

    private VistaMapa() {
        int filas = mapa.getFilas();
        int columnas = mapa.getColumnas();
        for (int i = 0; i < filas; i++) {
            VistaCelda vistaCelda;
            for (int j = 0; j < columnas; j++) {
                try {
                    vistaCelda = new VistaCelda(mapa.getCelda(new Posicion(i + 1, j + 1)));
                    // vistaCelda = new VistaCelda((mapa.ver(new Posicion(i + 1, j + 1))));
                } catch (NullPointerException e) {
                    vistaCelda = new VistaCelda();

                }
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

