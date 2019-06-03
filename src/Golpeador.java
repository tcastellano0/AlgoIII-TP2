public abstract class Golpeador {

	protected int fuerza;
	
	public Golpeador(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public int getFuerza() {
		return this.fuerza;
	}
	
	public abstract void golpear(Material material);
}
