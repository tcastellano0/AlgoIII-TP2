public class Piedra extends Material {

    public Piedra() {
        this.durabilidad = new DurabilidadConFactor(1, 30);
    }

    @Override
    public void golpeadoPor(Hacha hacha) {
        //la piedra no es afectada por hacha
    }

    @Override
    public void golpeadoPor(Pico pico) {
        this.desgastar(pico.getFuerza());
    }
}
