package Herramientas.Construccion;

import Juego.Mapa.Celda;

public class CeldaConstruccion extends Celda<Character> {

    public CeldaConstruccion() {
        super();
        this.setContenido('V');//V de vacio
    }

    public void madera() {
        this.setContenido('M');
    }

    public void piedra() {
        this.setContenido('P');
    }

    public void metal() {
        this.setContenido('E');
    }

    public void diamante() {
        this.setContenido('D');
    }

    public void vacio() {
        this.setContenido('V');
    }
}
