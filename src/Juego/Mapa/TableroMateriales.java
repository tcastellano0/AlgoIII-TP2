package Juego.Mapa;

import Materiales.Material;

public class TableroMateriales extends Tablero<Material> {

	public TableroMateriales(int filas, int columnas) {
		super(filas, columnas);
	}

	public boolean esIgual(TableroMateriales tablero) {

		for(Posicion unaPosicion : celdas.keySet()) {

			if (this.posicionEstaVacia(unaPosicion) ^ tablero.posicionEstaVacia(unaPosicion))
				return false;

			if (this.posicionEstaVacia(unaPosicion) && tablero.posicionEstaVacia(unaPosicion))
				continue;

			if ((!this.posicionEstaVacia(unaPosicion)) && (!tablero.posicionEstaVacia(unaPosicion))){
				if(!this.ver(unaPosicion).esIgual(tablero.ver(unaPosicion)))
					return false;
			}
		}

		return true;
	}
	
}
