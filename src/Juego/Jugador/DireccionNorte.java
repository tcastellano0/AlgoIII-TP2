package Juego.Jugador;

import Juego.Mapa.Posicion;

public class DireccionNorte extends Direccion {

    private static DireccionNorte instancia = new DireccionNorte();

    public static DireccionNorte getInstancia() {
        return instancia;
    }

    private DireccionNorte() {
    }

    @Override
    public Posicion siguiente(Posicion posicion) {
        return posicion.arriba();
    }

    @Override
    public Direccion rotar() {
        return DireccionEste.getInstancia();
    }

    @Override
    public Direccion invertir() {
        return DireccionSur.getInstancia();
    }
}
