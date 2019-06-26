import Herramientas.Herramienta;
import Materiales.Madera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PicoTest {
    @Test
    public void test01PicoDeMaderaSeInicializaConDurabilidad100(){
        Herramienta pico = Herramienta.picoDeMadera();


        assertEquals(pico.getDurabilidad(), 100, 0);
    }
    
    @Test
    public void test02PicoDeMaderaSeInicializaConFuerza2(){
        Herramienta pico = Herramienta.picoDeMadera();

        assertEquals(pico.getFuerza(), 2, 0);
    }
    
    @Test
    public void test03PicoDePiedraSeInicializaConDurabilidad200(){
        Herramienta pico = Herramienta.picoDePiedra();

        assertEquals(pico.getDurabilidad(), 200, 0);
    }
    
    @Test
    public void test04PicoDePiedraSeInicializaConFuerza4(){
        Herramienta pico = Herramienta.picoDePiedra();

        assertEquals(pico.getFuerza(), 4, 0);
    }
    
    @Test
    public void test05PicoDeMetalSeInicializaConDurabilidad400(){
        Herramienta pico = Herramienta.picoDeMetal();

        assertEquals(pico.getDurabilidad(), 400, 0);
    }
    
    @Test
    public void test06PicoDeMetalSeInicializaConFuerza12(){
        Herramienta pico = Herramienta.picoDeMetal();

        assertEquals(pico.getFuerza(), 12);
    }

    @Test
    public void test07PicoDeMaderaSeDesgastaIgualASuFuerza() {
        Herramienta pico = Herramienta.picoDeMadera();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();
        
        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), durabilidad - fuerzaDesgaste, 0);
    }

    @Test
    public void test08PicoDePiedraSeDesgastaConSuFuerzaDivididoTresMedios(){
        Herramienta pico = Herramienta.picoDePiedra();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), durabilidad - fuerzaDesgaste/1.5, 2);
    }
    
    @Test
    public void test09PicoDeMetalSeRompeALos10Usos(){
        Herramienta pico = Herramienta.picoDeMetal();
        int fuerzaDesgaste = pico.getFuerza();
        
        for(int i = 0; i < 10; i++) {
        	pico.desgastar(fuerzaDesgaste);
        }

        assertEquals(pico.getDurabilidad(), 0, 0);
    }

    @Test
    public void test10PicoDeMetalSeRompeNoSeDeberiaRomperAntesDeLosDiezUsos(){
        Herramienta pico = Herramienta.picoDeMetal();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();
        
        for(int i = 0; i < 9; i++) {
        	pico.desgastar(fuerzaDesgaste);
        }

        assertEquals(pico.getDurabilidad(), durabilidad, 0);
    }

    @Test
    public void test11PicoFinoSeInicializaConDurabilidadMil(){
        Herramienta pico = Herramienta.picoFino();

        assertEquals(pico.getDurabilidad(), 1000, 0);
    }

    @Test
    public void test12PicoFinoSeInicializaConFuerza20(){
        Herramienta pico = Herramienta.picoFino();

        assertEquals(pico.getFuerza(), 20);
    }

    @Test
    public void test13PicoDePiedraSeDesgastaConElDiezProcientoDeSuFuerza(){
        Herramienta pico = Herramienta.picoFino();
        int fuerzaDesgaste = pico.getFuerza();
        double durabilidad = pico.getDurabilidad();

        pico.desgastar(fuerzaDesgaste);
        assertEquals(pico.getDurabilidad(), durabilidad - fuerzaDesgaste / 10, 0);
    }

    @Test
    public void test14PicoFinoSeDesgastaLinealementeConElDiezProcientoDeSuFuerza(){
        Herramienta pico = Herramienta.picoFino();
        int fuerzaDesgaste = pico.getFuerza();
        double valorDesgaste = fuerzaDesgaste / 10;
        double durabilidad = pico.getDurabilidad();
        

        for(int i = 0; i < 25; i++) {
        	assertEquals(pico.getDurabilidad(), durabilidad - (valorDesgaste * i), 0);

        	pico.desgastar(fuerzaDesgaste);
        }
    }

    @Test
    public void test15PicoDeMaderaSeDesgastaAlGolpearMadera(){
        Herramienta pico = Herramienta.picoDeMadera();
        Madera madera = new Madera();
        double durabilidad = pico.getDurabilidad();
        
        pico.golpear(madera);

        assertEquals(pico.getDurabilidad(), durabilidad - pico.getFuerza(), 0);
    }

    @Test
    public void test16PicoDePiedraSeDesgastaAlGolpearMadera(){
        Herramienta pico = Herramienta.picoDePiedra();
        Madera madera = new Madera();
        double durabilidad = pico.getDurabilidad();

        pico.golpear(madera);

        assertEquals(pico.getDurabilidad(), durabilidad - pico.getFuerza()/1.5, 2);
    }

    @Test
    public void test17PicoDeMetalSeDesgastaTotalmenteAlGolpearMaderaUnasDiezVeces() {
        Herramienta pico = Herramienta.picoDeMetal();
        Madera madera = new Madera();
        double durabilidad = pico.getDurabilidad();

        for (int i = 0; i < 9; i++){
            pico.golpear(madera);
        }
        assertEquals(pico.getDurabilidad(), durabilidad, 0); //golpea 9 veces y no se modifica su durabilidad
        pico.golpear(madera);
        assertEquals(pico.getDurabilidad(), 0, 0); //al decimo golpe se rompe
    }
    
    @Test
    public void test18PicoDeMaderaTieneElMismoHashCodeQueOtraPicoDeMadera(){
        Herramienta pico1 = Herramienta.picoDeMadera();
        Herramienta pico2 = Herramienta.picoDeMadera();

        assertEquals(pico1.hashCode(), pico2.hashCode());
    }
    
    @Test
    public void test19PicoDeMaderaNoTieneElMismoHashCodeQueUnPicoDePiedra(){
        Herramienta pico1 = Herramienta.picoDeMadera();
        Herramienta pico2 = Herramienta.picoDePiedra();

        assertNotEquals(pico1.hashCode(), pico2.hashCode());
    }
    
    @Test
    public void test20PicoDeMaderaNoTieneElMismoHashCodeQueUnPicoDeMetal(){
        Herramienta pico1 = Herramienta.picoDeMadera();
        Herramienta pico2 = Herramienta.picoDeMetal();

        assertNotEquals(pico1.hashCode(), pico2.hashCode());
    }
    
    @Test
    public void test21PicoDeMaderaNoTieneElMismoHashCodeQueUnPicoFino(){
        Herramienta pico1 = Herramienta.picoDeMadera();
        Herramienta pico2 = Herramienta.picoFino();

        assertNotEquals(pico1.hashCode(), pico2.hashCode());
    }

}