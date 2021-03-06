package Materiales;

import Herramientas.*;
import Durabilidad.*;
import Juego.Jugador.Jugador;

public class Metal extends Material {

	public Metal() {
        this.durabilidad = new DurabilidadConFactor(1, 50);
    }
	
	@Override
	public Material recolectar() {
		if(this.getDurabilidad() <= 0)
			return this;
		
		return new MaterialNulo();
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
	public void golpeadoPor(GolpeadorPicoDePiedra golpeador) {
		this.desgastar(golpeador.getFuerza());
	}

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
	public boolean esIgual(Metal material) {return true;}

	@Override
	public boolean esIgual(Diamante material) {return false;}

	@Override
	public boolean esIgual(MaterialNulo material) { return false; }

	public void esGuardadoEn(Jugador j){
		j.guardar(this);
	}
}
