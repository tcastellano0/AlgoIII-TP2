import Herramientas.*;
import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MaderaTest {

	private void golpearCincoVecesElMaterialCon(Madera madera, Golpeador golpeadorHerramienta) {
		madera.golpeadoPor(golpeadorHerramienta);
        madera.golpeadoPor(golpeadorHerramienta);
        madera.golpeadoPor(golpeadorHerramienta);
        madera.golpeadoPor(golpeadorHerramienta);
        madera.golpeadoPor(golpeadorHerramienta);
	}
	
    @Test
    public void test01MaderaEsGolpeadaCincoVecesPorHachaDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelHachaPorCinco() {
        Madera madera = new Madera();
        GolpeadorHachaDeMadera hachaMadera = new GolpeadorHachaDeMadera();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, hachaMadera);

        assertEquals(madera.getDurabilidad(), durabilidad - (hachaMadera.getFuerza() * 5), 0);
    }

    @Test
    public void test01MaderaEsGolpeadaUnaVezPorHachaDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        Madera madera = new Madera();
        GolpeadorHachaDeMadera hachaMadera = new GolpeadorHachaDeMadera();
        double durabilidad = madera.getDurabilidad();

        madera.golpeadoPor(hachaMadera);

        assertEquals(madera.getDurabilidad(), durabilidad - hachaMadera.getFuerza(), 0);
    }

    @Test
    public void test02MaderaEsGolpeadaCincoVecesPorHachaDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelHachaPorCinco() {
        Madera madera = new Madera();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, hachaDePiedra);
        
        assertEquals(madera.getDurabilidad(), durabilidad - (hachaDePiedra.getFuerza() * 5), 0);
    }

    @Test
    public void test03MaderaEsGolpeadaPorHachaDeMetalCincoVecesYSeReduceSuDurabilidadIgualALaFuerzaDelHachaPorCinco() {
        Madera madera = new Madera();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, hachaDeMetal);

        assertEquals(madera.getDurabilidad(), durabilidad - (hachaDeMetal.getFuerza() * 5), 0);
    }

    @Test
    public void test04MaderaEsGolpeadaCincoVecesPorPicoDeMaderaYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoDeMadera picoMadera = new GolpeadorPicoDeMadera();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, picoMadera);
        
        assertEquals(madera.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test05MaderaEsGolpeadaCincoVecesPorPicoDePiedraYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, picoDePiedra);

        assertEquals(madera.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test06MaderaEsGolpeadaCincoVecesPorPicoDeMetalYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, picoDeMetal);
        
        assertEquals(madera.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test07MaderaEsGolpeadaCincoVecesPorPicoFinoYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = madera.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(madera, picoFino);

        assertEquals(madera.getDurabilidad(), durabilidad, 0);
    }


    @Test
    public void testMaderaEsIgualAMadera() {
        Madera material1 = new Madera();
        Madera material2 = new Madera();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    public void testMaderaNoEsIgualAPiedra() {
        Madera material1 = new Madera();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testMaderaNoEsIgualAMetal() {
        Madera material1 = new Madera();
        Metal material2 = new Metal();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testMaderaNoEsIgualADiamante() {
        Madera material1 = new Madera();
        Diamante material2 = new Diamante();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testMaderaNoEsIgualAMaterialNulo() {
        Madera material1 = new Madera();
        MaterialNulo material2 = new MaterialNulo();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testAlRecolectarMaderaConDurabilidadDevuelveMaterialNulo() {
        Madera madera = new Madera();

        assertFalse(madera.esIgual(madera.recolectar()));
    }
    
    @Test
    public void testAlRecolectarMaderaSinDurabilidadDevuelveLaMadera() {
        Madera madera = new Madera();
        
        this.golpearCincoVecesElMaterialCon(madera, new GolpeadorHachaDeMadera());

        assertTrue(madera.esIgual(madera.recolectar()));
    }

}
