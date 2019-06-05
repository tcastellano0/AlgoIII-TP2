import Herramientas.Herramienta;
import Jugador.Jugador;
import org.junit.jupiter.api.Test;
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
    void test04JugadorSeInicializaConUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();
        Herramienta unHacha = Herramienta.hachaDeMadera();

        assertEquals(jugador.herramientaEquipada().getDurabilidad(), unHacha.getDurabilidad());
        assertEquals(jugador.herramientaEquipada().getFuerza(), unHacha.getFuerza());
    }
	
	@Test
    void test05JugadorSeInicializaConLaMismaHachaDeMaderaEquipadaYEnInventario() {
		Jugador jugador = new Jugador();

        assertSame(jugador.herramientaEquipada(), jugador.ultimaHerramientaAgregada());
    }
	
}
