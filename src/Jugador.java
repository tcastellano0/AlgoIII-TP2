import java.util.ArrayList;

public class Jugador {
	
	private Herramienta herramientaEquipada;
	private ArrayList<Herramienta> inventarioDeHerramientas;
	private ArrayList<Material> inventarioDeMateriales;
	
	public Jugador() {
		this.herramientaEquipada = Hacha.crearHachaDeMadera();
		this.inventarioDeHerramientas = new ArrayList<Herramienta>();
		this.inventarioDeHerramientas.add(this.herramientaEquipada);
		this.inventarioDeMateriales = new ArrayList<Material>();
	}
	
	public int cantidadDeHerramientas() {
		return (this.inventarioDeHerramientas.size());
	}
	
	public int cantidadDeMateriales() {
		return (this.inventarioDeMateriales.size());
	}
	
	public Herramienta herramientaEquipada() {
		return (this.herramientaEquipada);
	}
	
}
