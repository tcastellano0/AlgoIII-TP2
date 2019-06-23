package Juego.Jugador;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.Ubicable;
import Materiales.*;

public class Jugador implements Ubicable {
	
	private Herramienta herramientaEquipada;
	private Inventario<Herramienta> inventarioDeHerramientas;
	private Inventario<Material> inventarioDeMateriales;
	private Posicion posicion;
	private Movimiento movimiento;

	public Jugador() {
		this.herramientaEquipada = Herramienta.hachaDeMadera();
		this.inventarioDeHerramientas = new Inventario<Herramienta>();
		this.inventarioDeHerramientas.agregar(this.herramientaEquipada);
		this.inventarioDeMateriales = new Inventario<Material>();
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public void moverArriba(){
		this.movimiento.moverArriba(this);
	}
	public void moverAbajo(){
		this.movimiento.moverAbajo(this);
	}
	public void moverDerecha(){
		this.movimiento.moverDerecha(this);
	}
	public void moverIzquierda(){
		this.movimiento.moverIzquierda(this);
	}

	public int cantidadDeHerramientas() {
		return (this.inventarioDeHerramientas.cantidad());
	}
	
	public int cantidadDeMateriales() {
		return (this.inventarioDeMateriales.cantidad());
	}
	
	public void agregarHerramienta(Herramienta herramienta) {
		this.inventarioDeHerramientas.agregar(herramienta);
	}
	
	public Herramienta herramientaEquipada() {
		return (this.herramientaEquipada);
	}
	
	public void equiparConUltimaHerramienta() {
		this.herramientaEquipada = this.ultimaHerramientaObtenida();
	}
	
	public Herramienta ultimaHerramientaObtenida() {
		return this.inventarioDeHerramientas.ultimoItemAgregado();
	}

	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public Posicion getPosicionSiguiente() {
		return this.movimiento.getPosicionSiguiente(this.getPosicion());
	}

	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
	
	public void golpear(Material material) {
		this.herramientaEquipada.golpear(material);	
		this.guardar(material.recolectar());
	}
	
	public void guardar(Material material) {
		material.esGuardadoEn(this);
	}
	
	public void guardar(Madera material) {
		this.inventarioDeMateriales.agregar(material);
	}
	
	public void guardar(Metal material) {
		this.inventarioDeMateriales.agregar(material);
	}
	
	public void guardar(Piedra material) {
		this.inventarioDeMateriales.agregar(material);
	}
	
	public void guardar(Diamante material) {
		this.inventarioDeMateriales.agregar(material);
	}

}
