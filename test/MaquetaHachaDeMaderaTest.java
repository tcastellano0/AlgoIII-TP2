import Materiales.*;
import Herramientas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaquetaHachaDeMaderaTest {
	
	@Test
    void test01MaquetaConCeldasIgualesALaMaquetaDeHachaDeMaderaEsIgual() {
		Maqueta maquetaUnaHerramienta = new Maqueta();
		MaquetaHachaDeMadera maquetaHachaDeMadera = new MaquetaHachaDeMadera();
		
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 0, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 1, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 2, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(1, 1, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(2, 1, new Madera());
		
		assertTrue(maquetaHachaDeMadera.esIgualA(maquetaUnaHerramienta));
	}
	
	@Test
    void test02MaquetaConCeldasDistinasALaMaquetaDeHachaDeMaderaEsDistinta() {
		Maqueta maquetaUnaHerramienta = new Maqueta();
		MaquetaHachaDeMadera maquetaHachaDeMadera = new MaquetaHachaDeMadera();
		
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 1, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 2, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(1, 1, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(2, 1, new Madera());
		
		assertFalse(maquetaHachaDeMadera.esIgualA(maquetaUnaHerramienta));
	}
	
	@Test
    void test03MaquetaConCeldasIgualesPeroMaterialesDisintosEsDistintaALaMaquetaDeHachaDeMadera() {
		Maqueta maquetaUnaHerramienta = new Maqueta();
		MaquetaHachaDeMadera maquetaHachaDeMadera = new MaquetaHachaDeMadera();
		
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 0, new Piedra());
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 1, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(0, 2, new Madera());
		maquetaUnaHerramienta.agregarMaterialEnCelda(1, 1, new Piedra());
		maquetaUnaHerramienta.agregarMaterialEnCelda(2, 1, new Madera());
		
		assertFalse(maquetaHachaDeMadera.esIgualA(maquetaUnaHerramienta));
	}
	
	@Test
	void test04MaquetaVaciaEsDistintaALaMaquetaDeHachaDeMadera() {
		Maqueta maquetaUnaHerramienta = new Maqueta();
		MaquetaHachaDeMadera maquetaHachaDeMadera = new MaquetaHachaDeMadera();
		
		assertFalse(maquetaHachaDeMadera.esIgualA(maquetaUnaHerramienta));
	}

}
