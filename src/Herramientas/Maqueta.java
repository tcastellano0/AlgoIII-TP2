package Herramientas;
import Materiales.*;

public class Maqueta {

	protected Material [][] matrizDeMateriales;
	
	public Maqueta() {
		int filas = this.getCantidadFilas(),
			columnas = this.getCantidadColumnas();

		this.matrizDeMateriales = new Material [filas][columnas];
	}
	
	public int getCantidadColumnas() {
		return 3;
	}
	
	public int getCantidadFilas() {
		return 3;
	}
	
	public void agregarMaterialEnCelda(int fila, int columma, Material material) {
		this.matrizDeMateriales[fila][columma] = material;
	}
	
	public Material getMaterialEnCelda(int fila, int columma) {
		return this.matrizDeMateriales[fila][columma];
	}

	public boolean esIgualA(Maqueta unaMaqueta) {
		for (int fila = 0; fila < this.getCantidadFilas(); fila++) {
			for (int columna = 0; columna < this.getCantidadColumnas(); columna++) {
				
				Material materialMaqueta = this.getMaterialEnCelda(fila, columna);
				Material materialOtraMaqueta = unaMaqueta.getMaterialEnCelda(fila, columna);
				
				//Esto es una re contra mierda, pero cuando la matriz se crea, todos los espacios
				//en blanco son null. Cuando este listo el tablero, esto va a volar.
				if(materialMaqueta == null && materialOtraMaqueta == null)
					continue;
				
				if((materialMaqueta == null && materialOtraMaqueta != null) ||
				   (materialMaqueta != null && materialOtraMaqueta == null))
					return false;
				
				if(materialMaqueta.getClass() != materialOtraMaqueta.getClass())
					return false;
			}
		}
		return true;
	}
	
}
