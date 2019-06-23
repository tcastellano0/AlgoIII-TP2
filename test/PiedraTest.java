import Herramientas.*;
import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PiedraTest {

	private void golpearCincoVecesElMaterialCon(Piedra piedra, Golpeador golpeadorHerramienta) {
		piedra.golpeadoPor(golpeadorHerramienta);
		piedra.golpeadoPor(golpeadorHerramienta);
		piedra.golpeadoPor(golpeadorHerramienta);
		piedra.golpeadoPor(golpeadorHerramienta);
		piedra.golpeadoPor(golpeadorHerramienta);
	}
	
    @Test
    public void test01PiedraEsGolpeadaPorPicoDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, picoDeMadera);

        assertEquals(piedra.getDurabilidad(), durabilidad - (picoDeMadera.getFuerza() * 5), 0);
    }

    @Test
    public void test02PiedraEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, picoDePiedra);

        assertEquals(piedra.getDurabilidad(), durabilidad - (picoDePiedra.getFuerza() * 5), 0);
    }

    @Test
    public void test03PiedraEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, picoDeMetal);

        assertEquals(piedra.getDurabilidad(), durabilidad - (picoDeMetal.getFuerza() * 5), 0);
    }

    @Test
    public void test04PiedraEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, hachaDeMadera);

        assertEquals(piedra.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test05PiedraEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, hachaDePiedra);

        assertEquals(piedra.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test06PiedraEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, hachaDeMetal);

        assertEquals(piedra.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test07PiedraEsGolpeadaPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = piedra.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(piedra, picoFino);

        assertEquals(piedra.getDurabilidad(), durabilidad - (picoFino.getFuerza() * 5), 0);
    }


    @Test
    public void testPiedraEsIgualAPiedra() {
        Piedra material1 = new Piedra();
        Piedra material2 = new Piedra();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    public void testPiedraNoEsIgualAMadera() {
        Piedra material1 = new Piedra();
        Madera material2 = new Madera();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testPiedraNoEsIgualAMetal() {
        Piedra material1 = new Piedra();
        Metal material2 = new Metal();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testPiedraNoEsIgualADiamante() {
        Piedra material1 = new Piedra();
        Diamante material2 = new Diamante();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testPiedraNoEsIgualAMaterialNulo() {
        Piedra material1 = new Piedra();
        MaterialNulo material2 = new MaterialNulo();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testAlRecolectarPiedraConDurabilidadDevuelveMaterialNulo() {
        Piedra piedra = new Piedra();

        assertFalse(piedra.esIgual(piedra.recolectar()));
    }
    
    @Test
    public void testAlRecolectarPiedraSinDurabilidadDevuelveLaPiedra() {
    	Piedra piedra = new Piedra();
        
        this.golpearCincoVecesElMaterialCon(piedra, new GolpeadorPicoFino());

        assertTrue(piedra.esIgual(piedra.recolectar()));
    }    
}