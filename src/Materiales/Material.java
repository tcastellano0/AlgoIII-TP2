package Materiales;

import Herramientas.*;
import Durabilidad.*;
import Juego.Mapa.Ubicable;

public abstract class Material implements Desgastable, Golpeable, Ubicable {

	protected DurabilidadConFactor durabilidad;

	public double getDurabilidad() {
		return this.durabilidad.getDurabilidad();
	}

	@Override
	public void desgastar(int fuerzaDesgaste) {
		this.durabilidad.desgastar(fuerzaDesgaste);
	}

	@Override
	public void golpeadoPor(Golpeador golpeador) {
		golpeador.golpear(this);
	}

	@Override
	public abstract void golpeadoPor(GolpeadorHachaDeMadera golpeador);
	
	@Override
    public abstract void golpeadoPor(GolpeadorHachaDePiedra golpeador);
    
	@Override
	public abstract void golpeadoPor(GolpeadorHachaDeMetal golpeador);
    
	@Override
    public abstract void golpeadoPor(GolpeadorPicoDeMadera golpeador);
    
	@Override
    public abstract void golpeadoPor(GolpeadorPicoDePiedra golpeador);
	
	@Override
    public abstract void golpeadoPor(GolpeadorPicoDeMetal golpeador);
	
	@Override
    public abstract void golpeadoPor(GolpeadorPicoFino golpeador);

	public boolean esIgual(Material material){
		return (this.getClass()== material.getClass());
	}

}
