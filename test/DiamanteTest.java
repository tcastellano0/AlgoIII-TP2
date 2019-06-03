import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiamanteTest {

	@Test
    void test01MetalEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Hacha hachaMadera = Hacha.crearHachaDeMadera(); //fuerza 2
        Diamante diamante = new Diamante(); //durabilidad 100

        hachaMadera.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 100);
    }

    @Test
    void test02MetalEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Hacha hachaPiedra = Hacha.crearHachaDePiedra(); //fuerza 5
        Diamante diamante = new Diamante(); //durabilidad 100

        hachaPiedra.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 100);
    }

    @Test
    void test03MetalEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Hacha hachaMetal = Hacha.crearHachaDeMetal(); //fuerza 10
        Diamante diamante = new Diamante(); //durabilidad 100

        hachaMetal.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 100);
    }

    @Test
    void test04MetalEsGolpeadaPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
    	Pico picoMadera = Pico.crearPicoDeMadera(); //fuerza 2
    	Diamante diamante = new Diamante(); //durabilidad 100
    	
        picoMadera.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 100);
    }
    
    @Test
    void test05MetalEsGolpeadaPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Pico picoPiedra = Pico.crearPicoDePiedra(); //fuerza 4
        Diamante diamante = new Diamante(); //durabilidad 100
        
        picoPiedra.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 100);
    }
    
    @Test
    void test06MetalEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
    	Pico picoMetal = Pico.crearPicoDeMetal(); //fuerza 12
    	Diamante diamante = new Diamante(); //durabilidad 100
    	
        picoMetal.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 88);
    }
    
    @Test
    void test07MetalEsGolpeadaPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
    	Pico picoFino = Pico.crearPicoFino(); //fuerza 20
    	Diamante diamante = new Diamante(); //durabilidad 100
    	
    	picoFino.golpear(diamante);

        assertEquals(diamante.getDurabilidad(), 80);
    }
	
}
