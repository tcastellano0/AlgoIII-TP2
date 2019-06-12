package Juego.Jugador;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.Ubicable;
import Materiales.Material;

public class Jugador implements Ubicable {
	
	private Herramienta herramientaEquipada;
	private Inventario<Herramienta> inventarioDeHerramientas;
	private Inventario<Material> inventarioDeMateriales;
	private Posicion posicion;

	public Jugador() {
		this.herramientaEquipada = Herramienta.hachaDeMadera();
		this.inventarioDeHerramientas = new Inventario<Herramienta>();
		this.inventarioDeHerramientas.agregar(this.herramientaEquipada);
		this.inventarioDeMateriales = new Inventario<Material>();
	}
	
	public int cantidadDeHerramientas() {
		return (this.inventarioDeHerramientas.cantidad());
	}
	
	public int cantidadDeMateriales() {
		return (this.inventarioDeMateriales.cantidad());
	}
	
	public Herramienta herramientaEquipada() {
		return (this.herramientaEquipada);
	}
	
	public Herramienta ultimaHerramientaObtenida() {
		return this.inventarioDeHerramientas.ultimoItemAgregado();
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}

}
