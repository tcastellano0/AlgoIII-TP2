package Juego.Jugador;

import Juego.Mapa.Mapa;
import Juego.Mapa.Posicion;
import Juego.Mapa.UbicacionInvalidaException;

public class Movimiento {
    private Mapa mapa;
    private Direccion direccion = DireccionNorte.getInstancia();

    public Movimiento(Mapa mapa) {
        this.mapa = mapa;
    }

    public void avanzar(Jugador jugador) {
        Posicion posicionInicial = jugador.getPosicion();
        Posicion nuevaPosicion = direccion.siguiente(posicionInicial);
        try {
            mapa.sacar(posicionInicial);
            mapa.poner(jugador, nuevaPosicion);
            jugador.setPosicion(nuevaPosicion);
        } catch (UbicacionInvalidaException e) {
            mapa.poner(jugador,posicionInicial);
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
