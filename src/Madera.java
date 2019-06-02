public class Madera {

    private DurabilidadConFactor durabilidad;

    public Madera() {
        this.durabilidad = new DurabilidadConFactor(10, 1);
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
