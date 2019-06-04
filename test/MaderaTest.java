import Herramientas.Hacha;
import Herramientas.Pico;
import Materiales.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaderaTest {

    @Test
    void test01MaderaEsGolpeadaPorHachaDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        Hacha hachaMadera = Hacha.crearHachaDeMadera(); //fuerza 2
        Madera madera = new Madera(); //durabilidad 10

        hachaMadera.golpear(madera);
        //madera.golpeadoPor(hachaMadera);

        assertEquals(madera.getDurabilidad(), 8);
    }

    @Test
    void test02MaderaEsGolpeadaPorHachaDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        Hacha hachaPiedra = Hacha.crearHachaDePiedra(); //fuerza 5
        Madera madera = new Madera(); //durabilidad 10

        hachaPiedra.golpear(madera);
        //madera.golpeadoPor(hachaPiedra);

        assertEquals(madera.getDurabilidad(), 5);
    }

    @Test
    void test03MaderaEsGolpeadaPorHachaDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        Hacha hachaMetal = Hacha.crearHachaDeMetal(); //fuerza 10
        Madera madera = new Madera(); //durabilidad 10

        hachaMetal.golpear(madera);
        //madera.golpeadoPor(hachaMetal);

        assertEquals(madera.getDurabilidad(), 0);
    }

    @Test
    void test04MaderaEsGolpeadaPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera(); //durabilidad 10
        Pico picoMadera = Pico.crearPicoDeMadera(); //fuerza 2

        picoMadera.golpear(madera);
        //madera.golpeadoPor(picoMadera);

        assertEquals(madera.getDurabilidad(), 10);
    }
    
    @Test
    void test05MaderaEsGolpeadaPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera(); //durabilidad 10
        Pico picoPiedra = Pico.crearPicoDePiedra(); //fuerza 5

        picoPiedra.golpear(madera);
        //madera.golpeadoPor(picoPiedra);

        assertEquals(madera.getDurabilidad(), 10);
    }
    
    @Test
    void test06MaderaEsGolpeadaPorPicoDeMetalYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera(); //durabilidad 10
        Pico picoMetal = Pico.crearPicoDeMetal(); //fuerza 10

        picoMetal.golpear(madera);
        //madera.golpeadoPor(picoMetal);

        assertEquals(madera.getDurabilidad(), 10);
    }
    
    @Test
    void test07MaderaEsGolpeadaPorPicoFinoYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera(); //durabilidad 10
        Pico picoFino = Pico.crearPicoFino(); //fuerza 20

        picoFino.golpear(madera);
        //madera.golpeadoPor(picoMetal);

        assertEquals(madera.getDurabilidad(), 10);
    }
    
    @Test
    void test08MaderaEsGolpeadaPorHachaDeMaderaQuedaCon0DurabilidadDespuesDe5Golpes() {
        Hacha hachaMadera = Hacha.crearHachaDeMadera(); //fuerza 2
        Madera madera = new Madera(); //durabilidad 10

        hachaMadera.golpear(madera);
        hachaMadera.golpear(madera);
        hachaMadera.golpear(madera);
        hachaMadera.golpear(madera);
        hachaMadera.golpear(madera);

        assertEquals(madera.getDurabilidad(), 0);
    }
    
    @Test
    void test09MaderaEsGolpeadaPorHachaDePiedraQuedaCon0DurabilidadDespuesDe2Golpes() {
        Hacha hachaPiedra = Hacha.crearHachaDePiedra(); //fuerza 5
        Madera madera = new Madera(); //durabilidad 10

        hachaPiedra.golpear(madera);
        hachaPiedra.golpear(madera);

        assertEquals(madera.getDurabilidad(), 0);
    }
    
    @Test
    void test10MaderaEsGolpeadaPorHachaDeMetalQuedaCon0DurabilidadDespuesDe1Golpe() {
        Hacha hachaMetal = Hacha.crearHachaDeMetal(); //fuerza 10
        Madera madera = new Madera(); //durabilidad 10

        hachaMetal.golpear(madera);

        assertEquals(madera.getDurabilidad(), 0);
    }
    
}
