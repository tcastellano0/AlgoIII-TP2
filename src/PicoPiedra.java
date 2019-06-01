public class PicoPiedra extends Herramienta {

    public PicoPiedra() {
        this.durabilidad = 200;
    }

    @Override
    public int getFuerza() {
        return 4;
    }

    public void desgastar(){
        this.durabilidad -= this.getFuerza()/1.5;
    }
}
