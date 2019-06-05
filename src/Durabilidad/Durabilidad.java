package Durabilidad;

public abstract class Durabilidad implements Desgastable{

    protected double durabilidad;

    public abstract void desgastar(int fuerza);
    
    public double getDurabilidad() {
    	return this.durabilidad;
    } 

}
