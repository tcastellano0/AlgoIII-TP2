public class Pico extends Herramienta {

	public Pico(int fuerza, double durabilidad) {
		this.fuerza = fuerza;
		this.durabilidad = durabilidad;
	}
	
	@Override
	public void desgastar() {
		// TODO Auto-generated method stub
	}
	
	public static Pico crearPicoDeMadera() {
		return new Pico(2, 100);	
	}
	
	public static Pico crearPicoDePiedra() {
		return new Pico(4, 200);
	}
	
	public static Pico crearPicoDeMetal() {
		return new Pico(12, 400);
	}
	
}
