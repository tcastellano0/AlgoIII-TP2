public class Madera extends Material{

    public Madera() {
        this.durabilidad = new DurabilidadConFactor(1, 10);
    }

    public void golpeadoPor(Hacha hacha) {
        this.desgastar(hacha.getFuerza());
    }

    @Override
    public void golpeadoPor(Pico pico) {
        //madera no es afectada por pico
    }
}
