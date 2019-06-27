import Materiales.*;
import Herramientas.Herramienta;
import Juego.Jugador.Jugador;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JugadorTest {
	
	@Test
    public void testJugadorSeInicializaConCeroMaderas() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeMaderas(), 0);
    }
	
	@Test
    public void testJugadorSeInicializaConCeroMetales() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeMetales(), 0);
    }
	
	@Test
    public void testJugadorSeInicializaConCeroPiedras() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDePiedras(), 0);
    }
	
	@Test
    public void testJugadorSeInicializaConCeroDiamantes() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeDiamantes(), 0);
    }
	
	@Test
    public void testJugadorSeInicializaConUnHachaDeMadera() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeHachasDeMadera(), 1);
    }
	
	@Test
    public void testJugadorSeInicializaConUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();
        Herramienta unHacha = Herramienta.hachaDeMadera();

        assertEquals(jugador.herramientaEquipada().getDurabilidad(), unHacha.getDurabilidad(), 0);
        assertEquals(jugador.herramientaEquipada().getFuerza(), unHacha.getFuerza());
    }
	
	/*
	@Test
    public void testJugadorSeInicializaConLaMismaHachaDeMaderaEquipadaYEnInventario() {
		Jugador jugador = new Jugador();

		assertEquals(jugador.herramientaEquipada(), jugador.ultimaHerramientaObtenida());
    }
    */
	
	@Test
    public void testJugadorAgregarUnPicoDeMaderaAlInventarioYEsteAumentaLaCantidadDePicosDeMadera() {
		Jugador jugador = new Jugador();
		Herramienta unPico = Herramienta.picoDeMadera();
		int cantidadDePicosDeMadera = jugador.cantidadDePicosDeMadera();
		
		jugador.agregarHerramienta(unPico);

		assertEquals(jugador.cantidadDePicosDeMadera(), cantidadDePicosDeMadera + 1);
    }
	
	/*
	@Test
    public void testJugadorSeEquipaSuUltimaHerramientaYEstaCorrespondeALaUltima() {
		Jugador jugador = new Jugador();
		Herramienta unPico = Herramienta.picoDeMadera();
		
		jugador.agregarHerramienta(unPico);
		jugador.equiparConUltimaHerramienta();

		assertEquals(jugador.herramientaEquipada().getDurabilidad(), unPico.getDurabilidad(), 0);
        assertEquals(jugador.herramientaEquipada().getFuerza(), unPico.getFuerza());
    }
    */
	
	@Test
	public void testJugadorGuardaMaderaEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Madera madera = new Madera();
		int cantidadMaderas = jugador.cantidadDeMaderas();
		
		jugador.guardar(madera);
		
		assertEquals(jugador.cantidadDeMaderas(), cantidadMaderas + 1);
	}
	
	@Test
	public void testJugadorGuardaPiedraEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Piedra piedra = new Piedra();
		int cantidadDePiedras = jugador.cantidadDePiedras();
		
		jugador.guardar(piedra);
		
		assertEquals(jugador.cantidadDePiedras(), cantidadDePiedras + 1);
	}
	
	@Test
	public void testJugadorGuardaMetalEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Metal metal = new Metal();
		int cantidadDeMetales = jugador.cantidadDeMetales();
		
		jugador.guardar(metal);
		
		assertEquals(jugador.cantidadDeMetales(), cantidadDeMetales + 1);
	}
	
	@Test
	public void testJugadorGuardaDiamanteEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Diamante diamante = new Diamante();
		int cantidadDeDiamantes = jugador.cantidadDeDiamantes();
		
		jugador.guardar(diamante);
		
		assertEquals(jugador.cantidadDeDiamantes(), cantidadDeDiamantes + 1);
	}

	@Test
	public void testJugadorGolpeaMaderaConHachaDeMaderaCincoVecesYSeGuardaLaMadera() {
		Jugador jugador = new Jugador();
		Madera madera = new Madera();
		int cantidadDeMaderas = jugador.cantidadDeMaderas();
		
		jugador.golpear(madera);
		jugador.golpear(madera);
		jugador.golpear(madera);
		jugador.golpear(madera);
		jugador.golpear(madera);

		assertEquals(jugador.cantidadDeMaderas(), cantidadDeMaderas + 1);
	}
	
	@Test
	public void testJugadorAgregaHachaDeMaderaYAumentaLaCantidadDeHachasDeMadera() {
		Jugador jugador = new Jugador();
		int cantidadDeHachasDeMadera = jugador.cantidadDeHachasDeMadera();
		
		jugador.agregarHerramienta(Herramienta.hachaDeMadera());

		assertEquals(jugador.cantidadDeHachasDeMadera(), cantidadDeHachasDeMadera + 1);
	}
	
	@Test
	public void testJugadorAgregaHachaDePiedraYAumentaLaCantidadDeHachasDePiedra() {
		Jugador jugador = new Jugador();
		int cantidadDeHachasDePiedra = jugador.cantidadDeHachasDePiedra();
		
		jugador.agregarHerramienta(Herramienta.hachaDePiedra());

		assertEquals(jugador.cantidadDeHachasDePiedra(), cantidadDeHachasDePiedra + 1);
	}
	
	@Test
	public void testJugadorAgregaHachaDeMetalYAumentaLaCantidadDeHachasDeMetal() {
		Jugador jugador = new Jugador();
		int cantidadDeHachasDeMetal = jugador.cantidadDeHachasDeMetal();
		
		jugador.agregarHerramienta(Herramienta.hachaDeMetal());

		assertEquals(jugador.cantidadDeHachasDeMetal(), cantidadDeHachasDeMetal + 1);
	}
	
	@Test
	public void testJugadorAgregaPicoDeMaderaYAumentaLaCantidadDePicosDeMadera() {
		Jugador jugador = new Jugador();
		int cantidadDePicosDeMadera = jugador.cantidadDePicosDeMadera();
		
		jugador.agregarHerramienta(Herramienta.picoDeMadera());

		assertEquals(jugador.cantidadDePicosDeMadera(), cantidadDePicosDeMadera + 1);
	}
	
	@Test
	public void testJugadorAgregaPicoDePiedraYAumentaLaCantidadDePicossDePiedra() {
		Jugador jugador = new Jugador();
		int cantidadDePicosDePiedra = jugador.cantidadDePicosDePiedra();
		
		jugador.agregarHerramienta(Herramienta.picoDePiedra());

		assertEquals(jugador.cantidadDePicosDePiedra(), cantidadDePicosDePiedra + 1);
	}
	
	@Test
	public void testJugadorAgregaPicoDeMetalYAumentaLaCantidadDePicosDeMetal() {
		Jugador jugador = new Jugador();
		int cantidadDePicosDeMetal = jugador.cantidadDePicosDeMetal();
		
		jugador.agregarHerramienta(Herramienta.picoDeMetal());

		assertEquals(jugador.cantidadDePicosDeMetal(), cantidadDePicosDeMetal + 1);
	}
	
	@Test
	public void testJugadorAgregaPicoFinoYAumentaLaCantidadDePicosFinos() {
		Jugador jugador = new Jugador();
		int cantidadDePicosFinos = jugador.cantidadDePicosFinos();
		
		jugador.agregarHerramienta(Herramienta.picoFino());

		assertEquals(jugador.cantidadDePicosFinos(), cantidadDePicosFinos + 1);
	}
	
	@Test
	public void testJugadorAgregaHachaDeMaderaYNoAumentaLaCantidadDeHachasDeMetal() {
		Jugador jugador = new Jugador();
		int cantidadDeHachasDeMetal = jugador.cantidadDeHachasDeMetal();
		
		jugador.agregarHerramienta(Herramienta.hachaDeMadera());

		assertEquals(jugador.cantidadDeHachasDeMetal(), cantidadDeHachasDeMetal);
	}
	
	@Test
	public void testJugadorAgregaHachaDeMaderaYNoAumentaLaCantidadDePicosDeMadera() {
		Jugador jugador = new Jugador();
		int cantidadDePicosDeMadera = jugador.cantidadDePicosDeMadera();
		
		jugador.agregarHerramienta(Herramienta.hachaDeMadera());

		assertEquals(jugador.cantidadDePicosDeMadera(), cantidadDePicosDeMadera);
	}
	
	
}
