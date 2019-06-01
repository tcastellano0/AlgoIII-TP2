public abstract class Herramienta implements Desgastable{
    protected double durabilidad;

    public double getDurabilidad(){
        return this.durabilidad;
    }

    public abstract int getFuerza();
}
