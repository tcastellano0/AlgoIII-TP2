package Herramientas.Construccion;

import Herramientas.Herramienta;
import Juego.Mapa.Tablero;
import Materiales.*;

public class CianotipoHachaPiedra extends Cianotipo {

    private static CianotipoHachaPiedra ourInstance = new CianotipoHachaPiedra();

    public static CianotipoHachaPiedra getInstance() {
        return ourInstance;
    }

    private CianotipoHachaPiedra(){
        this.tablero = new Tablero<Material>(3,3);
        this.tablero.poner(new Piedra(),1, 1);
        this.tablero.poner(new Piedra(),1, 2);
        this.tablero.poner(new Piedra(),2, 1);
        this.tablero.poner(new Madera(),2, 2);
        this.tablero.poner(new Madera(),3, 2);
    }

    public Herramienta construir(){
        return Herramienta.hachaDePiedra();
    }
}
