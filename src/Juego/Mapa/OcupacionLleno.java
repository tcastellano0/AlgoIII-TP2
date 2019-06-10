package Juego.Mapa;

public class OcupacionLleno<T> implements EstadoOcupacion<T> {

    @Override
    public void ocupar(){
        throw new ContenedorOcupadoException();
    }

    @Override
    public void desocupar() {
    }

}
