package Juego.Mapa;

import java.util.Objects;

public class Posicion {
    private int coordenadaX;
    private int coordenadaY;

    public Posicion(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Posicion arriba(){
        return new Posicion(this.coordenadaX,this.coordenadaY+1);
    }
    public Posicion abajo(){
        return new Posicion(this.coordenadaX,this.coordenadaY-1);
    }
    public Posicion izquierda(){
        return new Posicion(this.coordenadaX-1,this.coordenadaY);
    }
    public Posicion derecha(){
        return new Posicion(this.coordenadaX+1, this.coordenadaY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return coordenadaX == posicion.coordenadaX &&
                coordenadaY == posicion.coordenadaY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenadaX, coordenadaY);
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
}
