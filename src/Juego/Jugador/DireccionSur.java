package Juego.Jugador;

import Juego.Mapa.Posicion;

public class DireccionSur extends Direccion {

    private static DireccionSur instancia = new DireccionSur();

    public static DireccionSur getInstancia() {
        return instancia;
    }

    private DireccionSur(){}

    @Override
    public Posicion siguiente(Posicion posicion) {
        return posicion.abajo();
    }

    @Override
    public Direccion rotar() {
        return DireccionOeste.getInstancia();
    }

    @Override
    public Direccion invertir() {
        return DireccionNorte.getInstancia();
    }
}
