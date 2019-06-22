import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MaterialNuloTest {
	
	
	
	@Test
    public void testMaterialNuloEsIgualAMaterialNulo() {
        MaterialNulo material1 = new MaterialNulo();
        MaterialNulo material2 = new MaterialNulo();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    public void testMaterialNuloNoEsIgualAMadera() {
    	MaterialNulo material1 = new MaterialNulo();
        Madera material2 = new Madera();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testMaterialNuloNoEsIgualAPiedra() {
    	MaterialNulo material1 = new MaterialNulo();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testMaterialNuloNoEsIgualAMetal() {
        MaterialNulo material1 = new MaterialNulo();
        Metal material2 = new Metal();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testMaterialNuloNoEsIgualADiamante() {
        MaterialNulo material1 = new MaterialNulo();
        Diamante material2 = new Diamante();

        assertFalse(material1.esIgual(material2));
    }

}
