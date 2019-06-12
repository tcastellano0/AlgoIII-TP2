import Herramientas.*;
import Materiales.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaderaTest {

    @Test
    void test01MaderaEsGolpeadaPorHachaDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelHacha() {
        Madera madera = new Madera();
        GolpeadorHachaDeMadera hachaMadera = new GolpeadorHachaDeMadera();
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
        Madera madera = new Madera();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
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
        Madera madera = new Madera();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 5; i++) { //golpeo varias veces y veo que se reduce
            madera.golpeadoPor(hachaDeMetal);
            assertEquals(madera.getDurabilidad(), durabilidad - hachaDeMetal.getFuerza());
            durabilidad = madera.getDurabilidad();
        }
    }

    @Test
    void test04MaderaEsGolpeadaPorPicoDeMaderaYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoDeMadera picoMadera = new GolpeadorPicoDeMadera();
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoMadera);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test05MaderaEsGolpeadaPorPicoDePiedraYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoDePiedra);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }

    }

    @Test
    void test06MaderaEsGolpeadaPorPicoDeMetalYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoDeMetal);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test07MaderaEsGolpeadaPorPicoFinoYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = madera.getDurabilidad();

        for (int i = 0; i < 10; i++) { //golpeo varias veces y veo que no se reduce
            madera.golpeadoPor(picoFino);
            assertEquals(madera.getDurabilidad(), durabilidad);
        }
    }


    @Test
    void testMaderaEsIgualAMadera() {
        Madera material1 = new Madera();
        Madera material2 = new Madera();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    void testMaderaNoEsIgualAPiedra() {
        Madera material1 = new Madera();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    void testMaderaNoEsIgualAMetal() {
        Madera material1 = new Madera();
        Metal material2 = new Metal();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    void testMaderaNoEsIgualADiamante() {
        Madera material1 = new Madera();
        Diamante material2 = new Diamante();

        assertFalse(material1.esIgual(material2));
    }


}
