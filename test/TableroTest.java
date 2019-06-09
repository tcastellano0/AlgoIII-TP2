import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Juego.Mapa.TableroCreacionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import Juego.Mapa.*;
import Materiales.Diamante;
import Materiales.Material;


public class TableroTest {
	//falta nombrar bien los tests

	@Test
	void test01CrearMapaConNumFilasNegativoLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero(-1, 1);
		});
	}

	@Test
	void test02CrearMapaConNumColumnasNegativoLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
				new Tablero(1, -1);
		});
	}

	@Test
	void test03CrearMapaConNumFilasCeroLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero(0, 1);
		});
	}

	@Test
	void test04CrearMapaConNumColumnasCeroLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero(1, 0);
		});
	}


	@Test
    void test05CreoUnTableroTresPorTresAgregoUnDiamanteEn3Y3YAlSacarloEsElMismo() {
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();
		tablero.agregar(diamante, 3, 3);
		
		assertSame(diamante, tablero.sacar(3, 3));
    }

    @Test
	void test06AgregarEnUnTableroEnPosicionCeroYCeroLanzaError(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.agregar(diamante, 0, 0);
		});
	}

	@Test
	void test07AgregarEnUnTableroEnPosicionCeroYUnoLanzaError(){
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();

		assertThrows(UbicacionInvalidaException.class, () -> {
			tablero.agregar(diamante, 0, 1);
		});
	}

	//falta probar el caso new Tablero<Material>(0, 0) y agregar(diamante, 0, 0) sacar(diamante, 0, 0) etc etc

}

