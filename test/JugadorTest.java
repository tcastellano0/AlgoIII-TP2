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
    public void testJugadorSeInicializaConUnaHerramienta() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeHerramientas(), 1);
    }
	
	@Test
    public void testJugadorSeInicializaConUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();
        Herramienta unHacha = Herramienta.hachaDeMadera();

        assertEquals(jugador.herramientaEquipada().getDurabilidad(), unHacha.getDurabilidad(), 0);
        assertEquals(jugador.herramientaEquipada().getFuerza(), unHacha.getFuerza());
    }
	
	@Test
    public void testJugadorSeInicializaConLaMismaHachaDeMaderaEquipadaYEnInventario() {
		Jugador jugador = new Jugador();

		assertEquals(jugador.herramientaEquipada(), jugador.ultimaHerramientaObtenida());
    }
	
	@Test
    public void testJugadorAgregaHerramientaAlInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Herramienta unPico = Herramienta.picoDeMadera();
		int cantidadHerramientas = jugador.cantidadDeHerramientas();
		
		jugador.agregarHerramienta(unPico);

		assertEquals(jugador.cantidadDeHerramientas(), cantidadHerramientas + 1);
    }
	
	@Test
    public void testJugadorSeEquipaSuUltimaHerramientaYEstaCorrespondeALaUltima() {
		Jugador jugador = new Jugador();
		Herramienta unPico = Herramienta.picoDeMadera();
		
		jugador.agregarHerramienta(unPico);
		jugador.equiparConUltimaHerramienta();

		assertEquals(jugador.herramientaEquipada().getDurabilidad(), unPico.getDurabilidad(), 0);
        assertEquals(jugador.herramientaEquipada().getFuerza(), unPico.getFuerza());
    }
	
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
	
}
