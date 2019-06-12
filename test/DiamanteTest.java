import Herramientas.*;
import Materiales.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DiamanteTest {

	@Test
    void test01DiamanteEsGolpeadoPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(hachaDeMadera);
            assertEquals(diamante.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test02DiamanteEsGolpeadoPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(hachaDePiedra);
            assertEquals(diamante.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test03DiamanteEsGolpeadoPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(hachaDeMetal);
            assertEquals(diamante.getDurabilidad(), durabilidad);
        }
    }

    @Test
    void test04DiamanteEsGolpeadoPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(picoDeMadera);
            assertEquals(diamante.getDurabilidad(), durabilidad);
        }
    }
    
    @Test
    void test05DiamanteEsGolpeadoPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(picoDePiedra);
            assertEquals(diamante.getDurabilidad(), durabilidad);
        }
    }
    
    @Test
    void test06DiamanteEsGolpeadoPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(picoDePiedra);
            assertEquals(diamante.getDurabilidad(), durabilidad);
        }
    }
    
    @Test
    void test07DiamanteEsGolpeadoPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Diamante diamante = new Diamante();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = diamante.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            diamante.golpeadoPor(picoFino);
            assertEquals(diamante.getDurabilidad(), durabilidad - picoFino.getFuerza());
            durabilidad = diamante.getDurabilidad();
        }
    }


    @Test
    void testDiamanteEsIgualADiamante() {
        Diamante material1 = new Diamante();
        Diamante material2 = new Diamante();

        assertTrue(material1.esIgual(material2));
    }

    @Test
    void testDiamanteNoEsIgualAMadera() {
        Diamante material1 = new Diamante();
        Madera material2 = new Madera();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    void testDiamanteNoEsIgualAPiedra() {
        Diamante material1 = new Diamante();
        Piedra material2 = new Piedra();

        assertFalse(material1.esIgual(material2));
    }

    @Test
    void testDiamanteNoEsIgualAMetal() {
        Diamante material1 = new Diamante();
        Metal material2 = new Metal();

        assertFalse(material1.esIgual(material2));
    }

}
