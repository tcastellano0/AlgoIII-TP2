import Herramientas.Hacha;
import Herramientas.Pico;
import Materiales.Metal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetalTest {

	@Test
    void test01MetalEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Hacha hachaMadera = Hacha.crearHachaDeMadera(); //fuerza 2
        Metal metal = new Metal(); //durabilidad 50

        hachaMadera.golpear(metal);

        assertEquals(metal.getDurabilidad(), 50);
    }

    @Test
    void test02MetalEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Hacha hachaPiedra = Hacha.crearHachaDePiedra(); //fuerza 5
        Metal metal = new Metal(); //durabilidad 50

        hachaPiedra.golpear(metal);

        assertEquals(metal.getDurabilidad(), 50);
    }

    @Test
    void test03MetalEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Hacha hachaMetal = Hacha.crearHachaDeMetal(); //fuerza 10
        Metal metal = new Metal(); //durabilidad 50

        hachaMetal.golpear(metal);

        assertEquals(metal.getDurabilidad(), 50);
    }

    @Test
    void test04MetalEsGolpeadaPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
    	Pico picoMadera = Pico.crearPicoDeMadera(); //fuerza 2
    	Metal metal = new Metal(); //durabilidad 50
    	
        picoMadera.golpear(metal);

        assertEquals(metal.getDurabilidad(), 50);
    }
    
    @Test
    void test05MetalEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Pico picoPiedra = Pico.crearPicoDePiedra(); //fuerza 4
        Metal metal = new Metal(); //durabilidad 50
        
        picoPiedra.golpear(metal);

        assertEquals(metal.getDurabilidad(), 46);
    }
    
    @Test
    void test06MetalEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
    	Pico picoMetal = Pico.crearPicoDeMetal(); //fuerza 12
    	Metal metal = new Metal(); //durabilidad 50
    	
        picoMetal.golpear(metal);

        assertEquals(metal.getDurabilidad(), 38);
    }
    
    @Test
    void test07MetalEsGolpeadaPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
    	Pico picoFino = Pico.crearPicoFino(); //fuerza 20
    	Metal metal = new Metal(); //durabilidad 50
    	
    	picoFino.golpear(metal);

        assertEquals(metal.getDurabilidad(), 30);
    }
	
	
}
