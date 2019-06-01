import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	protected Herramienta herramientaEquipada;
	protected List herramientas;
	protected List materiales;
	
	public Jugador() {
		this.herramientaEquipada = Hacha.crearHachaDeMadera();
		this.herramientas = new ArrayList();
		this.herramientas.add(this.herramientaEquipada);
		this.materiales = new ArrayList();
	}
	
}
