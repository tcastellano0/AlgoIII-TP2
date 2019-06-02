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
    void test03JugadorSeInicializaConUnHachaEquipada() {
		Jugador jugador = new Jugador();
		
		assertTrue((jugador.herramientaEquipada()) instanceof Hacha);
    }
	
	@Test
    void test04JugadorSeInicializaConUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();

        assertEquals(jugador.herramientaEquipada().getDurabilidad(), 100);
        assertEquals(jugador.herramientaEquipada().getFuerza(), 2);
    }

}
