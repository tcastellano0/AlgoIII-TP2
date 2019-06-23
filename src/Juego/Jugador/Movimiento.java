package Juego.Jugador;

import Juego.Mapa.*;


public class Movimiento {
    private Tablero<Ubicable> tablero;
    private Direccion direccion = DireccionNorte.getInstancia();

    public Movimiento(Tablero<Ubicable> tablero) {
        this.tablero = tablero;
    }

    public void avanzar(Jugador jugador) {
        Posicion posicionInicial = jugador.getPosicion();
        Posicion nuevaPosicion = this.getPosicionSiguiente(posicionInicial);
        
        try {
        	tablero.poner(jugador, nuevaPosicion);
        	tablero.sacar(posicionInicial);
            jugador.setPosicion(nuevaPosicion);


        } catch (UbicacionInvalidaException e) {
            invertir();
        }
    }

    public void rotar() {
        this.direccion = this.direccion.rotar();
    }

    public void invertir() {
        this.direccion = this.direccion.invertir();
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void moverArriba(Jugador jugador) {
        this.direccion = DireccionNorte.getInstancia();
        this.avanzar(jugador);
    }
    
    public void moverAbajo(Jugador jugador) {
        this.direccion = DireccionSur.getInstancia();
        this.avanzar(jugador);
    }
    
    public void moverDerecha(Jugador jugador) {
        this.direccion = DireccionEste.getInstancia();
        this.avanzar(jugador);
    }
    
    public void moverIzquierda(Jugador jugador) {
        this.direccion = DireccionOeste.getInstancia();
        this.avanzar(jugador);
    }
    
    public Posicion getPosicionSiguiente(Posicion posicion) {
    	return this.direccion.siguiente(posicion);
    }
    
}
