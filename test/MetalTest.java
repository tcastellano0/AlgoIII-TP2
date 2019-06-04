import Herramientas.*;
import Materiales.Metal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetalTest {

	@Test
    void test01MetalEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(hachaDeMadera);
            assertEquals(metal.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test02MetalEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(hachaDePiedra);
            assertEquals(metal.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test03MetalEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Metal metal = new Metal();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(hachaDeMetal);
            assertEquals(metal.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test04MetalEsGolpeadaPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(picoDeMadera);
            assertEquals(metal.getDurabilidad(), durabilidad);
        }
    }
    
    @Test
    void test05MetalEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(picoDePiedra);
            assertEquals(metal.getDurabilidad(), durabilidad - picoDePiedra.getFuerza());
            durabilidad = metal.getDurabilidad();
        }
    }
    
    @Test
    void test06MetalEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(picoDeMetal);
            assertEquals(metal.getDurabilidad(), durabilidad - picoDeMetal.getFuerza());
            durabilidad = metal.getDurabilidad();
        }
    }
    
    @Test
    void test07MetalEsGolpeadaPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Metal metal = new Metal();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = metal.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            metal.golpeadoPor(picoFino);
            assertEquals(metal.getDurabilidad(), durabilidad - picoFino.getFuerza());
            durabilidad = metal.getDurabilidad();
        }
    }
	
	
}
