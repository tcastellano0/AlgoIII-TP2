package Herramientas;

import Materiales.Material;

public class GolpeadorPicoFino extends Golpeador {

	public GolpeadorPicoFino() {
		super(20);
	}
	
	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this);
	}
	
}
