import Herramientas.Herramienta;
import Juego.Jugador.Jugador;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class JugadorTest {
	
	@Test
    public void test01JugadorSeInicializaConCeroMateriales() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeMateriales(), 0);
    }
	
	@Test
    public void test02JugadorSeInicializaConUnaHerramienta() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeHerramientas(), 1);
    }
	
	@Test
    public void test04JugadorSeInicializaConUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();
        Herramienta unHacha = Herramienta.hachaDeMadera();

        assertEquals(jugador.herramientaEquipada().getDurabilidad(), unHacha.getDurabilidad(), 0);
        assertEquals(jugador.herramientaEquipada().getFuerza(), unHacha.getFuerza());
    }
	
	@Test
    public void test05JugadorSeInicializaConLaMismaHachaDeMaderaEquipadaYEnInventario() {
		Jugador jugador = new Jugador();

        assertSame(jugador.herramientaEquipada(), jugador.ultimaHerramientaObtenida());
    }
	
}
