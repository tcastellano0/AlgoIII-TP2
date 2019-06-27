package Juego.Jugador;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.Ubicable;
import Materiales.*;

public class Jugador implements Ubicable {
	
	private Herramienta herramientaEquipada;
	private Map<Herramienta, LinkedList<Herramienta>> inventarioDeHerramientas;
	
	private Inventario<Madera> inventarioDeMadera;
	private Inventario<Metal> inventarioDeMetal;
	private Inventario<Piedra> inventarioDePiedra;
	private Inventario<Diamante> inventarioDeDiamante;
	
	private Posicion posicion;
	private Movimiento movimiento;

	public Jugador() {
		this.inicializarInventarioHerramientas();
		
		this.herramientaEquipada = Herramienta.hachaDeMadera();
		this.agregarHerramienta(this.herramientaEquipada);
		
		this.inventarioDeMadera = new Inventario<Madera>();
		this.inventarioDeMetal = new Inventario<Metal>();
		this.inventarioDePiedra = new Inventario<Piedra>();
		this.inventarioDeDiamante = new Inventario<Diamante>();
	}
	
	private void inicializarInventarioHerramientas() {
		this.inventarioDeHerramientas = new HashMap<Herramienta, LinkedList<Herramienta>>();
		
		this.inventarioDeHerramientas.put(Herramienta.hachaDeMadera(), new LinkedList<Herramienta>());
		this.inventarioDeHerramientas.put(Herramienta.hachaDePiedra(), new LinkedList<Herramienta>());
		this.inventarioDeHerramientas.put(Herramienta.hachaDeMetal(), new LinkedList<Herramienta>());
		this.inventarioDeHerramientas.put(Herramienta.picoDeMadera(), new LinkedList<Herramienta>());
		this.inventarioDeHerramientas.put(Herramienta.picoDePiedra(), new LinkedList<Herramienta>());
		this.inventarioDeHerramientas.put(Herramienta.picoDeMetal(), new LinkedList<Herramienta>());
		this.inventarioDeHerramientas.put(Herramienta.picoFino(), new LinkedList<Herramienta>());
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
		this.inventarioDeHerramientas.get(herramienta).add(herramienta);
	}
	
	public Herramienta herramientaEquipada() {
		return (this.herramientaEquipada);
	}
	
	/*
	public void equiparConUltimaHerramienta() {
		this.herramientaEquipada = this.ultimaHerramientaObtenida();
	}
	
	public Herramienta ultimaHerramientaObtenida() {
		return this.inventarioDeHerramientas.ultimoItemAgregado();
	}
	*/

	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public Posicion getPosicionSiguiente() {
		return this.movimiento.getPosicionSiguiente(this.getPosicion());
	}

	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
	
	public void golpear(Material material) throws SinHerramientaEquipadaException {
		probarTieneHerramientaEquipada();
		this.herramientaEquipada.golpear(material);
		if(this.herramientaEquipada.estaRota()){
			tirar(this.herramientaEquipada);
			herramientaEquipada = null;
		}

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
	
	public int cantidadDeHachasDeMadera() {
		Herramienta herramienta = Herramienta.hachaDeMadera();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}
	
	public int cantidadDeHachasDePiedra() {
		Herramienta herramienta = Herramienta.hachaDePiedra();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}
	
	public int cantidadDeHachasDeMetal() {
		Herramienta herramienta = Herramienta.hachaDeMetal();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}
	
	public int cantidadDePicosDeMadera() {
		Herramienta herramienta = Herramienta.picoDeMadera();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}
	
	public int cantidadDePicosDePiedra() {
		Herramienta herramienta = Herramienta.picoDePiedra();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}
	
	public int cantidadDePicosDeMetal() {
		Herramienta herramienta = Herramienta.picoDeMetal();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}
	
	public int cantidadDePicosFinos() {
		Herramienta herramienta = Herramienta.picoFino();
		return this.inventarioDeHerramientas.get(herramienta).size();
	}

	public void equiparHachaDeMadera(){
		equipar(Herramienta.hachaDeMadera());
	}

	public void equiparHachaDePiedra(){
		equipar(Herramienta.hachaDePiedra());
	}

	public void equiparHachaDeMetal(){
		equipar(Herramienta.hachaDeMetal());
	}

	public void equiparPicoDeMadera(){
		equipar(Herramienta.picoDeMadera());
	}

	public void equiparPicoDePiedra(){
		equipar(Herramienta.picoDePiedra());
	}

	public void equiparPicoDeMetal(){
		equipar(Herramienta.picoDeMetal());
	}

	public void equiparPicoFino(){
		equipar(Herramienta.picoFino());
	}

	private void equipar(Herramienta h){
		LinkedList<Herramienta> listaHerramientas = this.inventarioDeHerramientas.get(h);
		Herramienta aEquipar = listaHerramientas.peek();
		if(aEquipar != null) { herramientaEquipada = aEquipar;}
	}

	private void tirar(Herramienta h){
		LinkedList<Herramienta> listaHerramientas = this.inventarioDeHerramientas.get(h);
		listaHerramientas.remove();
	}

	private void probarTieneHerramientaEquipada() throws SinHerramientaEquipadaException {
		if (herramientaEquipada == null){
			throw new SinHerramientaEquipadaException();
		}
	}
}
