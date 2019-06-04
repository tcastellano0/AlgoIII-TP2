import Herramientas.Herramienta;
import Materiales.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoTest {
    @Test
    public void test01PicoDeMaderaSeInicializaConDurabilidad100(){
        Herramienta pico = Herramienta.picoDeMadera();


        assertEquals(pico.getDurabilidad(), 100);
    }
    
    @Test
    public void test02PicoDeMaderaSeInicializaConFuerza2(){
        Herramienta pico = Herramienta.picoDeMadera();

        assertEquals(pico.getFuerza(), 2);
    }
    
    @Test
    void test03PicoDePiedraSeInicializaConDurabilidad200(){
        Herramienta pico = Herramienta.picoDePiedra();

        assertEquals(pico.getDurabilidad(), 200);
    }
    
    @Test
    void test04PicoDePiedraSeInicializaConFuerza4(){
        Herramienta pico = Herramienta.picoDePiedra();

        assertEquals(pico.getFuerza(), 4);
    }
    
    @Test
    void test05PicoDeMetalSeInicializaConDurabilidad400(){
        Herramienta pico = Herramienta.picoDeMetal();

        assertEquals(pico.getDurabilidad(), 400);
    }
    
    @Test
    void test06PicoDeMetalSeInicializaConFuerza12(){
        Herramienta pico = Herramienta.picoDeMetal();

        assertEquals(pico.getFuerza(), 12);
    }

    @Test
    void test07PicoDeMaderaSeDesgastaIgualASuFuerza() {
        Herramienta pico = Herramienta.picoDeMadera();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();
        
        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), durabilidad - fuerzaDesgaste);
    }

    @Test
    void test08PicoDePiedraSeDesgastaConSuFuerzaDivididoTresMedios(){
        Herramienta pico = Herramienta.picoDePiedra();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), durabilidad - fuerzaDesgaste/1.5);
    }
    
    @Test
    void test09PicoDeMetalSeRompeALos10Usos(){
        Herramienta pico = Herramienta.picoDeMetal();
        int fuerzaDesgaste = pico.getFuerza();
        
        for(int i = 0; i < 10; i++) {
        	pico.desgastar(fuerzaDesgaste);
        }

        assertEquals(pico.getDurabilidad(), 0);
    }

    @Test
    void test10PicoDeMetalSeRompeNoSeDeberiaRomperAntesDeLosDiezUsos(){
        Herramienta pico = Herramienta.picoDeMetal();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();
        
        for(int i = 0; i < 9; i++) {
        	pico.desgastar(fuerzaDesgaste);
        }

        assertEquals(pico.getDurabilidad(), durabilidad);
    }

    @Test
    void test11PicoFinoSeInicializaConDurabilidadMil(){
        Herramienta pico = Herramienta.picoFino();

        assertEquals(pico.getDurabilidad(), 1000);
    }

    @Test
    void test12PicoFinoSeInicializaConFuerza20(){
        Herramienta pico = Herramienta.picoFino();

        assertEquals(pico.getFuerza(), 20);
    }

    @Test
    void test13PicoDePiedraSeDesgastaConElDiezProcientoDeSuFuerza(){
        Herramienta pico = Herramienta.picoFino();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), durabilidad - fuerzaDesgaste / 10);
    }

    @Test
    void test14PicoFinoSeDesgastaLinealementeConElDiezProcientoDeSuFuerza(){
        Herramienta pico = Herramienta.picoFino();
        int fuerzaDesgaste = pico.getFuerza();
        double valorDesgaste = fuerzaDesgaste / 10;
        double durabilidad = pico.getDurabilidad();
        

        for(int i = 0; i < 25; i++) {
        	assertEquals(pico.getDurabilidad(), durabilidad - (valorDesgaste * i));

        	pico.desgastar(fuerzaDesgaste);
        }
    }

    @Test
    void test15PicoDeMaderaSeDesgastaAlGolpearMadera(){
        Herramienta pico = Herramienta.picoDeMadera();
        Madera madera = new Madera();
        double durabilidad = pico.getDurabilidad();
        
        pico.golpear(madera);

        assertEquals(pico.getDurabilidad(), durabilidad - pico.getFuerza());
    }

    @Test
    void test16PicoDePiedraSeDesgastaAlGolpearMadera(){
        Herramienta pico = Herramienta.picoDePiedra();
        Madera madera = new Madera();
        double durabilidad = pico.getDurabilidad();

        pico.golpear(madera);

        assertEquals(pico.getDurabilidad(), durabilidad - pico.getFuerza()/1.5 );
    }

    @Test
    void test17PicoDeMetalSeDesgastaAlGolpearMadera() {
        Herramienta pico = Herramienta.picoDeMetal();
        Madera madera = new Madera();
        double durabilidad = pico.getDurabilidad();

        for (int i = 0; i < 9; i++){
            pico.golpear(madera);
        }
        assertEquals(pico.getDurabilidad(), durabilidad); //golpea 9 veces y no se modifica su durabilidad
        pico.golpear(madera);
        assertEquals(pico.getDurabilidad(), 0); //al decimo golpe se rompe
    }

}