package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class CianotipoJugador extends Cianotipo {

    private Tablero tablero;
    private List<Cianotipo> cianotipos;

    private static CianotipoJugador ourInstance = new CianotipoJugador();

    public static CianotipoJugador getInstance() {
        return ourInstance;
    }

    private CianotipoJugador() {
        this.tablero = new Tablero<Material>(3,3);
        this.cianotipos = new ArrayList<Cianotipo>();
        this.cianotipos.add(CianotipoHachaMadera.getInstance());
        this.cianotipos.add(CianotipoHachaPiedra.getInstance());
    }

    public void poner(Material material, int fila, int columna){
        this.tablero.poner(material, fila, columna);
    }

    public Material sacar(int fila, int columna){
        return (Material) this.tablero.sacar(fila, columna);
    }


    public Herramienta construir() {
        for (Cianotipo cianotipo : this.cianotipos) {
            if (cianotipo.esIgual(this)) {
                return cianotipo.construir();
            }
        }
        throw new NoExisteCianotipoException();
    }

}
