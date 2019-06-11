package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.*;

public class EsquemaHachaMadera extends EsquemaHerramienta {

    private static EsquemaHachaMadera ourInstance = new EsquemaHachaMadera();

    public static EsquemaHachaMadera getInstance() {
        return ourInstance;
    }

    private EsquemaHachaMadera(){
        this.tablero = new TableroMateriales(3,3);

        this.tablero.poner(new Madera(),1, 1);
        this.tablero.poner(new Madera(),1, 2);
        this.tablero.poner(new Madera(),2, 1);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);

        /*
        this.tablero.poner(new Madera(), 1, 1);
        this.tablero.poner(new Madera(), 1, 2);
        //this.tablero.poner(new Madera(), 1, 3);
        this.tablero.poner(new Madera(), 2, 1);
        this.tablero.poner(new Madera(), 2, 2);
        //this.tablero.poner(new Madera(), 2, 3);
        //this.tablero.poner(new Madera(), 3, 1);
        this.tablero.poner(new Madera(), 3, 2);
        //this.tablero.poner(new Madera(), 3, 3);
        */
    }

    public Herramienta construir(){
        return Herramienta.hachaDeMadera();
    }

    protected  boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
        //return this.tablero.esIgual(esquemaHerramienta.tablero);
    }

}
