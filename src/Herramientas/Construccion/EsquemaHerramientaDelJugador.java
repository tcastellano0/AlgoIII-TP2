package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Posicion;
import Juego.Mapa.TableroMateriales;
import Materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class EsquemaHerramientaDelJugador extends EsquemaHerramienta {

    private List<EsquemaHerramienta> esquemaHerramientas;

    public static EsquemaHerramientaDelJugador getInstance() {
    	return new EsquemaHerramientaDelJugador();
    }

    private EsquemaHerramientaDelJugador() {
        this.tablero = new TableroMateriales(3,3);

        this.esquemaHerramientas = new ArrayList<>();
        this.esquemaHerramientas.add(EsquemaHachaMadera.getInstance());
        this.esquemaHerramientas.add(EsquemaHachaPiedra.getInstance());
        this.esquemaHerramientas.add(EsquemaHachaMetal.getInstance());
        this.esquemaHerramientas.add(EsquemaPicoMadera.getInstance());
        this.esquemaHerramientas.add(EsquemaPicoPiedra.getInstance());
        this.esquemaHerramientas.add(EsquemaPicoMetal.getInstance());
        this.esquemaHerramientas.add(EsquemaPicoFino.getInstance());
    }

    public void poner(Material material, int fila, int columna){
        this.tablero.poner(material, new Posicion(fila, columna));
    }

    public Material sacar(Posicion pos){
        return this.tablero.sacar(pos);
    }


    public Herramienta construir() {
        for (EsquemaHerramienta esquemaHerramienta : this.esquemaHerramientas) {
            if (esquemaHerramienta.esIgual(this)) {
                return esquemaHerramienta.construir();
            }
        }

        throw new NoExisteEsquemaException();
    }

    public boolean esIgual(EsquemaHerramienta esquemaHerramienta){
        return esquemaHerramienta.miTableroEsIgual(this.tablero);
    }


}
