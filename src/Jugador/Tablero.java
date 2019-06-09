package Jugador;

import java.util.ArrayList;
import java.util.List;

public class Tablero<T> {
	
	private int filas;
	private int columnas;
	private List<Celda<T>> celdas = new ArrayList<>();
	
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;

		for (int i = 0; i < this.filas * this.columnas; i++) {
			celdas.add(new Celda<T>());
		}
	}
	
	public void agregar(T item, int fila, int columna) {
		celdas.get((fila - 1) * this.columnas + columna - 1).setContenido(item);
	}
	
	public T sacar(int fila, int columna) {
		return celdas.get((fila - 1) * this.columnas + columna - 1).getContenido();
	}

}
