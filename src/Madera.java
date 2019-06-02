public class Madera {

    private DurabilidadConFactor durabilidad;

    public Madera() {
        this.durabilidad = new DurabilidadConFactor(1, 10);
    }

    public double getDurabilidad() {
        return this.durabilidad.getDurabilidad();
    }

    public void golpear(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    public void golpearConHacha(Hacha hacha) {
        this.durabilidad.desgastar(hacha.getFuerza());
    }
}
