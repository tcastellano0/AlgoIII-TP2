package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;

public class EsquemaPicoMadera extends EsquemaHerramienta {

    private static EsquemaPicoMadera ourInstance = new EsquemaPicoMadera();

    public static EsquemaPicoMadera getInstance() {
        return ourInstance;
    }

    private EsquemaPicoMadera(){
        this.tablero = new TableroMateriales(3,3);
        this.tablero.poner(new Madera(),1, 1);
        this.tablero.poner(new Madera(),1, 2);
        this.tablero.poner(new Madera(),1, 3);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);
    }

    public Herramienta construir(){
        return Herramienta.hachaDeMadera();
    }
}
