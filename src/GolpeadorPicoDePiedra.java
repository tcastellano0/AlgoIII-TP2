public class GolpeadorPicoDePiedra extends Golpeador {

	public GolpeadorPicoDePiedra() {
		super(4);
	}
	
	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this);
	}
	
}
