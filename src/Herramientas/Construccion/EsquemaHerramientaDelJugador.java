package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class EsquemaHerramientaDelJugador extends EsquemaHerramienta {

    private Tablero tablero;
    private List<EsquemaHerramienta> esquemaHerramientas;

    private static EsquemaHerramientaDelJugador ourInstance = new EsquemaHerramientaDelJugador();

    public static EsquemaHerramientaDelJugador getInstance() {
        return ourInstance;
    }

    private EsquemaHerramientaDelJugador() {
        this.tablero = new Tablero<Material>(3,3);
        this.esquemaHerramientas = new ArrayList<EsquemaHerramienta>();
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
        for (EsquemaHerramienta esquemaHerramienta : this.esquemaHerramientas) {
            if (esquemaHerramienta.esIgual(this)) {
                return esquemaHerramienta.construir();
            }
        }
        throw new NoExisteCianotipoException();
    }

}
