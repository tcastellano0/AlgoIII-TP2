package Herramientas.Construccion;
import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Material;

public abstract class Cianotipo {


    protected Tablero<Material> tablero;

    //protected void vaciar();


    protected boolean esIgual(Cianotipo cianotipo) {
        return this.tablero.equals(cianotipo.tablero);
    }

    public abstract Herramienta construir();

}
