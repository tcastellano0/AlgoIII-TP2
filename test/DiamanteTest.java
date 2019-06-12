import Herramientas.*;
import Materiales.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DiamanteTest {

	@Test
    void test01DiamanteEsGolpeadoCincoVecesPorHachaDeMaderaYSuDurabilidadSigueIgual() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDeMadera hachaDeMadera = new GolpeadorHachaDeMadera();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(hachaDeMadera);
        diamante.golpeadoPor(hachaDeMadera);
        diamante.golpeadoPor(hachaDeMadera);
        diamante.golpeadoPor(hachaDeMadera);
        diamante.golpeadoPor(hachaDeMadera);

        assertEquals(diamante.getDurabilidad(), durabilidad);
    }

    @Test
    void test02DiamanteEsGolpeadoCincoVecesPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDePiedra hachaDePiedra = new GolpeadorHachaDePiedra();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(hachaDePiedra);
        diamante.golpeadoPor(hachaDePiedra);
        diamante.golpeadoPor(hachaDePiedra);
        diamante.golpeadoPor(hachaDePiedra);
        diamante.golpeadoPor(hachaDePiedra);

        assertEquals(diamante.getDurabilidad(), durabilidad);
    }

    @Test
    void test03DiamanteEsGolpeadoCincoVecesPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Diamante diamante = new Diamante();
        GolpeadorHachaDeMetal hachaDeMetal = new GolpeadorHachaDeMetal();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(hachaDeMetal);
        diamante.golpeadoPor(hachaDeMetal);
        diamante.golpeadoPor(hachaDeMetal);
        diamante.golpeadoPor(hachaDeMetal);
        diamante.golpeadoPor(hachaDeMetal);

        assertEquals(diamante.getDurabilidad(), durabilidad);
    }

    @Test
    void test04DiamanteEsGolpeadoCincoVecesPorPicoDeMaderaYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDeMadera picoDeMadera = new GolpeadorPicoDeMadera();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(picoDeMadera);
        diamante.golpeadoPor(picoDeMadera);
        diamante.golpeadoPor(picoDeMadera);
        diamante.golpeadoPor(picoDeMadera);
        diamante.golpeadoPor(picoDeMadera);

        assertEquals(diamante.getDurabilidad(), durabilidad);
    }
    
    @Test
    void test05DiamanteEsGolpeadoCincoVecesPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);

        assertEquals(diamante.getDurabilidad(), durabilidad);
    }
    
    @Test
    void test06DiamanteEsGolpeadoCincoVecesPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Diamante diamante = new Diamante();
        GolpeadorPicoDePiedra picoDePiedra = new GolpeadorPicoDePiedra();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);
        diamante.golpeadoPor(picoDePiedra);

        assertEquals(diamante.getDurabilidad(), durabilidad);
    }

    @Test
    void test07DiamanteEsGolpeadoUnaVezPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPico(){
        Diamante diamante = new Diamante();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(picoFino);

        assertEquals(diamante.getDurabilidad(), durabilidad - picoFino.getFuerza());
    }

    @Test
    void testDiamanteEsGolpeadoCincoVecesPorPicoFinoYSeReduceSuDurabilidadIgualALaFuerzaDelPicoPorCinco(){
        Diamante diamante = new Diamante();
        GolpeadorPicoFino picoFino = new GolpeadorPicoFino();
        double durabilidad = diamante.getDurabilidad();

        diamante.golpeadoPor(picoFino);
        diamante.golpeadoPor(picoFino);
        diamante.golpeadoPor(picoFino);
        diamante.golpeadoPor(picoFino);
        diamante.golpeadoPor(picoFino);

        assertEquals(diamante.getDurabilidad(), durabilidad - (picoFino.getFuerza() * 5));
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
