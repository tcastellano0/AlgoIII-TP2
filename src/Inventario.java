import java.util.ArrayList;

public class Inventario {
	
	private ArrayList<Desgastable> listaDeItems;
	
	public Inventario() {
		this.listaDeItems = new ArrayList<Desgastable>(); 
	}
	
	public void agregar(Desgastable item) {
		this.listaDeItems.add(item);
	}
	
	public int cantidad() {
		return this.listaDeItems.size();
	}
	
	public Desgastable getUltimoItem() {
		return this.listaDeItems.get(listaDeItems.size() - 1);
	}

}
