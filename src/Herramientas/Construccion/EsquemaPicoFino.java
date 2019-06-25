package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;
import Materiales.Metal;
import Materiales.Piedra;

public class EsquemaPicoFino extends EsquemaHerramienta {

    private static EsquemaPicoFino ourInstance = new EsquemaPicoFino();

    public static EsquemaPicoFino getInstance() {
    	return ourInstance;
    }

    private EsquemaPicoFino(){
        this.tablero = new TableroMateriales(3,3);

        this.tablero.poner(new Metal(),new Posicion(1,1));
        this.tablero.poner(new Metal(),new Posicion(1,2));
        this.tablero.poner(new Metal(),new Posicion(1,3));
        this.tablero.poner(new Piedra(),new Posicion(2,1));
        this.tablero.poner(new Madera(),new Posicion(2,2));
        this.tablero.poner(new Madera(),new Posicion(3,2));
    }

    public Herramienta construir(){
        return Herramienta.picoFino();
    }

    public  boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }
}
