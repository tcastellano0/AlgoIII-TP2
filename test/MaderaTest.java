import Herramientas.*;
import Materiales.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaderaTest {

    @Test
    void test01MaderaEsGolpeadaPorHachaDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        GolpeadorHachaDeMadera hachaMadera = new GolpeadorHachaDeMadera(); //fuerza 2
        Madera madera = new Madera(); //durabilidad 10
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 5; i++) { //golpeo varias veces y veo que se reduce
            madera.golpeadoPor(hachaMadera);
            assertEquals(madera.getDurabilidad(), durabilidad - hachaMadera.getFuerza());
            durabilidad = madera.getDurabilidad();
        }
    }

    @Test
    void test02MaderaEsGolpeadaPorHachaDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        //aun no esta definido que pasa si la durabilidad llega a 0 o es negativa, este test
        //seguramente falle en el futuro
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra(); //fuerza 5
        Madera madera = new Madera(); //durabilidad 10
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 5; i++) { //golpeo varias veces y veo que se reduce
            madera.golpeadoPor(hachaDePiedra);
            assertEquals(madera.getDurabilidad(), durabilidad - hachaDePiedra.getFuerza());
            durabilidad = madera.getDurabilidad();
        }
    }

    @Test
    void test03MaderaEsGolpeadaPorHachaDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        //aun no esta definido que pasa si la durabilidad llega a 0 o es negativa, este test
        //seguramente falle en el futuro
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal(); //fuerza 10
        Madera madera = new Madera(); //durabilidad 10
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 5; i++) { //golpeo varias veces y veo que se reduce
            madera.golpeadoPor(hachaDeMetal);
            assertEquals(madera.getDurabilidad(), durabilidad - hachaDeMetal.getFuerza());
            durabilidad = madera.getDurabilidad();
        }
    }

    @Test
    void test04MaderaEsGolpeadaPorPicoDeMaderaYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera(); //durabilidad 10
        GolpeadorPicoDeMadera picoMadera = new GolpeadorPicoDeMadera(); //fuerza 2
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoMadera);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test05MaderaEsGolpeadaPorPicoDePiedraYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera(); //durabilidad 10
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra(); //fuerza 4
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoDePiedra);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }

    }

    @Test
    void test06MaderaEsGolpeadaPorPicoDeMetalYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera(); //durabilidad 10
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal(); //fuerza 12
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoDeMetal);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test07MaderaEsGolpeadaPorPicoFinoYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera(); //durabilidad 10
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino(); //fuerza 20
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoFino);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }
    }
}
