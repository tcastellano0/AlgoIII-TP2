
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Juego.Mapa.*;
import Materiales.Metal;
import Materiales.Madera;
import Materiales.Piedra;
import Materiales.Diamante;


public class TableroMaterialesTest {

	@Test
	void testTablerosDeMaterialesVacioEsIgualATableroVacio() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		assertTrue(tablero1.esIgual(tablero2));
	}
	
	@Test
	void testTablerosDeMaterialesVacioEsDistintoATableroConAlMenosUnMateria() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);
		
		tablero2.poner(new Piedra(), 1, 1);

		assertFalse(tablero1.esIgual(tablero2));
	}	
	
	@Test
	void testTablerosConSoloMaderaSonIguales() {
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

	@Test
	void testTableroDeMaderasYTableroDePiedrasNoSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Madera(), 1, 1);
		tablero1.poner(new Madera(), 1, 2);
		tablero1.poner(new Madera(), 2, 1);
		tablero1.poner(new Madera(), 2, 2);

		tablero2.poner(new Piedra(), 1, 1);
		tablero2.poner(new Piedra(), 1, 2);
		tablero2.poner(new Piedra(), 2, 1);
		tablero2.poner(new Piedra(), 2, 2);

		assertFalse(tablero1.esIgual(tablero2));
	}

	@Test
	void testTablerosDeMaderasYUnaPiedrasSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Madera(), 1, 1);
		tablero1.poner(new Madera(), 1, 2);
		tablero1.poner(new Madera(), 2, 1);
		tablero1.poner(new Piedra(), 2, 2);

		tablero2.poner(new Madera(), 1, 1);
		tablero2.poner(new Madera(), 1, 2);
		tablero2.poner(new Madera(), 2, 1);
		tablero2.poner(new Piedra(), 2, 2);

		assertTrue(tablero1.esIgual(tablero2));
	}
	
	@Test
	void testTablerosDeMaterialesInvertidosNoSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Diamante(), 1, 1);
		tablero1.poner(new Metal(), 1, 2);
		tablero1.poner(new Madera(), 2, 1);
		tablero1.poner(new Piedra(), 2, 2);

		tablero2.poner(new Piedra(), 1, 1);
		tablero2.poner(new Madera(), 1, 2);
		tablero2.poner(new Metal(), 2, 1);
		tablero2.poner(new Diamante(), 2, 2);

		assertFalse(tablero1.esIgual(tablero2));
	}
	
}
