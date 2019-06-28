package Juego;

import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import Juego.Jugador.SinHerramientaEquipadaException;
import Juego.Mapa.ContenedorVacioException;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Juego.Mapa.Ubicable;
import Materiales.*;

public class AlgoCraft {

	private static AlgoCraft instancia = new AlgoCraft();
	public static AlgoCraft getInstancia() {
		return instancia;
	}
	
	private Jugador jugador;
	private Tablero<Ubicable> mapa;
	private Movimiento movimiento;

	public Tablero<Ubicable> getMapa() {
		return mapa;
	}

	public Jugador getJugador() {
		return jugador;
	}

	private AlgoCraft() {
		Posicion posicionInicial = new Posicion(1,1);
		
		this.jugador = new Jugador();
		this.jugador.setPosicion(posicionInicial);
		
		this.mapa = new Tablero<Ubicable>(20,20);
		this.inicializarMapa(); //Siempre debe dejar libre posicionInicial
		mapa.poner(this.jugador, posicionInicial);
		
		this.movimiento = new Movimiento(mapa);
		this.jugador.setMovimiento(movimiento);
	}
	
	private void inicializarMapa() {
		this.setUpMadera();
    	this.setUpPiedra();
    	this.setUpMetal();
    	this.setUpDiamante();
	}
    
    private void setUpMadera() {
    	this.mapa.poner(new Madera(), new Posicion(1, 6));
    	this.mapa.poner(new Madera(), new Posicion(1, 8));
    	this.mapa.poner(new Madera(), new Posicion(2, 14));
    	this.mapa.poner(new Madera(), new Posicion(1, 17));
    	this.mapa.poner(new Madera(), new Posicion(1, 20));
    	this.mapa.poner(new Madera(), new Posicion(3, 8));
    	this.mapa.poner(new Madera(), new Posicion(4, 3));
    	this.mapa.poner(new Madera(), new Posicion(4, 5));
    	this.mapa.poner(new Madera(), new Posicion(4, 16));
    	this.mapa.poner(new Madera(), new Posicion(5, 1));
    	this.mapa.poner(new Madera(), new Posicion(5, 10));
    	this.mapa.poner(new Madera(), new Posicion(5, 20));
    	this.mapa.poner(new Madera(), new Posicion(7, 3));
    	this.mapa.poner(new Madera(), new Posicion(8, 15));
    	this.mapa.poner(new Madera(), new Posicion(8, 18));
    	this.mapa.poner(new Madera(), new Posicion(9, 5));
    	this.mapa.poner(new Madera(), new Posicion(10, 3));
    	this.mapa.poner(new Madera(), new Posicion(12, 1));
    	this.mapa.poner(new Madera(), new Posicion(12, 3));
    	this.mapa.poner(new Madera(), new Posicion(12, 15));
    	this.mapa.poner(new Madera(), new Posicion(12, 20));
    	this.mapa.poner(new Madera(), new Posicion(14, 17));
    	this.mapa.poner(new Madera(), new Posicion(15, 4));
    	this.mapa.poner(new Madera(), new Posicion(16, 11));
    	this.mapa.poner(new Madera(), new Posicion(17, 1));
    	this.mapa.poner(new Madera(), new Posicion(17, 8));
    	this.mapa.poner(new Madera(), new Posicion(17, 15));
    	this.mapa.poner(new Madera(), new Posicion(19, 17));
    	this.mapa.poner(new Madera(), new Posicion(20, 5));
    	this.mapa.poner(new Madera(), new Posicion(20, 10));
    	this.mapa.poner(new Madera(), new Posicion(20, 20));
    }
    
    private void setUpPiedra() {
    	this.mapa.poner(new Piedra(), new Posicion(4, 6));
    	this.mapa.poner(new Piedra(), new Posicion(5, 15));
    	this.mapa.poner(new Piedra(), new Posicion(6, 17));
    	this.mapa.poner(new Piedra(), new Posicion(10, 16));
    	this.mapa.poner(new Piedra(), new Posicion(10, 18));
    	this.mapa.poner(new Piedra(), new Posicion(14, 1));
    	this.mapa.poner(new Piedra(), new Posicion(14, 16));
    	this.mapa.poner(new Piedra(), new Posicion(15, 2));
    	this.mapa.poner(new Piedra(), new Posicion(15, 19));
    	this.mapa.poner(new Piedra(), new Posicion(16, 6));
    	this.mapa.poner(new Piedra(), new Posicion(17, 18));
    	this.mapa.poner(new Piedra(), new Posicion(19, 14));
    	this.mapa.poner(new Piedra(), new Posicion(20, 1));
    }
    
    private void setUpMetal() {
    	this.mapa.poner(new Metal(), new Posicion(7, 7));
    	this.mapa.poner(new Metal(), new Posicion(7, 8));
    	this.mapa.poner(new Metal(), new Posicion(7, 9));
    	this.mapa.poner(new Metal(), new Posicion(7, 10));
    	this.mapa.poner(new Metal(), new Posicion(7, 11));
    	this.mapa.poner(new Metal(), new Posicion(7, 12));
    	this.mapa.poner(new Metal(), new Posicion(7, 13));
    	this.mapa.poner(new Metal(), new Posicion(8, 7));
    	this.mapa.poner(new Metal(), new Posicion(8, 8));
    	this.mapa.poner(new Metal(), new Posicion(8, 9));
    	this.mapa.poner(new Metal(), new Posicion(8, 10));
    	this.mapa.poner(new Metal(), new Posicion(8, 11));
    	this.mapa.poner(new Metal(), new Posicion(8, 12));
    	this.mapa.poner(new Metal(), new Posicion(8, 13));
    	this.mapa.poner(new Metal(), new Posicion(9, 7));
    	this.mapa.poner(new Metal(), new Posicion(9, 8));
    	this.mapa.poner(new Metal(), new Posicion(9, 12));
    	this.mapa.poner(new Metal(), new Posicion(9, 13));
    	this.mapa.poner(new Metal(), new Posicion(10, 7));
    	this.mapa.poner(new Metal(), new Posicion(10, 8));
    	this.mapa.poner(new Metal(), new Posicion(10, 12));
    	this.mapa.poner(new Metal(), new Posicion(10, 13));
    	this.mapa.poner(new Metal(), new Posicion(11, 7));
    	this.mapa.poner(new Metal(), new Posicion(11, 8));
    	this.mapa.poner(new Metal(), new Posicion(11, 12));
    	this.mapa.poner(new Metal(), new Posicion(11, 13));
    	this.mapa.poner(new Metal(), new Posicion(12, 7));
    	this.mapa.poner(new Metal(), new Posicion(12, 8));
    	this.mapa.poner(new Metal(), new Posicion(12, 9));
    	this.mapa.poner(new Metal(), new Posicion(12, 10));
    	this.mapa.poner(new Metal(), new Posicion(12, 11));
    	this.mapa.poner(new Metal(), new Posicion(12, 12));
    	this.mapa.poner(new Metal(), new Posicion(12, 13));
    	this.mapa.poner(new Metal(), new Posicion(13, 7));
    	this.mapa.poner(new Metal(), new Posicion(13, 8));
    	this.mapa.poner(new Metal(), new Posicion(13, 9));
    	this.mapa.poner(new Metal(), new Posicion(13, 10));
    	this.mapa.poner(new Metal(), new Posicion(13, 11));
    	this.mapa.poner(new Metal(), new Posicion(13, 12));
    	this.mapa.poner(new Metal(), new Posicion(13, 13));
    }
    
    private void setUpDiamante() {
    	this.mapa.poner(new Diamante(), new Posicion(10, 10));
    }

    public Ubicable verEnPosicion(Posicion pos){
		return this.mapa.ver(pos);
	}
    
    public void golpearMaterialSiguiente() throws SinHerramientaEquipadaException {
    	Posicion posicionSiguiente = this.posicionSiguenteDelJugador();
    	try {
    		Material materialSiguiente = (Material)this.verEnPosicion(posicionSiguiente);
    		
    		this.jugador.golpear(materialSiguiente);

    		sacarMaterialRoto(posicionSiguiente, materialSiguiente);
    	}
    	catch (ContenedorVacioException e) { }
    	catch (NullPointerException e) { }
    	catch (ClassCastException e) { }
    }

    private void sacarMaterialRoto(Posicion pos, Material mat){
		if (mat.getDurabilidad() <= 0) {

			this.mapa.sacar(pos);
		}
	}

	public Posicion posicionDelJugador(){
		return jugador.getPosicion();
	}
	
	public Posicion posicionSiguenteDelJugador() {
		return jugador.getPosicionSiguiente();
	}
	
	public void moverJugadorArriba() {
		this.jugador.moverArriba();
	}

	public void moverJugadorAbajo() {
		this.jugador.moverAbajo();
	}
	
	public void moverJugadorIzquierda() {
		this.jugador.moverIzquierda();
	}
	
	public void moverJugadorDerecha() {
		this.jugador.moverDerecha();
	}

}
