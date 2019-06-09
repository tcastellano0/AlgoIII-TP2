package Juego.Mapa;

public class Celda<T> {

	private T contenido;
	

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}
	
	public T getContenido() {
		return contenido;
	}

}

//faltan los tests de celda todavia