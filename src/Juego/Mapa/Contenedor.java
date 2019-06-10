package Juego.Mapa;

public interface Contenedor<T> {
    public void poner(T contenido);

    public T sacar();
    
    public T ver();
}
