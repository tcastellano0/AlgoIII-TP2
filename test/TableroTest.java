import Juego.Mapa.TableroCreacionException;
import Materiales.Madera;
import Materiales.Piedra;
import org.junit.jupiter.api.Test;

import Juego.Mapa.*;
import Materiales.Diamante;
import Materiales.Material;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TableroTest {

	@Test
	void test01CrearMapaConNumFilasNegativoLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero<Material>(-1, 1);
		});
	}

	@Test
	void test02CrearMapaConNumColumnasNegativoLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero<Material>(1, -1);
		});
	}

	@Test
	void test03CrearMapaConNumFilasCeroLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero<Material>(0, 1);
		});
	}

	@Test
	void test04CrearMapaConNumColumnasCeroLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero<Material>(1, 0);
		});
	}

	@Test
    void test05CreoUnTableroTresPorTresAgregoUnDiamanteEn3Y3YAlSacarloEsElMismo() {
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();
		tablero.poner(diamante, 3, 3);
		
		assertEquals(diamante, tablero.sacar(3, 3));
    }

    @Test
	void test06AgregarEnUnTableroEnPosicionCeroYCeroLanzaError(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.poner(diamante, 0, 0);
		});
	}

	@Test
	void test07AgregarEnUnTableroEnPosicionCeroYUnoLanzaError(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.poner(diamante, 0, 1);
		});
	}

	@Test
	void test08AgregarEnUnTableroEnPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;

		Tablero<Material> tablero = new Tablero<Material>(fila, 3);
		Diamante diamante = new Diamante();

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.poner(diamante, fila + 2, 2);
		});
	}

	@Test
	void test09AgregarEnUnTableroEnPosicionConColumnaMasAltaQueLaDelTableroLanzaError(){
		int columna = 3;

		Tablero<Material> tablero = new Tablero<Material>(3, columna);
		Diamante diamante = new Diamante();

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.poner(diamante, 2, columna+2);
		});
	}
	
	@Test
	void test10SacarDeUnaPosicionConColumnaMasAltaQueLaDelTableroLanzaError(){
		int columna = 3;
		Tablero<Material> tablero = new Tablero<Material>(3, columna);

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.sacar(2, columna + 2);
		});
	}
	
	@Test
	void test11SacarDeUnaPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;
		Tablero<Material> tablero = new Tablero<Material>(fila, 3);

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.sacar(fila + 2, 2);
		});
	}

	@Test
	void test12PonerDosVecesEnUnaMismaPosicionNoMantieneLoPrimeroQueSePuso(){
		Tablero<Material> tablero = new Tablero<>(5, 5);
		Material madera = new Madera();
		Material piedra = new Piedra();

		tablero.poner(madera, 3, 3);
		tablero.poner(piedra, 3, 3);

		assertEquals(tablero.sacar(3,3), piedra);
	}

	@Test
	void test13SacarDeUnaPosicionQueNoTieneNadaLanzaError(){
		Tablero<Material> tablero = new Tablero<>(1, 1);

		assertThrows(ContenedorVacioException.class, () -> {
			tablero.sacar(1, 1);
		});
	}

	@Test
	void testPonerUnaPiedraEnUnTableroYVerLaPosicionDosVecesDebeDarLaMismaPiedra(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Piedra piedra = new Piedra();

		tablero.poner(piedra, 1, 1);
		
		assertEquals(piedra, tablero.ver(1, 1));
		assertEquals(piedra, tablero.ver(1, 1));
	}
	
	@Test
	void testVerEnUnaPosicionSinContenidoDeberiaSerNull(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);

		assertEquals(tablero.ver(1, 1), null);
	}
}

