public class HachaPiedra extends Herramienta {

    public HachaPiedra() {
        this.durabilidad = 200;
    }

    @Override
    public int getFuerza() {
        return 5;
    }

    public void desgastar() {
        this.durabilidad -= this.getFuerza();
    }
}
