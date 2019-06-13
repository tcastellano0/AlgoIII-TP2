package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;
import Materiales.Metal;

public class EsquemaPicoMetal extends EsquemaHerramienta {

    private static EsquemaPicoMetal ourInstance = new EsquemaPicoMetal();

    private EsquemaPicoMetal() {
        this.tablero = new TableroMateriales(3, 3);

        this.tablero.poner(new Metal(), new Posicion(1, 1));
        this.tablero.poner(new Metal(), new Posicion(1, 2));
        this.tablero.poner(new Metal(), new Posicion(1, 3));
        this.tablero.poner(new Madera(), new Posicion(2, 2));
        this.tablero.poner(new Madera(), new Posicion(3, 2));
    }

    public static EsquemaPicoMetal getInstance() {
        return ourInstance;
    }

    public Herramienta construir() {
        return Herramienta.picoDeMetal();
    }

    public boolean esIgual(EsquemaHerramienta esquemaHerramienta) {
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }
}
