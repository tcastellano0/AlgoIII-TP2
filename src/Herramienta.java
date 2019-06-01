public abstract class Herramienta implements Desgastable{
	protected int fuerza;

    public double getDurabilidad() {
        return this.durabilidad.getDurabilidad();
    }

    public int getFuerza() {
        return this.fuerza;
    }
    
}
