package Juego.Jugador;

import java.util.LinkedList;

public class Inventario<T> {
	
	private LinkedList<T> listaDeItems;
	
	public Inventario() {
		this.listaDeItems = new LinkedList<T>();
	}
	
	public void agregar(T item) {
		this.listaDeItems.add(item);
	}
	
	public int cantidad() {
		return this.listaDeItems.size();
	}
	
	public T ultimoItemAgregado() {
		return this.listaDeItems.getLast();
	}
	
	public T sacarUltimo() {
		return this.listaDeItems.removeLast();
	}

	public void vaciar(){
		listaDeItems.clear();
	}

}
