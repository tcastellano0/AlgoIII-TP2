import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoTest {
    @Test
    public void test01PicoDeMaderaSeInicializaConDurabilidad100(){
        Pico pico = Pico.crearPicoDeMadera();

        assertEquals(pico.getDurabilidad(), 100);
    }
    
    @Test
    public void test02PicoDeMaderaSeInicializaConFuerza2(){
        Pico pico = Pico.crearPicoDeMadera();

        assertEquals(pico.getFuerza(), 2);
    }
    
    @Test
    void test03PicoDePiedraSeInicializaConDurabilidad200(){
        Pico pico = Pico.crearPicoDePiedra();

        assertEquals(pico.getDurabilidad(), 200);
    }
    
    @Test
    void test04PicoDePiedraSeInicializaConFuerza4(){
        Pico pico = Pico.crearPicoDePiedra();

        assertEquals(pico.getFuerza(), 4);
    }
    
    @Test
    void test05PicoDeMetalSeInicializaConDurabilidad400(){
        Pico pico = Pico.crearPicoDeMetal();

        assertEquals(pico.getDurabilidad(), 400);
    }
    
    @Test
    void test06PicoDeMetalSeInicializaConFuerza12(){
        Pico pico = Pico.crearPicoDeMetal();

        assertEquals(pico.getFuerza(), 12);
    }

    @Test
    void test07PicoDeMaderaSeDesgastaIgualASuFuerza(){
        Pico pico = Pico.crearPicoDeMadera(); //fuerza 2, durabilidad 100

        pico.desgastar();
        assertEquals(pico.getDurabilidad(), 100 - pico.getFuerza());
    }

    @Test
    void test08PicoDePiedraSeDesgastaConSuFuerzaDivididoTresMedios(){
        Pico pico = Pico.crearPicoDePiedra(); //fuerza 4, durabilidad 200

        pico.desgastar();
        assertEquals(pico.getDurabilidad(), 200  - pico.getFuerza()/1.5);
    }
    
    @Test
    void test09PicoDeMetalSeRompeALos10Usos(){
        Pico pico = Pico.crearPicoDeMetal();

        for(int i = 0; i < 10; i++) {
        	pico.desgastar();
        }

        assertEquals(pico.getDurabilidad(), 0);
    }
    
    @Test
    void test10PicoDeMetalSeRompeNoSeDeberiaRomperAntesDeLosDiezUsos(){
        Pico pico = Pico.crearPicoDeMetal();

        for(int i = 0; i < 5; i++) {
        	pico.desgastar();
        }

        assertEquals(pico.getDurabilidad(), 400);
    }

}