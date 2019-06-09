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
	void test01CrearMapaConNumColumnasNegativoLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
				new Tablero(1, -1);
		});
	}

	@Test
	void test01CrearMapaConNumFilasCeroLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero(-1, 1);
		});
	}

	@Test
	void test01CrearMapaConNumColumnasCeroLanzaError() {
		assertThrows(TableroCreacionException.class, () -> {
			new Tablero(1, -1);
		});
	}


	@Test
    void test01Creo() {
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();
		tablero.agregar(diamante, 1, 1);
		
		assertSame(diamante, tablero.sacar(1, 1));
    }
	
	@Test
    void test02() {
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();
		tablero.agregar(diamante, 1, 2);
		
		assertSame(diamante, tablero.sacar(1, 2));
    }
	
	@Test
	void test03() {
		Tablero<Material> tablero = new Tablero<Material>(3, 3);
		Diamante diamante = new Diamante();
		tablero.agregar(diamante, 1, 3);
		
		assertSame(diamante, tablero.sacar(1, 3));
    }
	
	@Test
    void test04() {
		Tablero<Material> tablero = new Tablero<Material>(1, 1);
		Diamante diamante = new Diamante();
		tablero.agregar(diamante, 1, 1);
		
		assertSame(diamante, tablero.sacar(1, 1));
    }
	
	//falta probar el caso new Tablero<Material>(0, 0) y agregar(diamante, 0, 0) sacar(diamante, 0, 0) etc etc

}

