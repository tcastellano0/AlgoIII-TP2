package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.TableroMateriales;
import Materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class EsquemaHerramientaDelJugador extends EsquemaHerramienta {

    private List<EsquemaHerramienta> esquemaHerramientas;

    private static EsquemaHerramientaDelJugador ourInstance = new EsquemaHerramientaDelJugador();

    public static EsquemaHerramientaDelJugador getInstance() {
        return ourInstance;
    }

    private EsquemaHerramientaDelJugador() {
        this.tablero = new TableroMateriales(3,3);
        /*
        this.tablero.poner(new Madera(), 1, 1);
        this.tablero.poner(new Madera(), 1, 2);
        this.tablero.poner(new Madera(), 1, 3);
        this.tablero.poner(new Madera(), 2, 1);
        this.tablero.poner(new Madera(), 2, 2);
        this.tablero.poner(new Madera(), 2, 3);
        this.tablero.poner(new Madera(), 3, 1);
        this.tablero.poner(new Madera(), 3, 2);
        this.tablero.poner(new Madera(), 3, 3);
        */
        this.esquemaHerramientas = new ArrayList<>();
        this.esquemaHerramientas.add(EsquemaHachaMadera.getInstance());
        //this.esquemaHerramientas.add(EsquemaHachaPiedra.getInstance());
    }

    public void poner(Material material, int fila, int columna){
        this.tablero.poner(material, fila, columna);
    }

    public Material sacar(int fila, int columna){
        return (Material) this.tablero.sacar(fila, columna);
    }


    public Herramienta construir() {

        if(EsquemaHachaMadera.getInstance().esIgual(this))
            return EsquemaHachaMadera.getInstance().construir();
        /*
        for (EsquemaHerramienta esquemaHerramienta : this.esquemaHerramientas) {
            System.err.println("herramienta");
            if (esquemaHerramienta.esIgual(this)) {
                return esquemaHerramienta.construir();
            }
        }*/
        throw new NoExisteEsquemaException();
    }

}
