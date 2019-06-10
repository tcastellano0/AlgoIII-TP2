package Herramientas.Construccion;
import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Material;

public abstract class EsquemaHerramienta {


    protected Tablero<Material> tablero;

    //protected void vaciar();


    protected boolean esIgual(EsquemaHerramienta esquemaHerramienta) {
        return this.tablero.equals(esquemaHerramienta.tablero);
    }

    public abstract Herramienta construir();

}
