package Materiales;

import Herramientas.*;
import Durabilidad.*;


public class Diamante extends Material {

	public Diamante() {
        this.durabilidad = new DurabilidadConFactor(1, 100);
    }
	
	@Override
	public void golpeadoPor(GolpeadorHachaDeMadera golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorHachaDePiedra golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorHachaDeMetal golpeador) { 	}

	@Override
	public void golpeadoPor(GolpeadorPicoDeMadera golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoDePiedra golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoDeMetal golpeador) {
		this.desgastar(golpeador.getFuerza());
	}

	@Override
	public void golpeadoPor(GolpeadorPicoFino golpeador) {
		this.desgastar(golpeador.getFuerza());
	}

	@Override
	public boolean esIgual(Material material){
		return material.esIgual(this);
	}

	@Override
	public boolean esIgual(Madera material) {return false;}

	@Override
	public boolean esIgual(Piedra material) {return false;}

	@Override
	public boolean esIgual(Metal material) {return false;}

	@Override
	public boolean esIgual(Diamante material) {return true;}

}
