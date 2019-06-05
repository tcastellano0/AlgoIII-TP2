import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import Herramientas.Herramienta;
import Jugador.Inventario;
import org.junit.jupiter.api.Test;

public class InventarioTest {
	
	@Test
    void test01InventarioSeInicializaConCeroItems() {
		Inventario<Herramienta> inventario = new Inventario<Herramienta>();
		
		assertEquals(inventario.cantidad(), 0);
    }
	
	@Test
    void test02InventarioSeLeAgregaUnItemCantidadEs1() {
		Inventario<Herramienta> inventario = new Inventario<Herramienta>();
		Herramienta hacha = Herramienta.hachaDeMadera();
		inventario.agregar(hacha);
		
		assertEquals(inventario.cantidad(), 1);
    }
	
	@Test
    void test03InventarioDevuelveElMismoUltimoItem() {
		Inventario<Herramienta> inventario = new Inventario<Herramienta>();
		Herramienta hacha = Herramienta.hachaDeMadera();
		inventario.agregar(hacha);
		
		assertSame(inventario.ultimoItem(), hacha);
    }

}
