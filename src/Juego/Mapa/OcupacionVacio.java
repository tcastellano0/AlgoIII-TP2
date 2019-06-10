package Juego.Mapa;

public class OcupacionVacio<T> implements EstadoOcupacion<T>{
    @Override
    public void ocupar() {
    }

    @Override
    public void desocupar() {
        throw new ContenedorVacioException();
    }

}
