package Herramientas;

import Materiales.Material;

public class GolpeadorHachaDeMadera extends Golpeador {

	public GolpeadorHachaDeMadera() {
		super(2);
	}
	
	@Override
	public void golpear(Material material) {
		material.golpeadoPor(this);
	}
	
}
