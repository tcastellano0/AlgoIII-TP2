package Juego.Mapa;

public interface EstadoOcupacion<T> {
    void ocupar();

    void desocupar();

    boolean estaVacia();
}
