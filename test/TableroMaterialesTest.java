import Juego.Mapa.*;
import Materiales.Metal;
import Materiales.Madera;
import Materiales.Piedra;
import Materiales.Diamante;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TableroMaterialesTest {

	@Test
	public void testTablerosDeMaterialesVacioEsIgualATableroVacio() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		assertTrue(tablero1.esIgual(tablero2));
	}
	
	@Test
	public void testTablerosDeMaterialesVacioEsDistintoATableroConAlMenosUnMateria() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);
		
		tablero2.poner(new Piedra(), new Posicion(1, 1));

		assertFalse(tablero1.esIgual(tablero2));
	}	
	
	@Test
	public void testTablerosConSoloMaderaSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Madera(), new Posicion(1, 1));
		tablero1.poner(new Madera(), new Posicion(1, 2));
		tablero1.poner(new Madera(), new Posicion(2, 1));
		tablero1.poner(new Madera(), new Posicion(2, 2));

		tablero2.poner(new Madera(), new Posicion(1, 1));
		tablero2.poner(new Madera(), new Posicion(1, 2));
		tablero2.poner(new Madera(), new Posicion(2, 1));
		tablero2.poner(new Madera(), new Posicion(2, 2));

		assertTrue(tablero1.esIgual(tablero2));
	}

	@Test
	public void testTableroDeMaderasYTableroDePiedrasNoSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Madera(), new Posicion(1, 1));
		tablero1.poner(new Madera(), new Posicion(1, 2));
		tablero1.poner(new Madera(), new Posicion(2, 1));
		tablero1.poner(new Madera(), new Posicion(2, 2));

		tablero2.poner(new Piedra(), new Posicion(1, 1));
		tablero2.poner(new Piedra(), new Posicion(1, 2));
		tablero2.poner(new Piedra(), new Posicion(2, 1));
		tablero2.poner(new Piedra(), new Posicion(2, 2));

		assertFalse(tablero1.esIgual(tablero2));
	}

	@Test
	public void testTablerosDeMaderasYUnaPiedrasSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Madera(), new Posicion(1, 1));
		tablero1.poner(new Madera(), new Posicion(1, 2));
		tablero1.poner(new Madera(), new Posicion(2, 1));
		tablero1.poner(new Piedra(), new Posicion(2, 2));

		tablero2.poner(new Madera(), new Posicion(1, 1));
		tablero2.poner(new Madera(), new Posicion(1, 2));
		tablero2.poner(new Madera(), new Posicion(2, 1));
		tablero2.poner(new Piedra(), new Posicion(2, 2));

		assertTrue(tablero1.esIgual(tablero2));
	}
	
	@Test
	public void testTablerosDeMaterialesInvertidosNoSonIguales() {
		TableroMateriales tablero1 = new TableroMateriales(2, 2);
		TableroMateriales tablero2 = new TableroMateriales(2, 2);

		tablero1.poner(new Diamante(), new Posicion(1, 1));
		tablero1.poner(new Metal(), new Posicion(1, 2));
		tablero1.poner(new Madera(), new Posicion(2, 1));
		tablero1.poner(new Piedra(), new Posicion(2, 2));

		tablero2.poner(new Piedra(), new Posicion(1, 1));
		tablero2.poner(new Madera(), new Posicion(1, 2));
		tablero2.poner(new Metal(), new Posicion(2, 1));
		tablero2.poner(new Diamante(), new Posicion(2, 2));

		assertFalse(tablero1.esIgual(tablero2));
	}
	
}
