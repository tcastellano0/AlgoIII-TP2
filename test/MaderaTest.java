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
}
