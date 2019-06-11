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

        this.esquemaHerramientas = new ArrayList<>();
        this.esquemaHerramientas.add(EsquemaHachaMadera.getInstance());
        this.esquemaHerramientas.add(EsquemaHachaPiedra.getInstance());
    }

    public void poner(Material material, int fila, int columna){
        this.tablero.poner(material, fila, columna);
    }

    public Material sacar(int fila, int columna){
        return (Material) this.tablero.sacar(fila, columna);
    }


    public Herramienta construir() {
        /*
        if(EsquemaHachaMadera.getInstance().esIgual(this))
            return EsquemaHachaMadera.getInstance().construir();
        */
        for (EsquemaHerramienta esquemaHerramienta : this.esquemaHerramientas) {
            System.err.println("herramienta");
            if (esquemaHerramienta.esIgual(this)) {
                System.err.println("Construyo");
                Herramienta contruida = esquemaHerramienta.construir();
                System.err.println(contruida.getClass());
                return contruida;
                //return esquemaHerramienta.construir();
            }
        }

        throw new NoExisteEsquemaException();
    }

    protected boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
        //return this.tablero.esIgual(esquemaHerramienta.tablero);
    }


}
