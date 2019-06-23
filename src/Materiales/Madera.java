package Materiales;

import Herramientas.*;
import Durabilidad.*;
import Juego.Jugador.Jugador;


public class Madera extends Material{

    public Madera() {
        this.durabilidad = new DurabilidadConFactor(1, 10);
    }
    
    @Override
	public Material recolectar() {
		if(this.getDurabilidad() <= 0)
			return this;
		
		return new MaterialNulo();
	}

    @Override	
    public void golpeadoPor(GolpeadorHachaDeMadera golpeador) {
    	this.desgastar(golpeador.getFuerza());
    }
	
	@Override
    public void golpeadoPor(GolpeadorHachaDePiedra golpeador){
		this.desgastar(golpeador.getFuerza());
    }
    
	@Override
	public void golpeadoPor(GolpeadorHachaDeMetal golpeador){
		this.desgastar(golpeador.getFuerza());
    }
    
	@Override
    public void golpeadoPor(GolpeadorPicoDeMadera golpeador) { }
    
	@Override
    public void golpeadoPor(GolpeadorPicoDePiedra golpeador){ }
	
	@Override
    public void golpeadoPor(GolpeadorPicoDeMetal golpeador){ }
	
	@Override
    public void golpeadoPor(GolpeadorPicoFino golpeador){ }

    @Override
    public boolean esIgual(Material material){
        return material.esIgual(this);
    }

    @Override
	public boolean esIgual(Madera material) {return true;}

    @Override
    public boolean esIgual(Piedra material) {return false;}

    @Override
    public boolean esIgual(Metal material) {return false;}

    @Override
    public boolean esIgual(Diamante material) {return false;}

	@Override
	public boolean esIgual(MaterialNulo material) { return false; }

    public void esGuardadoEn(Jugador j){
        j.guardar(this);
    }

}
