package Herramientas;

import Materiales.Material;

public class GolpeadorPicoDeMetal extends Golpeador {

	public GolpeadorPicoDeMetal() {
		super(12);
	}
	
	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this);
	}
	
}
