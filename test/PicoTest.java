import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoTest {
    @Test
    public void test01PicoDeMaderaSeInicializaConDurabilidad100(){
        PicoMadera pico = new PicoMadera();

        assertEquals(pico.getDurabilidad(), 100);
    }
    @Test
    public void test02PicoDeMaderaSeInicializaConFuerza2(){
        PicoMadera pico = new PicoMadera();

        assertEquals(pico.getFuerza(), 2);

    }
    @Test
    void test03PicoDePiedraSeInicializaConDurabilidad200(){
        PicoPiedra pico = new PicoPiedra();

        assertEquals(pico.getDurabilidad(), 200);
    }
    @Test
    void test04PicoDePiedraSeInicializaConFuerza4(){
        PicoPiedra pico = new PicoPiedra();

        assertEquals(pico.getFuerza(), 4);
    }
    @Test
    void test05PicoDeMetalSeInicializaConDurabilidad400(){
        PicoMetal pico = new PicoMetal();

        assertEquals(pico.getDurabilidad(), 400);
    }
    @Test
    void test06PicoDeMetalSeInicializaConFuerza12(){
        PicoMetal pico = new PicoMetal();

        assertEquals(pico.getFuerza(), 12);
    }

    @Test
    void test07PicoDeMaderaSeDesgastaIgualASuFuerza(){
        PicoMadera pico = new PicoMadera(); //fuerza 2, durabilidad 100

        pico.desgastar();
        assertEquals(pico.getDurabilidad(), 100 - pico.getFuerza());
    }

    @Test
    void test08PicoDePiedraSeDesgastaConSuFuerzaDivididoTresMedios(){
        PicoPiedra pico = new PicoPiedra(); //fuerza 4, durabilidad 200

        pico.desgastar();
        assertEquals(pico.getDurabilidad(), 200  - pico.getFuerza()/1.5);
    }

    @Test
    void test09PicoDeMetalSeRompeALos10Usos(){
        PicoMetal pico = new PicoMetal();

        IntStream.range(0, 9).parallel().forEach($ ->{
            pico.desgastar();
        });

        assertEquals(pico.getDurabilidad(), 0);
    }



}