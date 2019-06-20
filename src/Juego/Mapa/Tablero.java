package Juego.Mapa;

import java.util.HashMap;
import java.util.Map;

public class Tablero<T> {
	
	protected int filas;
	protected int columnas;
	protected Map<Posicion, Celda<T>> celdas = new HashMap<>();
	
	public Tablero(int filas, int columnas) {
		
		if (filas < 1) {
			throw new TableroCreacionException();
		}
		if (columnas < 1) {
			throw new TableroCreacionException();
		}
		
		this.filas = filas;
		this.columnas = columnas;
		
		//Inicializacion Tablero.
		for(int x = 1; x <= this.columnas; x++) {
			for(int y = 1; y <= this.filas; y++) {
				celdas.put(new Posicion(x, y), new Celda<T>());
			}
		}
	}

	public void poner(T item, Posicion unaPosicion) {
		validarUbicacion(unaPosicion);
		
		celdas.get(unaPosicion).poner(item);
	}
	

	public T sacar(Posicion unaPosicion) {
		validarUbicacion(unaPosicion);
		
		return celdas.get(unaPosicion).sacar();
	}

	public T ver(Posicion unaPosicion) {
		return celdas.get(unaPosicion).ver();
	}
	
	private void validarUbicacion(Posicion posicion){
		if (!celdas.keySet().contains(posicion)){
			throw new UbicacionFueraDeRangoException();
			//throw new UbicacionInvalidaException();
		}
    }

    protected boolean posicionEstaVacia(Posicion unaPosicion){
		return celdas.get(unaPosicion).estaVacia();
	}

}
