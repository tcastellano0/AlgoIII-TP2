public abstract class Herramienta implements Desgastable{
	protected int fuerza;
	protected Durabilidad durabilidad;

    public double getDurabilidad() {
        return this.durabilidad.getDurabilidad();
    }

    public int getFuerza() {
        return this.fuerza;
    }
    
}
