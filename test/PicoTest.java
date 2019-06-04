import Herramientas.Pico;
import Materiales.Madera;
import org.junit.jupiter.api.Test;

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
        int fuerzaDesgaste = pico.getFuerza();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), 100 - fuerzaDesgaste);
    }

    @Test
    void test08PicoDePiedraSeDesgastaConSuFuerzaDivididoTresMedios(){
        Pico pico = Pico.crearPicoDePiedra(); //fuerza 4, durabilidad 200
        int fuerzaDesgaste = pico.getFuerza();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), 200  - fuerzaDesgaste/1.5);
    }
    
    @Test
    void test09PicoDeMetalSeRompeALos10Usos(){
        Pico pico = Pico.crearPicoDeMetal();
        int fuerzaDesgaste = pico.getFuerza();

        for(int i = 0; i < 10; i++) {
        	pico.desgastar(fuerzaDesgaste);
        }

        assertEquals(pico.getDurabilidad(), 0);
    }

    @Test
    void test10PicoDeMetalSeRompeNoSeDeberiaRomperAntesDeLosDiezUsos(){
        Pico pico = Pico.crearPicoDeMetal();
        int fuerzaDesgaste = pico.getFuerza();

        for(int i = 0; i < 9; i++) {
        	pico.desgastar(fuerzaDesgaste);
        }

        assertEquals(pico.getDurabilidad(), 400);
    }

    @Test
    void test11PicoFinoSeInicializaConDurabilidadMil(){
        Pico pico = Pico.crearPicoFino();

        assertEquals(pico.getDurabilidad(), 1000);
    }

    @Test
    void test12PicoFinoSeInicializaConFuerza20(){
        Pico pico = Pico.crearPicoFino();

        assertEquals(pico.getFuerza(), 20);
    }

    @Test
    void test13PicoDePiedraSeDesgastaConElDiezProcientoDeSuFuerza(){
        Pico pico = Pico.crearPicoFino();
        int fuerzaDesgaste = pico.getFuerza();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), 1000 - fuerzaDesgaste / 10);
    }

    @Test
    void test14PicoFinoSeDesgastaLinealementeConElDiezProcientoDeSuFuerza(){
        Pico pico = Pico.crearPicoFino();
        double valorDesgaste = pico.getFuerza() / 10;
        int fuerzaDesgaste = pico.getFuerza();

        for(int i = 0; i < 25; i++) {
        	assertEquals(pico.getDurabilidad(), 1000 - (valorDesgaste * i));

        	pico.desgastar(fuerzaDesgaste);
        }
    }

    @Test
    void test15PicoDeMaderaSeDesgastaAlGolpearMadera(){
        Pico pico = Pico.crearPicoDeMadera();
        Madera madera = new Madera();

        pico.golpear(madera);

        assertEquals(pico.getDurabilidad(), 100 - pico.getFuerza());
    }

    @Test
    void test16PicoDePiedraSeDesgastaAlGolpearMadera(){
        Pico pico = Pico.crearPicoDePiedra();
        Madera madera = new Madera();

        pico.golpear(madera);

        assertEquals(pico.getDurabilidad(), 200 - pico.getFuerza()/1.5 );
    }

    @Test
    void test17PicoDeMetalSeDesgastaAlGolpearMadera(){
        Pico pico = Pico.crearPicoDeMetal();
        Madera madera = new Madera();

        for (int i = 0; i < 9; i++){
            pico.golpear(madera);
        }
        assertEquals(pico.getDurabilidad(), 400); //golpea 9 veces y no se modifica su durabilidad
        pico.golpear(madera);
        assertEquals(pico.getDurabilidad(), 0); //al decimo golpe se rompe
    }

}