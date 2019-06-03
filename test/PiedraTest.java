import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiedraTest {

    @Test
    void test01PiedraEsGolpeadaPorPicoDeMaderaYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        Pico pico = Pico.crearPicoDeMadera();
        double durabilidadInicial = piedra.getDurabilidad();

    	pico.golpear(piedra);
        //piedra.golpeadoPor(pico);

        assertEquals(piedra.getDurabilidad(), durabilidadInicial - pico.getFuerza() );
    }

    @Test
    void test02PiedraEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        Pico pico = Pico.crearPicoDePiedra();
        double durabilidadInicial = piedra.getDurabilidad();

    	pico.golpear(piedra);
        //piedra.golpeadoPor(pico);

        assertEquals(piedra.getDurabilidad(), durabilidadInicial - pico.getFuerza() );
    }
    @Test
    void test03PiedraEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidadIgualALaFuerzaDelPico() {
        Piedra piedra = new Piedra();
        Pico pico = Pico.crearPicoDeMetal();
        double durabilidadInicial = piedra.getDurabilidad();

        pico.golpear(piedra);
        //piedra.golpeadoPor(pico);

        assertEquals(piedra.getDurabilidad(), durabilidadInicial - pico.getFuerza() );
    }

    @Test
    void test04PiedraEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        Hacha hacha = Hacha.crearHachaDeMadera();
        double durabilidadInicial = piedra.getDurabilidad();

        hacha.golpear(piedra);
        //piedra.golpeadoPor(hacha);

        assertEquals(piedra.getDurabilidad(), durabilidadInicial );
    }
    @Test
    void test05PiedraEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        Hacha hacha = Hacha.crearHachaDePiedra();
        double durabilidadInicial = piedra.getDurabilidad();

        hacha.golpear(piedra);
        //piedra.golpeadoPor(hacha);

        assertEquals(piedra.getDurabilidad(), durabilidadInicial );
    }
    @Test
    void test06PiedraEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad() {
        Piedra piedra = new Piedra();
        Hacha hacha = Hacha.crearHachaDeMetal();
        double durabilidadInicial = piedra.getDurabilidad();

        hacha.golpear(piedra);
        //piedra.golpeadoPor(hacha);

        assertEquals(piedra.getDurabilidad(), durabilidadInicial );
    }
}