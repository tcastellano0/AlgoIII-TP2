package Juego.Mapa;

import java.util.HashMap;
import java.util.Map;

public class OcupacionVacio<T> implements EstadoOcupacion<T>{
    @Override
    public void ocupar() {
    }

    @Override
    public void desocupar() {
        throw new ContenedorVacioException();
    }

}
