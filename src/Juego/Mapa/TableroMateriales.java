package Juego.Mapa;

import Materiales.Material;
import Materiales.MaterialNulo;

public class TableroMateriales extends Tablero<Material> {

	public TableroMateriales(int filas, int columnas) {
		super(filas, columnas);
		for(Posicion unaPosicion: celdas.keySet()){
			this.poner(new MaterialNulo(), unaPosicion);
		}
	}

	public boolean esIgual(TableroMateriales tablero) {

		for(int x = 1; x <= 3; x++) {
			for(int y = 1; y <= 3; y++) {
				System.err.println("Posicion");
				System.err.println(x);
				System.err.println(y);
				System.err.println("Veo Segundo Tablero");
				tablero.ver(x,y);
				System.err.println("Veo Primer Tablero");
				this.ver(x,y);
				if(!this.ver(x,y).esIgual(tablero.ver(x,y)))
					return false;
			}
		}
		/*
		for(Posicion unaPosicion : celdas.keySet()) {
			if (!this.ver(unaPosicion).esIgual(tablero.ver(unaPosicion)))
				return false;
		}*/

		return true;
	}
	
}
