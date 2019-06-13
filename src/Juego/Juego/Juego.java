package Juego.Juego;

import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import Juego.Mapa.Mapa;
import Juego.Mapa.Posicion;

public class Juego {
	
	private Jugador jugador;
	private Mapa mapa;
	private Movimiento movimiento;
	
	public Juego() {
		Posicion posicionInicial = new Posicion(1,1);
		
		this.jugador = new Jugador();
		this.jugador.setPosicion(posicionInicial);
		
		this.mapa = new Mapa();
		mapa.poner(this.jugador, posicionInicial);
		
		this.movimiento = new Movimiento(mapa);
	}

}
