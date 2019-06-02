public abstract class Herramienta implements Desgastable{

	protected int fuerza;
	protected Durabilidad durabilidad;

    public double getDurabilidad() {
        return this.durabilidad.getDurabilidad();
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void desgastar(int fuerzaDesgaste){
        this.durabilidad.desgastar(fuerzaDesgaste);
    }

    public abstract void golpear(Madera madera);
}
