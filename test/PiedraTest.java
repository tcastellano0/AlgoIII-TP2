import Herramientas.*;
import Materiales.Piedra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiedraTest {

    @Test
    void test01PiedraEsGolpeadaPorPicoDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(picoDeMadera);
            assertEquals(piedra.getDurabilidad(), durabilidad - picoDeMadera.getFuerza());
            durabilidad = piedra.getDurabilidad();
        }
    }

    @Test
    void test02PiedraEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(picoDePiedra);
            assertEquals(piedra.getDurabilidad(), durabilidad - picoDePiedra.getFuerza());
            durabilidad = piedra.getDurabilidad();
        }
    }

    @Test
    void test03PiedraEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoDeMetal picoDeMetal = new GolpeadorPicoDeMetal();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(picoDeMetal);
            assertEquals(piedra.getDurabilidad(), durabilidad - picoDeMetal.getFuerza());
            durabilidad = piedra.getDurabilidad();
        }
    }

    @Test
    void test04PiedraEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(hachaDeMadera);
            assertEquals(piedra.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test05PiedraEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(hachaDePiedra);
            assertEquals(piedra.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test06PiedraEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(hachaDeMetal);
            assertEquals(piedra.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test07PiedraEsGolpeadaPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = piedra.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            piedra.golpeadoPor(picoFino);
            assertEquals(piedra.getDurabilidad(), durabilidad - picoFino.getFuerza());
            durabilidad = piedra.getDurabilidad();
        }
    }


}