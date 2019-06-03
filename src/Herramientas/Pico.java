package Herramientas;

import Materiales.Material;
import Durabilidad.*;

public class Pico extends Herramienta {

	public Pico(Durabilidad unaDurabilidad, Golpeador golpeador) {
		this.durabilidad = unaDurabilidad;
		this.golpeador = golpeador;
	}

	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this.golpeador);
		this.desgastar(this.getFuerza());
	}

	public static Pico crearPicoDeMadera() {
		return new Pico(new DurabilidadConFactor(1, 100), new GolpeadorPicoDeMadera());
	}
	
	public static Pico crearPicoDePiedra() {
		return new Pico(new DurabilidadConFactor(1.5, 200), new GolpeadorPicoDePiedra());
	}
	
	public static Pico crearPicoDeMetal() {
		return new Pico(new DurabilidadConUsos(10, 400), new GolpeadorPicoDeMetal());
	}
	
	public static Pico crearPicoFino() {
		return new Pico(new DurabilidadConFactor(10, 1000), new GolpeadorPicoFino());
	}
}

