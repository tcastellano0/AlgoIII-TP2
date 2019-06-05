package Jugador;

import Durabilidad.Desgastable;
import Herramientas.Herramienta;
import Materiales.Material;

public class Jugador {
	
	private Herramienta herramientaEquipada;
	private Inventario<Herramienta> inventarioDeHerramientas;
	private Inventario<Material> inventarioDeMateriales;
	
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
	
	public Desgastable ultimaHerramienta() {
		return this.inventarioDeHerramientas.ultimoItem();
	}
	
}
