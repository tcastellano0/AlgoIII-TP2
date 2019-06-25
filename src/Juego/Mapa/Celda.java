package Juego.Mapa;

public class Celda<T> {
	private T contenido;
	private EstadoOcupacion<T> ocupacion;
    

    public Celda() {
        this.ocupacion = new OcupacionVacio<>();
    }

    public Celda(T contenido) {
        this.ocupacion = new OcupacionLleno<>();
        this.contenido = contenido;
    }

    public T sacar() {
        T contenido = this.contenido;
        this.desocupar();
        this.contenido = null;
        return contenido;
    }

    public T ver() {
      //  if (!this.ocupacion.estaVacia())
        return this.contenido;
       // return null;
    }

    public void poner(T contenido) {
        this.ocupar();
        this.contenido = contenido;
    }

    private void desocupar(){
        ocupacion.desocupar();
        ocupacion = new OcupacionVacio<>();
    }
    private void ocupar(){
        ocupacion.ocupar();
        ocupacion = new OcupacionLleno<>();
    }

    public boolean estaVacia(){
        return ocupacion.estaVacia();
    }
}