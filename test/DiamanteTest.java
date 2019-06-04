import Herramientas.*;
import Materiales.Diamante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
}
