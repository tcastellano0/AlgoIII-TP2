import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
	
	@Test
    void test01JugadorSeInicializaConCeroMateriales() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeMateriales(), 0);
    }
	
	@Test
    void test02JugadorSeInicializaConUnaHerramienta() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeHerramientas(), 1);
    }
	
	@Test
    void test03JugadorSeInicializaConUnHacha() {
		Jugador jugador = new Jugador();
		
		assertTrue((jugador.herramientaEquipada()) instanceof Hacha);
    }
	
	/* falta verificar que sea de madera */

}
