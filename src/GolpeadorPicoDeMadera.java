public class GolpeadorPicoDeMadera extends Golpeador {

	public GolpeadorPicoDeMadera() {
		super(2);
	}
	
	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this);
	}
	
}
