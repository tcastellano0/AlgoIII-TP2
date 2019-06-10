package Juego.Mapa;

public class Celda<T> implements Contenedor<T> {
    private EstadoOcupacion<T> ocupacion;
    private T contenido;

    public Celda() {
        this.ocupacion = new OcupacionVacio<>();
    }

    public Celda(T contenido) {
        this.ocupacion = new OcupacionLleno<>();
        this.contenido = contenido;

    }

    @Override
    public T getContenido() {
        desocupar();
        return contenido;
    }

    @Override
    public void setContenido(T contenido) {
        this.contenido = contenido;
        ocupar();

    }

    private void desocupar(){
        ocupacion.desocupar();
        ocupacion = new OcupacionVacio<>();
    }
    private void ocupar(){
        ocupacion.ocupar();
        ocupacion = new OcupacionLleno<>();
    }

}