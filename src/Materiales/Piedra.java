package Materiales;

import Herramientas.*;
import Durabilidad.*;

public class Piedra extends Material {

    public Piedra() {
        this.durabilidad = new DurabilidadConFactor(1, 30);
    }

    @Override	
    public void golpeadoPor(GolpeadorHachaDeMadera golpeador) { }
	
	@Override
    public void golpeadoPor(GolpeadorHachaDePiedra golpeador) { }
    
	@Override
	public void golpeadoPor(GolpeadorHachaDeMetal golpeador) { }
    
	@Override
    public void golpeadoPor(GolpeadorPicoDeMadera golpeador) {
		this.desgastar(golpeador.getFuerza());
	}
    
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
}
