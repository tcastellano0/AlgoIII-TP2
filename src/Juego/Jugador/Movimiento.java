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
        Posicion nuevaPosicion = direccion.siguiente(posicionInicial);
        try {
        	tablero.sacar(posicionInicial);
        	tablero.poner(jugador, nuevaPosicion);
            jugador.setPosicion(nuevaPosicion);
        } catch (UbicacionInvalidaException e) {
        	tablero.poner(jugador,posicionInicial);
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
}
