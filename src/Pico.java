public class Pico extends Herramienta {

	public Pico(int fuerza, Durabilidad unaDurabilidad) {
		this.fuerza = fuerza;
		this.durabilidad = unaDurabilidad;
	}
	
	public static Pico crearPicoDeMadera() {
		return new Pico(2, new DurabilidadConFactor(100, 1));	
	}
	
	public static Pico crearPicoDePiedra() {
		return new Pico(4, new DurabilidadConFactor(200, 1.5));
	}
	
	public static Pico crearPicoDeMetal() {
		return new Pico(12, new DurabilidadConFactor(400, 1));
	}
}

