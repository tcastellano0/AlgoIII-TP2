import Materiales.*;
import Herramientas.Herramienta;
import Juego.Jugador.Jugador;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JugadorTest {
	
	@Test
    public void testJugadorSeInicializaConCeroMateriales() {
		Jugador jugador = new Jugador();
		
		assertEquals(jugador.cantidadDeMateriales(), 0);
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
		int cantidadMateriales = jugador.cantidadDeMateriales();
		
		jugador.guardar(madera);
		
		assertEquals(jugador.cantidadDeMateriales(), cantidadMateriales + 1);
	}
	
	@Test
	public void testJugadorGuardaPiedraEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Piedra piedra = new Piedra();
		int cantidadMateriales = jugador.cantidadDeMateriales();
		
		jugador.guardar(piedra);
		
		assertEquals(jugador.cantidadDeMateriales(), cantidadMateriales + 1);
	}
	
	@Test
	public void testJugadorGuardaMetalEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Metal metal = new Metal();
		int cantidadMateriales = jugador.cantidadDeMateriales();
		
		jugador.guardar(metal);
		
		assertEquals(jugador.cantidadDeMateriales(), cantidadMateriales + 1);
	}
	
	@Test
	public void testJugadorGuardaDiamanteEnElInventarioYEsteAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		Diamante diamante = new Diamante();
		int cantidadMateriales = jugador.cantidadDeMateriales();
		
		jugador.guardar(diamante);
		
		assertEquals(jugador.cantidadDeMateriales(), cantidadMateriales + 1);
	}
	
	@Test
	public void testJugadorGuardaMaterialNuloEnElInventarioYEsteNoAumentaSuCantidad() {
		Jugador jugador = new Jugador();
		MaterialNulo materialNulo = new MaterialNulo();
		int cantidadMateriales = jugador.cantidadDeMateriales();
		
		jugador.guardar(materialNulo);
		
		assertEquals(jugador.cantidadDeMateriales(), cantidadMateriales);
	}
	

	@Test
	public void testJugadorGolpeaMaderaConHachaDeMaderaCincoVecesYSeGuardaLaMadera() {
		Jugador jugador = new Jugador();
		Madera madera = new Madera();
		int cantidadMateriales = jugador.cantidadDeMateriales();
		
		jugador.golpear(madera);
		jugador.golpear(madera);
		jugador.golpear(madera);
		jugador.golpear(madera);
		jugador.golpear(madera);

		assertEquals(jugador.cantidadDeMateriales(), cantidadMateriales + 1);
	}
	
}
