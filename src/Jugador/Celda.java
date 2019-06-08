package Jugador;

public class Celda<T> {
	
	private int fila;
	private int columna;
	private T contenido;
	
	public Celda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}
	
	public T getContenido() {
		return contenido;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
	}
}

//faltan los tests de celda todavia