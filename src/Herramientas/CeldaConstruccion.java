package Herramientas;

public class CeldaConstruccion {
    private char letra;

    public CeldaConstruccion() {
        this.letra = 'V'; //V de vacio
    }

    public void madera() {
        this.letra = 'M';
    }

    public void piedra() {
        this.letra = 'P';
    }

    public void metal() {
        this.letra = 'M';
    }

    public void diamante() {
        this.letra = 'D';
    }

    public void vacio() {
        this.letra = 'V';
    }

    public char material() {
        return this.letra;
    }

}
