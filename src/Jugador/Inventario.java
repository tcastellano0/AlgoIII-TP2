package Jugador;

import java.util.ArrayList;

public class Inventario<T> {
	
	private ArrayList<T> listaDeItems;
	
	public Inventario() {
		this.listaDeItems = new ArrayList<T>(); 
	}
	
	public void agregar(T item) {
		this.listaDeItems.add(item);
	}
	
	public int cantidad() {
		return this.listaDeItems.size();
	}
	
	public T ultimoItem() {
		return this.listaDeItems.get(listaDeItems.size() - 1);
	}

}
