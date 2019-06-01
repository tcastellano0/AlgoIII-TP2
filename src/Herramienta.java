public abstract class Herramienta implements Desgastable{
	protected int fuerza;
	protected double durabilidad;

    public double getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }
    
}
