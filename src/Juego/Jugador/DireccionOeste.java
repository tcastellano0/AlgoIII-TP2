package Juego.Jugador;

import Juego.Mapa.Posicion;

public class DireccionOeste extends Direccion {

    private static DireccionOeste instancia = new DireccionOeste();

    public static DireccionOeste getInstancia() {
        return instancia;
    }

    private DireccionOeste(){}


    @Override
    public Posicion siguiente(Posicion posicion) {
        return posicion.izquierda();
    }

    @Override
    public Direccion rotar() {
        return DireccionNorte.getInstancia();
    }

    @Override
    public Direccion invertir() {
        return DireccionEste.getInstancia();
    }
}
