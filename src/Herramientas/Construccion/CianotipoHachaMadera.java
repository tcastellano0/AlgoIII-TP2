package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.*;

public class CianotipoHachaMadera extends Cianotipo {

    private static CianotipoHachaMadera ourInstance = new CianotipoHachaMadera();

    public static CianotipoHachaMadera getInstance() {
        return ourInstance;
    }

    private CianotipoHachaMadera(){
        this.tablero = new Tablero<Material>(3,3);
        this.tablero.poner(new Madera(),1, 1);
        this.tablero.poner(new Madera(),1, 2);
        this.tablero.poner(new Madera(),2, 1);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);
    }

    public Herramienta construir(){
        return Herramienta.hachaDeMadera();
    }
}
