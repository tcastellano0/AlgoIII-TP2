import Herramientas.Construccion.*;
import Herramientas.Herramienta;
import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class EsquemaHerramientaTest {

	@Test(expected = NoExisteEsquemaException.class)
	public void testEsquemaHerramientaJugadorVacioConstruirLanzaNoExisteEsquemaException(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();

		esquemaJugador.construir();
	}

	private EsquemaHerramientaDelJugador crearEsquemaHachaDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Madera(),1,1);
		esquemaJugador.poner(new Madera(),1,2);
		esquemaJugador.poner(new Madera(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		return esquemaJugador;
	}

	private EsquemaHerramientaDelJugador crearEsquemaHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Piedra(),1,1);
		esquemaJugador.poner(new Piedra(),1,2);
		esquemaJugador.poner(new Piedra(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		return esquemaJugador;
	}

	private EsquemaHerramientaDelJugador crearEsquemaHachaDeMetal(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Metal(),1,1);
		esquemaJugador.poner(new Metal(),1,2);
		esquemaJugador.poner(new Metal(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		return esquemaJugador;
	}

	private EsquemaHerramientaDelJugador crearEsquemaPicoDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Madera(),1, 1);
		esquemaJugador.poner(new Madera(),1, 2);
		esquemaJugador.poner(new Madera(),1, 3);
		esquemaJugador.poner(new Madera(),2, 2);
		esquemaJugador.poner(new Madera(),3, 2);
		return esquemaJugador;
	}

	private EsquemaHerramientaDelJugador crearEsquemaPicoDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Piedra(),1, 1);
		esquemaJugador.poner(new Piedra(),1, 2);
		esquemaJugador.poner(new Piedra(),1, 3);
		esquemaJugador.poner(new Madera(),2, 2);
		esquemaJugador.poner(new Madera(),3, 2);
		return esquemaJugador;
	}

	private EsquemaHerramientaDelJugador crearEsquemaPicoDeMetal(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Metal(),1, 1);
		esquemaJugador.poner(new Metal(),1, 2);
		esquemaJugador.poner(new Metal(),1, 3);
		esquemaJugador.poner(new Madera(),2, 2);
		esquemaJugador.poner(new Madera(),3, 2);
		return esquemaJugador;
	}

	private EsquemaHerramientaDelJugador crearEsquemaPicoFino(){
		EsquemaHerramientaDelJugador esquemaJugador = EsquemaHerramientaDelJugador.getInstance();
		esquemaJugador.poner(new Metal(),1,1);
		esquemaJugador.poner(new Metal(),1,2);
		esquemaJugador.poner(new Metal(),1,3);
		esquemaJugador.poner(new Piedra(),2,1);
		esquemaJugador.poner(new Madera(),2,2);
		esquemaJugador.poner(new Madera(),3,2);
		return esquemaJugador;
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMaderaYTieneMismaDurabilidadQueHachaDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMadera();

		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDeMadera = Herramienta.hachaDeMadera();

		assertEquals(construida.getDurabilidad(), hachaDeMadera.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMaderaYTieneMismaFuerzaQueHachaDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMadera();
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDeMadera = Herramienta.hachaDeMadera();

		assertEquals(construida.getFuerza(), hachaDeMadera.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMaderaYTieneDistintaFuerzaQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMadera();
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDePiedra = Herramienta.hachaDePiedra();

		assertNotEquals(construida.getFuerza(), hachaDePiedra.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDePiedraYTieneMismaFuerzaQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDePiedra();
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDePiedra = Herramienta.hachaDePiedra();

		assertEquals(construida.getFuerza(), hachaDePiedra.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDePiedraYTieneMismaDurabilidadQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDePiedra();
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDePiedra = Herramienta.hachaDePiedra();

		assertEquals(construida.getDurabilidad(), hachaDePiedra.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMetalYTieneMismaDurabilidadQueHachaDeMetal(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMetal();
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDeMetal = Herramienta.hachaDeMetal();

		assertEquals(construida.getDurabilidad(), hachaDeMetal.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMetalYTieneMismaFuerzaQueHachaDeMetal(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMetal();

		Herramienta construida = esquemaJugador.construir();
		Herramienta hacha = Herramienta.hachaDeMetal();

		assertEquals(construida.getFuerza(), hacha.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMetalYTieneDistintaFuerzaQueHachaDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMetal();

		Herramienta construida = esquemaJugador.construir();
		Herramienta hacha = Herramienta.hachaDeMadera();

		assertNotEquals(construida.getFuerza(), hacha.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMetalYNoTieneMismaFuerzaQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMetal();
		Herramienta construida = esquemaJugador.construir();
		Herramienta hachaDePiedra = Herramienta.hachaDePiedra();

		assertNotEquals(construida.getFuerza(), hachaDePiedra.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaHachaDeMetalYNoTieneMismaDurabilidadQueHachaDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaHachaDeMetal();

		Herramienta construida = esquemaJugador.construir();
		Herramienta hacha = Herramienta.hachaDePiedra();

		assertNotEquals(construida.getDurabilidad(), hacha.getDurabilidad());
	}




	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoDeMaderaYTieneMismaDurabilidadQuePicoDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoDeMadera();

		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoDeMadera();

		assertEquals(construida.getDurabilidad(), pico.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoDeMaderaYTieneMismaFuerzaQuePicoDeMadera(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoDeMadera();
		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoDeMadera();

		assertEquals(construida.getFuerza(), pico.getFuerza());
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoDePiedraYTieneMismaDurabilidadQuePicoDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoDePiedra();

		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoDePiedra();

		assertEquals(construida.getDurabilidad(), pico.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoDePiedraYTieneMismaFuerzaQuePicoDePiedra(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoDePiedra();
		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoDePiedra();

		assertEquals(construida.getFuerza(), pico.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoDeMetalYTieneMismaDurabilidadQuePicoDeMetal(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoDeMetal();

		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoDeMetal();

		assertEquals(construida.getDurabilidad(), pico.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoDeMetalYTieneMismaFuerzaQuePicoDeMetal(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoDeMetal();
		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoDeMetal();

		assertEquals(construida.getFuerza(), pico.getFuerza());
	}

	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoFinoYTieneMismaDurabilidadQuePicoFino(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoFino();

		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoFino();

		assertEquals(construida.getDurabilidad(), pico.getDurabilidad(), 0);
	}


	@Test
	public void testEsquemaHerramientaJugadorCreaEsquemaPicoFinoYTieneMismaFuerzaQuePicoFino(){
		EsquemaHerramientaDelJugador esquemaJugador = crearEsquemaPicoFino();
		Herramienta construida = esquemaJugador.construir();
		Herramienta pico = Herramienta.picoFino();

		assertEquals(construida.getFuerza(), pico.getFuerza());
	}

	@Test
	public void testEsquemaHachaMaderaConstruirDevuelveUnaHerramientaConMismaDurabilidadQueHachaDeMadera(){
		Herramienta unaHerramienta = EsquemaHachaMadera.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDeMadera();

		assertEquals(unHacha.getDurabilidad(), unaHerramienta.getDurabilidad(), 0);
	}

	@Test
	public void testEsquemaHachaMaderaConstruirDevuelveUnaHerramientaConMismaFuerzaQueHachaDeMadera(){
		Herramienta unaHerramienta = EsquemaHachaMadera.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDeMadera();

		assertEquals(unHacha.getFuerza(), unaHerramienta.getFuerza());
	}


	@Test
	public void testEsquemaHachaPiedraConstruirDevuelveUnaHerramientaConMismaDurabilidadQueHachaDePiedra(){
		Herramienta unaHerramienta = EsquemaHachaPiedra.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDePiedra();

		assertEquals(unHacha.getDurabilidad(), unaHerramienta.getDurabilidad(), 0);
	}

	@Test
	public void testEsquemaHachaPiedraConstruirDevuelveUnaHerramientaConMismaFuerzaQueHachaDePiedra(){
		Herramienta unaHerramienta = EsquemaHachaPiedra.getInstance().construir();
		Herramienta unHacha = Herramienta.hachaDePiedra();

		assertEquals(unHacha.getFuerza(), unaHerramienta.getFuerza());
	}

	@Test
	public void testEsquemaPicoMaderaConstruirDevuelveUnaHerramientaConMismaDurabilidadQuePicoMadera(){
		Herramienta unaHerramienta = EsquemaPicoMadera.getInstance().construir();
		Herramienta unPico = Herramienta.picoDeMadera();

		assertEquals(unPico.getDurabilidad(), unaHerramienta.getDurabilidad(), 0);
	}

	@Test
	public void testEsquemaPicoMaderaConstruirDevuelveUnaHerramientaConMismaFuerzaQuePicoMadera() {
		Herramienta unaHerramienta = EsquemaPicoMadera.getInstance().construir();
		Herramienta unPico = Herramienta.picoDeMadera();

		assertEquals(unPico.getFuerza(), unaHerramienta.getFuerza());
	}

	@Test
	public void testEsquemaPicoPiedraConstruirDevuelveUnaHerramientaConMismaDurabilidadQuePicoPiedra(){
		Herramienta unaHerramienta = EsquemaPicoPiedra.getInstance().construir();
		Herramienta unPico = Herramienta.picoDePiedra();

		assertEquals(unPico.getDurabilidad(), unaHerramienta.getDurabilidad(), 0);
	}

	@Test
	public void testEsquemaPicoPiedraConstruirDevuelveUnaHerramientaConMismaFuerzaQuePicoPiedra() {
		Herramienta unaHerramienta = EsquemaPicoPiedra.getInstance().construir();
		Herramienta unPico = Herramienta.picoDePiedra();

		assertEquals(unPico.getFuerza(), unaHerramienta.getFuerza());
	}

	@Test
	public void testEsquemaPicoMetalConstruirDevuelveUnaHerramientaConMismaDurabilidadQuePicoMetal(){
		Herramienta unaHerramienta = EsquemaPicoMetal.getInstance().construir();
		Herramienta unPico = Herramienta.picoDeMetal();

		assertEquals(unPico.getDurabilidad(), unaHerramienta.getDurabilidad(), 0);
	}

	@Test
	public void testEsquemaPicoMetalConstruirDevuelveUnaHerramientaConMismaFuerzaQuePicoMetal() {
		Herramienta unaHerramienta = EsquemaPicoMetal.getInstance().construir();
		Herramienta unPico = Herramienta.picoDeMetal();

		assertEquals(unPico.getFuerza(), unaHerramienta.getFuerza());
	}

}
