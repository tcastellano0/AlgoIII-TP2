import java.util.ArrayList;

public class Jugador {
	
	protected Herramienta herramientaEquipada;
	protected ArrayList<Herramienta> herramientas;
	protected ArrayList<Material> materiales;
	
	public Jugador() {
		this.herramientaEquipada = Hacha.crearHachaDeMadera();
		this.herramientas = new ArrayList<Herramienta>();
		this.herramientas.add(this.herramientaEquipada);
		this.materiales = new ArrayList<Material>();
	}
	
	public int cantidadDeHerramientas() {
		return (herramientas.size());
	}
	
	public int cantidadDeMateriales() {
		return (materiales.size());
	}
	
	public Herramienta herramientaEquipada() {
		return (herramientaEquipada);
	}
	
}
