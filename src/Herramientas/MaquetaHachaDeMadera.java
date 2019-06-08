package Herramientas;
import Materiales.*;

public class MaquetaHachaDeMadera extends Maqueta {

	public MaquetaHachaDeMadera() {
		super();
		
		this.agregarMaterialEnCelda(0, 0, new Madera());
		this.agregarMaterialEnCelda(0, 1, new Madera());
		this.agregarMaterialEnCelda(1, 0, new Madera());
		this.agregarMaterialEnCelda(1, 1, new Madera());
		this.agregarMaterialEnCelda(2, 1, new Madera());
	}
	
}
