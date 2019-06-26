package Vista;

import Juego.Mapa.Ubicable;

import java.util.HashMap;
import java.util.Map;
import Materiales.*;
import Juego.Jugador.Jugador;

public class EligeVistas {


    private static EligeVistas ourInstance = new EligeVistas();
    private Map<Class, String> rutaVistas = new HashMap<>();

    public static EligeVistas getInstance() {
        return ourInstance;
    }

    private EligeVistas(){

        rutaVistas.put(Madera.class, "Vista/images/materiales/map_arbol.png");
        rutaVistas.put(Piedra.class, "Vista/images/materiales/map_piedra.png");
        rutaVistas.put(Metal.class, "Vista/images/materiales/map_metal.png");
        rutaVistas.put(Diamante.class, "Vista/images/materiales/map_diamante.png");
        rutaVistas.put(Jugador.class, "Vista/images/jugador/map_JugadorAbajo.png");
    }

    public String getRutaImagen(Ubicable u){
        Class<? extends Ubicable> claseUbicable = u.getClass();
        return this.rutaVistas.get(claseUbicable);
    }

    public String vacio(){
        return "Vista/images/materiales/map_vacio.png";
    }

    public void jugadorMiraArriba(){
        rutaVistas.put(Jugador.class, "Vista/images/jugador/map_JugadorArriba.png");
    }

    public void jugadorMiraIzquierda(){
        rutaVistas.put(Jugador.class, "Vista/images/jugador/map_JugadorIzquierda.png");
    }

    public void jugadorMiraDerecha(){
        rutaVistas.put(Jugador.class, "Vista/images/jugador/map_JugadorDerecha.png");
    }

    public void jugadorMiraAbajo(){
        rutaVistas.put(Jugador.class, "Vista/images/jugador/map_JugadorAbajo.png");
    }
}
