
public class DurabilidadConUsos extends Durabilidad {

	private int usosMax;
	private int usosActual;

    public DurabilidadConUsos(double durabilidad, int usoMax){
    	this.durabilidad = durabilidad;
        this.usosMax = usoMax;
    }
    
	@Override
	public void desgastar(int fuerza) {
		this.usosActual += 1;
		if(this.usosActual >= this.usosMax) {
			this.durabilidad = 0;
		}
	}

}
