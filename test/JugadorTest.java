import Herramientas.Hacha;
import Jugador.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
		//este test esta mal
		Jugador jugador = new Jugador();
		
		assertTrue((jugador.herramientaEquipada()) instanceof Hacha);
    }
	
	@Test
    void test04JugadorSeInicializaConUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();

        assertEquals(jugador.herramientaEquipada().getDurabilidad(), 100);
        assertEquals(jugador.herramientaEquipada().getFuerza(), 2);
    }
	
	@Test
    void test05JugadorSeInicializaConLaMismaHachaDeMaderaEquipadaYEnInventario() {
		Jugador jugador = new Jugador();

        assertSame(jugador.herramientaEquipada(), jugador.ultimaHerramienta());
    }
	
}
