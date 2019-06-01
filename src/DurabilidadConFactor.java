public class DurabilidadConFactor extends Durabilidad {

    protected double factor;

    public DurabilidadConFactor(double durabilidad, double factor){
        this.durabilidad = durabilidad;
        this.factor = factor;
    }

    public void desgastar(int fuerza){
        this.durabilidad -= fuerza * this.factor;
    }

}
