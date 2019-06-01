import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
	
	@Test
    void test01JugadorSeInicializaConCeroMateriales() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeMateriales(), 0);
    }
	
	@Test
    void test02JugadorSeInicializaConCeroHerramientas() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeHerramientas(), 0);
    }
	

}
