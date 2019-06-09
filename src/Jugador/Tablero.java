package Jugador;

public class Tablero<T> {
	
	private int filas;
	private int columnas;
	private Celda<T>[][] celdas;
	
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		celdas = new Celda[this.filas][this.columnas]; //no se como hacer para sacar el warning ): pero funciona con el warning por ahora by NicolasWuFiuba
		
		for (int fila = 0; fila < this.filas; ++fila) {
			for (int columna = 0; columna < this.columnas; ++columna) {
				celdas[fila][columna] = new Celda<T>();
			}
		}
	}
	
	public void agregar(T item, int fila, int columna) {
		celdas[fila-1][columna-1].setContenido(item);
	}
	
	public T sacar(int fila, int columna) {
		return celdas[fila-1][columna-1].getContenido();
	}

}
