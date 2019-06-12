package Juego.Jugador;

import Juego.Mapa.Posicion;

public class Movimiento {
    private Direccion direccion = DireccionNorte.getInstancia();


    public void siguiente(Jugador jugador){
        Posicion nuevaPosicion = direccion.siguiente(jugador.getPosicion());
        jugador.setPosicion(nuevaPosicion);
    }

    public void rotar(){
        this.direccion = this.direccion.rotar();
    }

    public void invertir(){
        this.direccion = this.direccion.invertir();
    }

    public Direccion getDireccion(){
        return this.direccion;
    }
}
