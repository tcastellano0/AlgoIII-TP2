package Juego.Mapa;

public interface EstadoOcupacion<T> {
    public void ocupar();

    public void desocupar();

    boolean estaVacia();
}
