package Durabilidad;

public abstract class Durabilidad {

    protected double durabilidad;

    public abstract void desgastar(int fuerza);
    
    public double getDurabilidad() {
    	return this.durabilidad;
    } 

}
