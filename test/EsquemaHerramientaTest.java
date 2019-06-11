import Herramientas.Construccion.*;
import Herramientas.Herramienta;
import Materiales.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EsquemaHerramientaTest {

	@Test
	void testEsquemaHerramientaJugadorVacioConstruirLanzaNoExisteEsquemaException(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();

		assertThrows(NoExisteEsquemaException.class, () -> {
			esquemaJugador.construir();
		});
	}

	@Test
	void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMaderaYTieneMismaDurabilidadQueHachaDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Madera(),1,1);
		esquemaJugador.poner(new Madera(),1,2);
		esquemaJugador.poner(new Madera(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDeMadera = Herramienta.hachaDeMadera();

		assertEquals(construida.getDurabilidad(), hachaDeMadera.getDurabilidad());
	}


	@Test
	void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMaderaYTieneMismaFuerzaQueHachaDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Madera(),1,1);
		esquemaJugador.poner(new Madera(),1,2);
		esquemaJugador.poner(new Madera(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDeMadera = Herramienta.hachaDeMadera();

		assertEquals(construida.getFuerza(), hachaDeMadera.getFuerza());
	}

	@Test
	void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMaderaYTieneDistintaFuerzaQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Madera(),1,1);
		esquemaJugador.poner(new Madera(),1,2);
		esquemaJugador.poner(new Madera(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDePiedra = Herramienta.hachaDePiedra();

		assertNotEquals(construida.getFuerza(), hachaDePiedra.getFuerza());
	}

	@Test
	void testEsquemaHerramientaJugadorCreaEsquemaHachaDePiedraYTieneMismaFuerzaQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Piedra(),1,1);
		esquemaJugador.poner(new Piedra(),1,2);
		esquemaJugador.poner(new Piedra(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDePiedra = Herramienta.hachaDePiedra();

		assertEquals(construida.getFuerza(), hachaDePiedra.getFuerza());
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
