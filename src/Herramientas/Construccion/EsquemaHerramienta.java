package Herramientas.Construccion;
import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;

public abstract class EsquemaHerramienta {


    protected TableroMateriales tablero;

    //protected void vaciar();

    /*
    protected boolean esIgual(EsquemaHerramienta esquemaHerramienta) {
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
        //return this.tablero.esIgual(esquemaHerramienta.tablero);
    }*/

    protected abstract boolean esIgual(EsquemaHerramienta esquemaHerramienta);

    protected boolean miTableroEsIgual(TableroMateriales otroTablero){
        return this.tablero.esIgual(otroTablero);
    }
    public abstract Herramienta construir();

}
