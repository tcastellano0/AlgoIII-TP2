public abstract class Herramienta implements Desgastable{
    protected double durabilidad;
    protected int fuerza;

    public double getDurabilidad(){
        return this.durabilidad;
    }

    public abstract int getFuerza();
}
