public class PicoMadera extends Herramienta{

    public PicoMadera() {
        this.durabilidad = 100;
    }


    @Override
    public int getFuerza() {
        return 2;
    }

    public void desgastar(){
        this.durabilidad -= this.getFuerza();
    }
}
