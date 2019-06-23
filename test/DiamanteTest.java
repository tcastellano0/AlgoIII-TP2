import Herramientas.*;
import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DiamanteTest {
	
	private void golpearCincoVecesElMaterialCon(Diamante diamante, Golpeador golpeadorHerramienta) {
		diamante.golpeadoPor(golpeadorHerramienta);
		diamante.golpeadoPor(golpeadorHerramienta);
		diamante.golpeadoPor(golpeadorHerramienta);
		diamante.golpeadoPor(golpeadorHerramienta);
		diamante.golpeadoPor(golpeadorHerramienta);
	}
	
	@Test
    public void test01DiamanteEsGolpeadoCincoVecesPorHachaDeMaderaYSuDurabilidadSigueIgual() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, hachaDeMadera);

        assertEquals(diamante.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test02DiamanteEsGolpeadoCincoVecesPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, hachaDePiedra);

        assertEquals(diamante.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test03DiamanteEsGolpeadoCincoVecesPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, hachaDeMetal);

        assertEquals(diamante.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test04DiamanteEsGolpeadoCincoVecesPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, picoDeMadera);

        assertEquals(diamante.getDurabilidad(), durabilidad, 0);
    }
    
    @Test
    public void test05DiamanteEsGolpeadoCincoVecesPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, picoDePiedra);

        assertEquals(diamante.getDurabilidad(), durabilidad, 0);
    }
    
    @Test
    public void test06DiamanteEsGolpeadoCincoVecesPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, picoDeMetal);

        assertEquals(diamante.getDurabilidad(), durabilidad - (picoDeMetal.getFuerza() * 5), 0);
    }

    @Test
    public void test07DiamanteEsGolpeadoUnaVezPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Diamante diamante = new Diamante();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(picoFino);

        assertEquals(diamante.getDurabilidad(), durabilidad - picoFino.getFuerza(), 0);
    }

    @Test
    public void testDiamanteEsGolpeadoCincoVecesPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPicoPorCinco(){
        Diamante diamante = new Diamante();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = diamante.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(diamante, picoFino);

        assertEquals(diamante.getDurabilidad(), durabilidad - (picoFino.getFuerza() * 5), 0);
    }


    @Test
    public void testDiamanteEsIgualADiamante() {
        Diamante material1 = new Diamante();
        Diamante material2 = new Diamante();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    public void testDiamanteNoEsIgualAMadera() {
        Diamante material1 = new Diamante();
        Madera material2 = new Madera();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testDiamanteNoEsIgualAPiedra() {
        Diamante material1 = new Diamante();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testDiamanteNoEsIgualAMetal() {
        Diamante material1 = new Diamante();
        Metal material2 = new Metal();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testDiamanteNoEsIgualAMaterialNulo() {
        Diamante material1 = new Diamante();
        MaterialNulo material2 = new MaterialNulo();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testAlRecolectarDiamanteConDurabilidadDevuelveMaterialNulo() {
    	Diamante diamante = new Diamante();

        assertFalse(diamante.esIgual(diamante.recolectar()));
    }
    
    @Test
    public void testAlRecolectarDiamanteSinDurabilidadDevuelveElDiamante() {
    	Diamante diamante = new Diamante();
        
        this.golpearCincoVecesElMaterialCon(diamante, new GolpeadorPicoFino());

        assertTrue(diamante.esIgual(diamante.recolectar()));
    }

}
