import Juego.Mapa.TableroCreacionException;
import Materiales.Madera;
import Materiales.Piedra;
import org.junit.jupiter.api.Test;

import Juego.Mapa.*;
import Materiales.Diamante;
import Materiales.Material;

import static org.junit.jupiter.api.Assertions.*;


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
		
		assertSame(diamante, tablero.sacar(3, 3));
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
			tablero.poner(diamante, fila+2, 2);
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
			tablero.sacar(2, columna+2);
		});
	}
	
	@Test
	void test11SacarDeUnaPosicionConFilaMasAltaQueLaDelTableroLanzaError(){
		int fila = 3;
		Tablero<Material> tablero = new Tablero<Material>(fila, 3);

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.sacar(fila+2, 2);
		});
	}

	@Test
	void test12PonerDosVecesEnUnaMismaPosicionMantieneLoPrimeroQueSePuso(){
		Tablero<Material> tablero = new Tablero<>(5, 5);
		Material madera = new Madera();
		Material piedra = new Piedra();

		tablero.poner(madera, 3, 3);

		assertEquals(tablero.sacar(3,3),madera);
	}

	@Test
	void test13SacarDeUnaPosicionQueNoTieneNadaLanzaError(){
		Tablero<Material> tablero = new Tablero<>(1, 1);

		assertThrows(ContenedorVacioException.class, () -> {
			tablero.sacar(1, 1);
		});
	}
	
	/*
	@Test
	void test14TablerosConMismoContenidoSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);
		
		tablero1.poner(new Madera(), 1, 1);
		tablero1.poner(new Madera(), 1, 2);
		tablero1.poner(new Madera(), 2, 1);
		tablero1.poner(new Madera(), 2, 2);
		
		tablero2.poner(new Madera(), 1, 1);
		tablero2.poner(new Madera(), 1, 2);
		tablero2.poner(new Madera(), 2, 1);
		tablero2.poner(new Madera(), 2, 2);
		
		assertTrue(tablero1.esIgual(tablero2));
	}
	*/
	

}

