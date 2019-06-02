import java.util.ArrayList;

public class Jugador {
	
	private Herramienta herramientaEquipada;
	private ArrayList<Herramienta> herramientas;
	private ArrayList<Material> materiales;
	
	public Jugador() {
		this.herramientaEquipada = Hacha.crearHachaDeMadera();
		this.herramientas = new ArrayList<Herramienta>();
		this.herramientas.add(this.herramientaEquipada);
		this.materiales = new ArrayList<Material>();
	}
	
	public int cantidadDeHerramientas() {
		return (this.herramientas.size());
	}
	
	public int cantidadDeMateriales() {
		return (this.materiales.size());
	}
	
	public Herramienta herramientaEquipada() {
		return (this.herramientaEquipada);
	}
	
}
