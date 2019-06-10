package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Madera;
import Materiales.Material;

public class CianotipoPicoMadera extends Cianotipo {

    private static CianotipoPicoMadera ourInstance = new CianotipoPicoMadera();

    public static CianotipoPicoMadera getInstance() {
        return ourInstance;
    }

    private CianotipoPicoMadera(){
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
