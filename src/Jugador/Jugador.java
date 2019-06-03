package Jugador;

import Durabilidad.Desgastable;
import Herramientas.Hacha;
import Herramientas.Herramienta;

public class Jugador {
	
	private Herramienta herramientaEquipada;
	private Inventario inventarioDeHerramientas;
	private Inventario inventarioDeMateriales;
	
	public Jugador() {
		this.herramientaEquipada = Hacha.crearHachaDeMadera();
		this.inventarioDeHerramientas = new Inventario();
		this.inventarioDeHerramientas.agregar(this.herramientaEquipada);
		this.inventarioDeMateriales = new Inventario();
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
	
	public Desgastable ultimaHerramienta() {
		return this.inventarioDeHerramientas.ultimoItem();
	}
	
}
