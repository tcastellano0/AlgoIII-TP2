import Herramientas.*;
import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MetalTest {

    public void golpearCincoVecesElMaterialCon(Material material, Golpeador golpeador){
        material.golpeadoPor(golpeador);
        material.golpeadoPor(golpeador);
        material.golpeadoPor(golpeador);
        material.golpeadoPor(golpeador);
        material.golpeadoPor(golpeador);
    }

	@Test
    public void test01MetalEsGolpeadaCincoVecesPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, hachaDeMadera);

        assertEquals(metal.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test02MetalEsGolpeadaCincoVecesPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, hachaDePiedra);

        assertEquals(metal.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test03MetalEsGolpeadaCincoVecesPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, hachaDeMetal);

        assertEquals(metal.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test04MetalEsGolpeadaCincoVecesPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, picoDeMadera);

        assertEquals(metal.getDurabilidad(), durabilidad, 0);
    }
    
    @Test
    public void test05MetalEsGolpeadaCincoVecesPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPicoPorCinco(){
        Metal metal = new Metal();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, picoDePiedra);

        assertEquals(metal.getDurabilidad(), durabilidad - (picoDePiedra.getFuerza() * 5), 0);
    }
    
    @Test
    public void test06MetalEsGolpeadaCincoVecesPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, picoDeMetal);

        assertEquals(metal.getDurabilidad(), durabilidad - (picoDeMetal.getFuerza() * 5), 0);
    }
    
    @Test
    public void test07MetalEsGolpeadaCincoVecesPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, picoFino);

        assertEquals(metal.getDurabilidad(), durabilidad - (picoFino.getFuerza() * 5), 0);
    }


    @Test
    public void testMetalEsIgualAMetal() {
        Metal material1 = new Metal();
        Metal material2 = new Metal();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    public void testMetalNoEsIgualAMadera() {
        Metal material1 = new Metal();
        Madera material2 = new Madera();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testMetalNoEsIgualAPiedra() {
        Metal material1 = new Metal();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testMetalNoEsIgualADiamante() {
        Metal material1 = new Metal();
        Diamante material2 = new Diamante();

        assertFalse(material1.esIgual(material2));
    }
    
    @Test
    public void testMetalNoEsIgualAMaterialNulo() {
        Metal material1 = new Metal();
        MaterialNulo material2 = new MaterialNulo();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    public void testAlRecolectarMetalConDurabilidadDevuelveMaterialNulo() {
    	Metal metal = new Metal();

        assertFalse(metal.esIgual(metal.recolectar()));
    }
    
    @Test
    public void testAlRecolectarMetalSinDurabilidadDevuelveElMetal() {
    	Metal metal = new Metal();
        
        this.golpearCincoVecesElMaterialCon(metal, new GolpeadorPicoFino());

        assertTrue(metal.esIgual(metal.recolectar()));
    }

    

}
