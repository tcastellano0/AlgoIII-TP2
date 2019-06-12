package Juego.Mapa;

import java.util.HashMap;
import java.util.Map;

public class Tablero<T> {
	
	protected int filas;
	protected int columnas;
	protected Map<Posicion, Contenedor<T>> celdas = new HashMap<>();
	
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
	
	public void poner(T item, int fila, int columna) {
		validarUbicacion(fila, columna);
		
		poner(item, new Posicion(fila, columna));
	}
	
	public void poner(T item, Posicion unaPosicion) {
		validarUbicacion(unaPosicion.getCoordenadaY(), unaPosicion.getCoordenadaX());
		
		celdas.get(unaPosicion).poner(item);
	}
	
	public T sacar(int fila, int columna) {
		validarUbicacion(fila, columna);
		
		return sacar(new Posicion(fila, columna));
	}
	
	public T sacar(Posicion unaPosicion) {
		validarUbicacion(unaPosicion.getCoordenadaY(), unaPosicion.getCoordenadaX());
		
		return celdas.get(unaPosicion).sacar();
	}

	public T ver(int fila, int columna) {
		validarUbicacion(fila, columna);
		
		return ver(new Posicion(fila, columna));
	}
	
	protected T ver(Posicion unaPosicion) {
		return celdas.get(unaPosicion).ver();
	}
	
	private void validarUbicacion(int fila, int columna){
        if (fila < 1 || fila > this.filas){
            throw new UbicacionInvalidaException();
        }
        if (columna < 1 || columna > this.columnas){
            throw new UbicacionInvalidaException();
        }
    }

    protected boolean posicionEstaVacia(Posicion unaPosicion){
		return celdas.get(unaPosicion).estaVacia();
	}

}
