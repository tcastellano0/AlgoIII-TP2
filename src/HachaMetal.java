public class HachaMetal extends Herramienta {

    public HachaMetal() {
        this.durabilidad = 400;
    }

    @Override
    public int getFuerza() {
        return 10;
    }


    public void desgastar() {
        this.durabilidad -= this.getFuerza()/2;
    }
}
