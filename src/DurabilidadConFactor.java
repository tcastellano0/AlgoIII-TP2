public class DurabilidadConFactor extends Durabilidad {

    private double factor;

    public DurabilidadConFactor(double factor, double durabilidad){
    	this.factor = factor;
    	this.durabilidad = durabilidad;
    }

    public void desgastar(int fuerza){
        this.durabilidad -= (fuerza / this.factor);
    }

}
