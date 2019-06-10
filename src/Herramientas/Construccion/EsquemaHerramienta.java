package Herramientas.Construccion;
import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;

public abstract class EsquemaHerramienta {


    protected TableroMateriales tablero;

    //protected void vaciar();


    protected boolean esIgual(EsquemaHerramienta esquemaHerramienta) {
        return this.tablero.esIgual(esquemaHerramienta.tablero);
    }

    public abstract Herramienta construir();

}
