package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.Madera;
import Materiales.Metal;

public class EsquemaPicoMetal extends EsquemaHerramienta {

    private static EsquemaPicoMetal ourInstance = new EsquemaPicoMetal();

    public static EsquemaPicoMetal getInstance() {
    	return ourInstance;
    }

    private EsquemaPicoMetal(){
        this.tablero = new TableroMateriales(3,3);
        
        this.tablero.poner(new Metal(),1, 1);
        this.tablero.poner(new Metal(),1, 2);
        this.tablero.poner(new Metal(),1, 3);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);
    }

    public Herramienta construir(){
        return Herramienta.picoDeMetal();
    }

    protected  boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }
}
