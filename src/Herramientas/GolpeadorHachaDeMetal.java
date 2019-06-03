package Herramientas;

import Materiales.Material;

public class GolpeadorHachaDeMetal extends Golpeador {

	public GolpeadorHachaDeMetal() {
		super(10);
	}
	
	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this);
	}
	
}
