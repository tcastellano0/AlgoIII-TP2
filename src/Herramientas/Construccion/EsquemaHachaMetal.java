package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;
import Materiales.Metal;

public class EsquemaHachaMetal extends EsquemaHerramienta {

    private static EsquemaHachaMetal ourInstance = new EsquemaHachaMetal();

    private EsquemaHachaMetal() {
        this.tablero = new TableroMateriales(3, 3);

        this.tablero.poner(new Metal(), new Posicion(1, 1));
        this.tablero.poner(new Metal(), new Posicion(1, 2));
        this.tablero.poner(new Metal(), new Posicion(2, 1));
        this.tablero.poner(new Madera(), new Posicion(2, 2));
        this.tablero.poner(new Madera(), new Posicion(3, 2));
    }

    public static EsquemaHachaMetal getInstance() {
        return ourInstance;
    }

    public Herramienta construir() {
        return Herramienta.hachaDeMetal();
    }

    protected boolean esIgual(EsquemaHerramienta esquemaHerramienta) {
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }
}
