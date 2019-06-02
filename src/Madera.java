public class Madera implements Desgastable {

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

    @Override
    public void desgastar(int fuerzaDesgaste) {
        this.durabilidad.desgastar(fuerzaDesgaste);
    }

    public void golpearConHacha(Hacha hacha) {
        this.desgastar(hacha.getFuerza());
    }


}
