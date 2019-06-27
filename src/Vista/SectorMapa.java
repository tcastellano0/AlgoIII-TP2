package Vista;

import Juego.AlgoCraft;
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


public class SectorMapa extends GridPane {
    Tablero<Ubicable> mapa = AlgoCraft.getInstancia().getMapa();

    private static SectorMapa instancia = new SectorMapa();
    public static SectorMapa getInstancia() {
        return instancia;
    }
    
    private SectorMapa() {
    	this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    	
    	int filas = mapa.getFilas();
        int columnas = mapa.getColumnas();
        
        VistaCelda vistaCelda;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                vistaCelda = new VistaCelda(mapa.getCelda(new Posicion(i + 1, j + 1)));
                this.add(vistaCelda, i, j);
            }
        }
    }

    public void actualizar(){
        ObservableList<Node> celdas = this.getChildren();
        for (Node celda : celdas) {
            VistaCelda c = (VistaCelda) celda;
            c.actualizar();
        }
    }

}

