public class PicoMetal extends Herramienta {
    int usos;

    public PicoMetal() {
        this.durabilidad = 400;
        this.usos = 10;
    }

    @Override
    public double getDurabilidad() {
        if (this.usos > 0 ) {
            return this.durabilidad;
        }
        return 0;
    }

    @Override
    public int getFuerza() {
        return 12;
    }

    public void desgastar(){
        this.usos =- 1;
    }
}
