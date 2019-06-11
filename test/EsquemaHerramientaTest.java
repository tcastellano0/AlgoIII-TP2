import Herramientas.Construccion.*;
import Herramientas.Herramienta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EsquemaHerramientaTest {

	@Test
	void testEsquemaHerramientaJugadorVacioConstruirLanzaNoExisteEsquemaException(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();

		assertThrows(NoExisteEsquemaException.class, () -> {
			esquemaJugador.construir();
		});
	}

	@Test
	void testEsquemaHachaMaderaConstruirDevuelveUnaHerramientaConMismaDurabilidadQueHachaDeMadera(){
		Herramienta unaHerramienta = EsquemaHachaMadera.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDeMadera();

		assertEquals(unHacha.getDurabilidad(), unaHerramienta.getDurabilidad());
	}

	@Test
	void testEsquemaHachaMaderaConstruirDevuelveUnaHerramientaConMismaFuerzaQueHachaDeMadera(){
		Herramienta unaHerramienta = EsquemaHachaMadera.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDeMadera();

		assertEquals(unHacha.getFuerza(), unaHerramienta.getFuerza());
	}


	@Test
	void testEsquemaHachaPiedraConstruirDevuelveUnaHerramientaConMismaDurabilidadQueHachaDePiedra(){
		Herramienta unaHerramienta = EsquemaHachaPiedra.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDePiedra();

		assertEquals(unHacha.getDurabilidad(), unaHerramienta.getDurabilidad());
	}

	@Test
	void testEsquemaHachaPiedraConstruirDevuelveUnaHerramientaConMismaFuerzaQueHachaDePiedra(){
		Herramienta unaHerramienta = EsquemaHachaPiedra.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDePiedra();

		assertEquals(unHacha.getFuerza(), unaHerramienta.getFuerza());
	}

	@Test
	void testEsquemaHachaMetalConstruirDevuelveUnaHerramientaConMismaDurabilidadQueHachaDeMetal(){
		Herramienta unaHerramienta = EsquemaHachaMetal.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDeMetal();

		assertEquals(unHacha.getDurabilidad(), unaHerramienta.getDurabilidad());
	}

	@Test
	void testEsquemaHachaMetalConstruirDevuelveUnaHerramientaConMismaFuerzaQueHachaDeMetal() {
		Herramienta unaHerramienta = EsquemaHachaMetal.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDeMetal();

		assertEquals(unHacha.getFuerza(), unaHerramienta.getFuerza());
	}
}
