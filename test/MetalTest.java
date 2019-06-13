import Herramientas.*;
import Materiales.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MetalTest {

    void golpearCincoVecesElMaterialCon(Material material, Golpeador golpeador){
        material.golpeadoPor(golpeador);
    }

	@Test
    void test01MetalEsGolpeadaCincoVecesPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, hachaDeMadera);

        assertEquals(metal.getDurabilidad(), durabilidad);
    }

    @Test
    void test02MetalEsGolpeadaCincoVecesPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, hachaDePiedra);

        assertEquals(metal.getDurabilidad(), durabilidad);
    }

    @Test
    void test03MetalEsGolpeadaCincoVecesPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, hachaDeMetal);

        assertEquals(metal.getDurabilidad(), durabilidad);
    }

    @Test
    void test04MetalEsGolpeadaCincoVecesPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = metal.getDurabilidad();

        this.golpearCincoVecesElMaterialCon(metal, picoDeMadera);

        assertEquals(metal.getDurabilidad(), durabilidad);
    }
    
    @Test
    void test05MetalEsGolpeadaCincoVecesPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPicoPorCinco(){
        Metal metal = new Metal();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = metal.getDurabilidad();

        metal.golpeadoPor(picoDePiedra);
        metal.golpeadoPor(picoDePiedra);
        metal.golpeadoPor(picoDePiedra);
        metal.golpeadoPor(picoDePiedra);
        metal.golpeadoPor(picoDePiedra);

        assertEquals(metal.getDurabilidad(), durabilidad - (picoDePiedra.getFuerza() * 5));
    }
    
    @Test
    void test06MetalEsGolpeadaCincoVecesPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = metal.getDurabilidad();

        metal.golpeadoPor(picoDeMetal);
        metal.golpeadoPor(picoDeMetal);
        metal.golpeadoPor(picoDeMetal);
        metal.golpeadoPor(picoDeMetal);
        metal.golpeadoPor(picoDeMetal);

        assertEquals(metal.getDurabilidad(), durabilidad - (picoDeMetal.getFuerza() * 5));
    }
    
    @Test
    void test07MetalEsGolpeadaCincoVecesPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = metal.getDurabilidad();

        metal.golpeadoPor(picoFino);
        metal.golpeadoPor(picoFino);
        metal.golpeadoPor(picoFino);
        metal.golpeadoPor(picoFino);
        metal.golpeadoPor(picoFino);

        assertEquals(metal.getDurabilidad(), durabilidad - (picoFino.getFuerza() * 5));
    }


    @Test
    void testMetalEsIgualAMetal() {
        Metal material1 = new Metal();
        Metal material2 = new Metal();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    void testMetalNoEsIgualAMadera() {
        Metal material1 = new Metal();
        Madera material2 = new Madera();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    void testMetalNoEsIgualAPiedra() {
        Metal material1 = new Metal();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    void testMetalNoEsIgualADiamante() {
        Metal material1 = new Metal();
        Diamante material2 = new Diamante();

        assertFalse(material1.esIgual(material2));
    }

}
