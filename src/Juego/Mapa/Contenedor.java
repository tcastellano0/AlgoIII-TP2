package Juego.Mapa;

public interface Contenedor<T> {
    void poner(T contenido);

    T sacar();
    
    T ver();

    boolean estaVacia();
}
