package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Madera;
import Materiales.Material;

public class EsquemaPicoMadera extends EsquemaHerramienta {

    private static EsquemaPicoMadera ourInstance = new EsquemaPicoMadera();

    public static EsquemaPicoMadera getInstance() {
        return ourInstance;
    }

    private EsquemaPicoMadera(){
        this.tablero = new Tablero<Material>(3,3);
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
