package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;
import Materiales.Piedra;

public class EsquemaPicoPiedra extends EsquemaHerramienta {

    private static EsquemaPicoPiedra ourInstance = new EsquemaPicoPiedra();

    public static EsquemaPicoPiedra getInstance() {
    	return ourInstance;
    }

    private EsquemaPicoPiedra(){
        this.tablero = new TableroMateriales(3,3);
        this.tablero.poner(new Piedra(),1, 1);
        this.tablero.poner(new Piedra(),1, 2);
        this.tablero.poner(new Piedra(),1, 3);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);
    }

    public Herramienta construir(){
        return Herramienta.picoDePiedra();
    }

    protected  boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }
}
