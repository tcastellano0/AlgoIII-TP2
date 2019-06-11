package Juego.Mapa;

public class Celda<T> implements Contenedor<T> {
	private T contenido;
	private EstadoOcupacion<T> ocupacion;
    

    public Celda() {
        this.ocupacion = new OcupacionVacio<>();
    }

    public Celda(T contenido) {
        this.ocupacion = new OcupacionLleno<>();
        this.contenido = contenido;

    }

    @Override
    public T sacar() {
        this.desocupar();
        return contenido;
    }
    
    @Override
    public T ver() {
        return this.contenido;
    }

    @Override
    public void poner(T contenido) {
        this.contenido = contenido;
        this.ocupar();

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