package Juego.Mapa;

import Materiales.Material;
import Materiales.MaterialNulo;

public class TableroMateriales extends Tablero<Material> {

	public TableroMateriales(int filas, int columnas) {
		super(filas, columnas);
		//for(Posicion unaPosicion: celdas.keySet()){
		//	this.poner(new MaterialNulo(), unaPosicion);
		//}
	}

	public boolean esIgual(TableroMateriales tablero) {

		for(Posicion unaPosicion : celdas.keySet()) {
			if (!this.ver(unaPosicion).esIgual(tablero.ver(unaPosicion)))
				return false;
		}

		return true;
	}
	
}
