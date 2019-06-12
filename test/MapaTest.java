import Materiales.*;
import Juego.Mapa.Mapa;
import Juego.Mapa.Posicion;
import Juego.Jugador.Jugador;

import Juego.Mapa.UbicacionInvalidaException;
import Juego.Mapa.ContenedorOcupadoException;
import Juego.Mapa.ContenedorVacioException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MapaTest {
	
	@Test
	void testSePuedeOcuparUnCasilleroVacioConUnJugador() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(jugador, posicion);
		assertEquals(mapa.sacar(posicion), jugador);
	}
	
	@Test
	void testSePuedeOcuparUnCasilleroVacioConUnaMadera() {
		Mapa mapa = new Mapa();
		Madera madera = new Madera();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(madera, posicion);
		assertEquals(mapa.sacar(posicion), madera);
	}
	
	@Test
	void testSePuedeOcuparUnCasilleroVacioConUnaPiedra() {
		Mapa mapa = new Mapa();
		Piedra piedra = new Piedra();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(piedra, posicion);
		assertEquals(mapa.sacar(posicion), piedra);
	}
	
	@Test
	void testSePuedeOcuparUnCasilleroVacioConUnMetal() {
		Mapa mapa = new Mapa();
		Metal metal = new Metal();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(metal, posicion);
		assertEquals(mapa.sacar(posicion), metal);
	}
	
	@Test
	void testSePuedeOcuparUnCasilleroVacioConUnDiamante() {
		Mapa mapa = new Mapa();
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(diamante, posicion);
		assertEquals(mapa.sacar(posicion), diamante);
	}
	
	@Test
	void testNoSePuedeOcuparUnCasilleroOcupadoConUnMaterial() {
		Mapa mapa = new Mapa();
		Madera madera = new Madera();
		Diamante diamante = new Diamante();
		
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(diamante, posicion);
		assertThrows(ContenedorOcupadoException.class, () -> {
			mapa.poner(madera, posicion);
		});
	}
	
	@Test
	void testNoSePuedeOcuparUnCasilleroOcupadoConElJugador() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador();
		Diamante diamante = new Diamante();
		
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(diamante, posicion);
		
		assertThrows(ContenedorOcupadoException.class, () -> {
			mapa.poner(jugador, posicion);
		});
	}
	
	@Test
	void testNoSePuedeOcuparUnCasilleroFueraDelMapa() {
		Mapa mapa = new Mapa();
		Diamante diamante = new Diamante();
		
		Posicion posicion = new Posicion(25,25);
		
		assertThrows(UbicacionInvalidaException.class, () -> {
			mapa.poner(diamante, posicion);
		});
	}
	
	@Test
	void testAlPonerYSacarUnMaterialDeUnCasilleroEsteDebeSerElMismo() {
		Mapa mapa = new Mapa();
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(diamante, posicion);
		
		assertEquals(mapa.sacar(posicion), diamante);
	}
	
	@Test
	void testAlSacarUnMaterialDeUnCasilleroOcupadoEsteLuegoDebeEstarVacio() {
		Mapa mapa = new Mapa();
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(1,1);
		
		mapa.poner(diamante, posicion);
		mapa.sacar(posicion);

		assertThrows(ContenedorVacioException.class, () -> {
			mapa.sacar(posicion);
		});
	}
	
	@Test
	void testAlSacarUnMaterialDeUnCasilleroVacioEsteNoDebePermitirlo() {
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);

		assertThrows(ContenedorVacioException.class, () -> {
			mapa.sacar(posicion);
		});
	}
	
}
