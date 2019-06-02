public class Madera extends Material{

    public Madera() {
        super();
    }

    public void golpeadoPor(Hacha hacha) {
        this.desgastar(hacha.getFuerza());
    }

    @Override
    public void golpeadoPor(Pico pico) {
        //madera no es afectada por pico
    }
}
