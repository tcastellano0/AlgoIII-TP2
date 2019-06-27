package Juego.Jugador;

public class SinHerramientaEquipadaException extends Throwable {
    @Override
    public String getMessage(){
    return "¡No tienes ninguna herramienta equipada!";}
}
