package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Madera;
import Materiales.Material;
import Materiales.Metal;

public class EsquemaHachaMetal extends EsquemaHerramienta {

    private static EsquemaHachaMetal ourInstance = new EsquemaHachaMetal();

    public static EsquemaHachaMetal getInstance() {
        return ourInstance;
    }

    private EsquemaHachaMetal(){
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
