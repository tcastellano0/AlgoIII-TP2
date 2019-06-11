package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.*;

public class EsquemaHachaPiedra extends EsquemaHerramienta {

    private static EsquemaHachaPiedra ourInstance = new EsquemaHachaPiedra();

    public static EsquemaHachaPiedra getInstance() {
    	return ourInstance;
    }

    private EsquemaHachaPiedra(){
        this.tablero = new TableroMateriales(3,3);
        this.tablero.poner(new Piedra(),1, 1);
        this.tablero.poner(new Piedra(),1, 2);
        this.tablero.poner(new Piedra(),2, 1);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);
    }

    public Herramienta construir(){
        return Herramienta.hachaDePiedra();
    }

    protected  boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }
}
