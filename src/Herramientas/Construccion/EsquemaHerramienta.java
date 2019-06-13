package Herramientas.Construccion;
import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;

public abstract class EsquemaHerramienta {


    protected TableroMateriales tablero;

    public abstract boolean esIgual(EsquemaHerramienta esquemaHerramienta);

    protected boolean miTableroEsIgual(TableroMateriales otroTablero){
        return this.tablero.esIgual(otroTablero);
    }
    
    public abstract Herramienta construir();

}
