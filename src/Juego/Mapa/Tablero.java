package Juego.Mapa;

import Juego.Mapa.Celda;

import java.util.ArrayList;
import java.util.List;

public class Tablero<T> {
	
	private int filas;
	private int columnas;
	private List<Celda<T>> celdas = new ArrayList<>();
	
	public Tablero(int filas, int columnas) {

		if (filas < 1){
			throw new TableroCreacionException();
		}
		if (columnas < 1){
			throw new TableroCreacionException();
		}

		this.filas = filas;
		this.columnas = columnas;

		for (int i = 0; i < this.filas * this.columnas; i++) {
			celdas.add(new Celda<T>());
		}
	}
	
	public void agregar(T item, int fila, int columna) {
		if (fila < 1 || fila > this.filas){
			throw new UbicacionInvalidaException();
		}
		if (columna < 1 || columna > this.columnas){
			throw new UbicacionInvalidaException();
		}
		celdas.get((fila - 1) * this.columnas + columna - 1).setContenido(item);
	}
	
	public T sacar(int fila, int columna) {
		return celdas.get((fila - 1) * this.columnas + columna - 1).getContenido();
	}

}
