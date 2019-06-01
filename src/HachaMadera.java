public class HachaMadera extends Herramienta{

    public HachaMadera() {
        this.durabilidad = 100;
    }

    public int getFuerza() {
        return 2;
    }

    public void desgastar(){
        this.durabilidad -= this.getFuerza();
    }
}