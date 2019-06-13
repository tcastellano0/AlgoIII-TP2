package Materiales;

import Herramientas.*;
import Durabilidad.*;
import Juego.Mapa.Ubicable;
import Juego.Mapa.Posicion;

public abstract class Material implements Golpeable, Ubicable {

	protected DurabilidadConFactor durabilidad;

	protected Posicion posicion;

	public double getDurabilidad() {
		return this.durabilidad.getDurabilidad();
	}

	@Override
	public void setPosicion(Posicion pos){
		this.posicion = pos;
	}

	@Override
	public Posicion getPosicion(){
		return this.posicion;
	}

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


	public abstract boolean esIgual(Material material);

	public abstract boolean esIgual(Madera material);

	public abstract boolean esIgual(Piedra material);

	public abstract boolean esIgual(Metal material);

	public abstract boolean esIgual(Diamante material);

}
