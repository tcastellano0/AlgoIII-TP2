public class Pico extends Herramienta {

	public Pico(int fuerza, Durabilidad unaDurabilidad) {
		this.fuerza = fuerza;
		this.durabilidad = unaDurabilidad;
	}

	@Override
	public void golpear(Madera madera) {
		//el pico no afecta a la madera
		this.desgastar();
	}

	public static Pico crearPicoDeMadera() {
		return new Pico(2, new DurabilidadConFactor(100, 1));	
	}
	
	public static Pico crearPicoDePiedra() {
		return new Pico(4, new DurabilidadConFactor(200, 1.5));
	}
	
	public static Pico crearPicoDeMetal() {
		return new Pico(12, new DurabilidadConUsos(400, 10));
	}
}

