package Durabilidad;

public class DurabilidadConUsos extends Durabilidad {

	private int usosMax;
	private int usosActual;

    public DurabilidadConUsos(int usoMax, double durabilidad){
    	this.usosMax = usoMax;
    	this.durabilidad = durabilidad;
    }
    
	@Override
	public void desgastar(int fuerza) {
		this.usosActual += 1;
		if(this.usosActual >= this.usosMax) {
			this.durabilidad = 0;
		}
	}

}
