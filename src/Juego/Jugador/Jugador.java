package Juego.Jugador;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.Ubicable;
import Materiales.*;

public class Jugador implements Ubicable {
	
	private Herramienta herramientaEquipada;
	private Inventario<Herramienta> inventarioDeHerramientas;
	
	private Inventario<Madera> inventarioDeMadera;
	private Inventario<Metal> inventarioDeMetal;
	private Inventario<Piedra> inventarioDePiedra;
	private Inventario<Diamante> inventarioDeDiamante;
	
	private Posicion posicion;
	private Movimiento movimiento;

	public Jugador() {
		this.herramientaEquipada = Herramienta.hachaDeMadera();
		this.inventarioDeHerramientas = new Inventario<Herramienta>();
		this.agregarHerramienta(this.herramientaEquipada);
		this.inventarioDeMadera = new Inventario<Madera>();
		this.inventarioDeMetal = new Inventario<Metal>();
		this.inventarioDePiedra = new Inventario<Piedra>();
		this.inventarioDeDiamante = new Inventario<Diamante>();
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
	
	public int cantidadDeMaderas() {
		return (this.inventarioDeMadera.cantidad());
	}
	
	public Madera sacarUnaMadera() {
		return this.inventarioDeMadera.sacarUltimo();
	}
	
	public int cantidadDePiedras() {
		return (this.inventarioDePiedra.cantidad());
	}
	
	public Piedra sacarUnaPiedra() {
		return this.inventarioDePiedra.sacarUltimo();
	}
	
	public int cantidadDeMetales() {
		return (this.inventarioDeMetal.cantidad());
	}
	
	public Metal sacarUnMetal() {
		return this.inventarioDeMetal.sacarUltimo();
	}
	
	public int cantidadDeDiamantes() {
		return (this.inventarioDeDiamante.cantidad());
	}
	
	public Diamante sacarUnDiamante() {
		return this.inventarioDeDiamante.sacarUltimo();
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
	
	public void guardar(Metal material) {
		this.inventarioDeMetal.agregar(material);
	}
	
	public void guardar(Madera material) {
		this.inventarioDeMadera.agregar(material);
	}
	
	public void guardar(Piedra material) {
		this.inventarioDePiedra.agregar(material);
	}
	
	public void guardar(Diamante material) {
		this.inventarioDeDiamante.agregar(material);
	}


	public int cantidadDeHerramientas() {
		return (this.inventarioDeHerramientas.cantidad());
	}

}
