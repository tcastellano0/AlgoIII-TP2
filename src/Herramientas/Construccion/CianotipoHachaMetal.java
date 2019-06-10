package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Madera;
import Materiales.Material;
import Materiales.Metal;
import Materiales.Piedra;

public class CianotipoHachaMetal extends Cianotipo {

    private static CianotipoHachaMetal ourInstance = new CianotipoHachaMetal();

    public static CianotipoHachaMetal getInstance() {
        return ourInstance;
    }

    private CianotipoHachaMetal(){
        this.tablero = new Tablero<Material>(3,3);
        this.tablero.poner(new Metal(),1,1);
        this.tablero.poner(new Metal(),1, 2);
        this.tablero.poner(new Metal(),2, 1);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);    }

    public Herramienta construir(){
        return Herramienta.hachaDeMetal();
    }
}
