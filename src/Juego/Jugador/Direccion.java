package Juego.Jugador;

import Juego.Mapa.Posicion;

public abstract class Direccion {

    public abstract Posicion siguiente(Posicion posicion);
    public abstract Direccion rotar();
    public abstract Direccion invertir();

}
