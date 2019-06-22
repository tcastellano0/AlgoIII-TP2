package Materiales;

import Herramientas.GolpeadorHachaDeMadera;
import Herramientas.GolpeadorHachaDeMetal;
import Herramientas.GolpeadorHachaDePiedra;
import Herramientas.GolpeadorPicoDeMadera;
import Herramientas.GolpeadorPicoDeMetal;
import Herramientas.GolpeadorPicoDePiedra;
import Herramientas.GolpeadorPicoFino;

public class MaterialNulo extends Material {

	@Override
	public void golpeadoPor(GolpeadorHachaDeMadera golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorHachaDePiedra golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorHachaDeMetal golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoDeMadera golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoDePiedra golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoDeMetal golpeador) { }

	@Override
	public void golpeadoPor(GolpeadorPicoFino golpeador) { }

	@Override
	public boolean esIgual(Material material){
		return material.esIgual(this);
	}

	@Override
	public boolean esIgual(Madera material) { return false; }

	@Override
	public boolean esIgual(Piedra material) { return false; }

	@Override
	public boolean esIgual(Metal material) { return false; }

	@Override
	public boolean esIgual(Diamante material) {return false; }
	
	@Override
	public boolean esIgual(MaterialNulo material) { return true; }


}
