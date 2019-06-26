package Vista;

import Juego.Mapa.Ubicable;

import java.util.HashMap;
import java.util.Map;
import Materiales.*;
import Juego.Jugador.Jugador;

public class EligeRutaImagenes {


    private static EligeRutaImagenes ourInstance = new EligeRutaImagenes();
    private Map<Class, String> rutaImagenes = new HashMap<>();

    public static EligeRutaImagenes getInstance() {
        return ourInstance;
    }

    private EligeRutaImagenes(){

        rutaImagenes.put(Madera.class, "Vista/images/materiales/map_arbol.png");
        rutaImagenes.put(Piedra.class, "Vista/images/materiales/map_piedra.png");
        rutaImagenes.put(Metal.class, "Vista/images/materiales/map_metal.png");
        rutaImagenes.put(Diamante.class, "Vista/images/materiales/map_diamante.png");
        rutaImagenes.put(Jugador.class, "Vista/images/jugador/map_JugadorAbajo.png");
    }

    public String getRutaImagen(Ubicable u){
        Class<? extends Ubicable> claseUbicable = u.getClass();
        return this.rutaImagenes.get(claseUbicable);
    }

    public String vacio(){
        return "Vista/images/materiales/map_vacio.png";
    }

    public void jugadorMiraArriba(){
        rutaImagenes.put(Jugador.class, "Vista/images/jugador/map_JugadorArriba.png");
    }

    public void jugadorMiraIzquierda(){
        rutaImagenes.put(Jugador.class, "Vista/images/jugador/map_JugadorIzquierda.png");
    }

    public void jugadorMiraDerecha(){
        rutaImagenes.put(Jugador.class, "Vista/images/jugador/map_JugadorDerecha.png");
    }

    public void jugadorMiraAbajo(){
        rutaImagenes.put(Jugador.class, "Vista/images/jugador/map_JugadorAbajo.png");
    }
}
