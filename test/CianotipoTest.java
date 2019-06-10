import Materiales.*;
import Herramientas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CianotipoTest {

	@Test
    void test01MaquetaDebeTenerTresColumnasPorTresFilas() {
		Maqueta unaMaqueta = new Maqueta();
		
		assertEquals(unaMaqueta.getCantidadColumnas(), 3);
		assertEquals(unaMaqueta.getCantidadFilas(), 3);
	}
	
	@Test
    void test02MaquetaNuevaDebeTenerTodasSusCeldasVacias() {
		Maqueta unaMaqueta = new Maqueta();
		
		for (int fila = 0; fila < unaMaqueta.getCantidadFilas(); fila++) {
			for (int columna = 0; columna < unaMaqueta.getCantidadColumnas(); columna++) {
				assertEquals(unaMaqueta.getMaterialEnCelda(fila, columna), null);
			}
		}
	}
	
	@Test
	void test03InsertoUnMaterialEnUnaCeldaYElMismoDebeEstarDentroDeEsaCelda() {
		Maqueta unaMaqueta = new Maqueta();
		Madera unaMadera = new Madera();
		
		unaMaqueta.agregarMaterialEnCelda(0, 0, unaMadera);
		assertEquals(unaMaqueta.getMaterialEnCelda(0, 0), unaMadera);
	}
	
	@Test
	void test04PisoUnMaterialEnUnaCeldaYNoDebeEstarElMaterialAnteriorSinoElUltimo() {
		Maqueta unaMaqueta = new Maqueta();
		Madera unaMadera = new Madera();
		Piedra unaPiedra = new Piedra();
		
		unaMaqueta.agregarMaterialEnCelda(0, 0, unaMadera);
		unaMaqueta.agregarMaterialEnCelda(0, 0, unaPiedra);
		assertEquals(unaMaqueta.getMaterialEnCelda(0, 0), unaPiedra);
	}
	
	@Test
	void test05LaMismaMaquetaEsIgualAEllaMisma() {
		Maqueta unaMaqueta = new Maqueta();

		assertTrue(unaMaqueta.esIgualA(unaMaqueta));
	}
	
	@Test
	void test06MaquetasConUnaCeldaDiferenteNoSonIguales() {
		Maqueta unaMaqueta = new Maqueta();
		Maqueta otraMaqueta = new Maqueta();
		
		otraMaqueta.agregarMaterialEnCelda(0, 0, new Piedra());
		
		assertFalse(unaMaqueta.esIgualA(otraMaqueta));
	}
	
}
