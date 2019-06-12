package Juego.Jugador;

import Juego.Mapa.Posicion;

public class DireccionEste extends Direccion{
    private static DireccionEste instancia = new DireccionEste();

    public static DireccionEste getInstancia() {
        return instancia;
    }

    private DireccionEste() {
    }

    @Override
    public Posicion siguiente(Posicion posicion) {
        return posicion.derecha();
    }

    @Override
    public Direccion rotar() {
        return DireccionSur.getInstancia();
    }

    @Override
    public Direccion invertir() {
        return DireccionOeste.getInstancia();
    }
}
