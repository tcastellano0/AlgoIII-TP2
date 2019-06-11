package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;
import Materiales.Piedra;
import Materiales.Metal;

public class EsquemaPicoFino extends EsquemaHerramienta {

    private static EsquemaPicoFino ourInstance = new EsquemaPicoFino();

    public static EsquemaPicoFino getInstance() {
    	return ourInstance;
    }

    private EsquemaPicoFino(){
        this.tablero = new TableroMateriales(3,3);
        this.tablero.poner(new Metal(),1, 1);
        this.tablero.poner(new Metal(),1, 2);
        this.tablero.poner(new Metal(),1, 3);
        this.tablero.poner(new Piedra(),2, 1);
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
