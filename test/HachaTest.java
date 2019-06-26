import Herramientas.Herramienta;
import Materiales.Madera;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HachaTest {
    @Test
    public void test01HachaDeMaderaSeInicializaConDurabilidad100() {
        Herramienta hacha = Herramienta.hachaDeMadera();

        assertEquals(hacha.getDurabilidad(), 100, 0);
    }

    @Test
    public void test02HachaDeMaderaSeInicializaConFuerza2() {
        Herramienta hacha = Herramienta.hachaDeMadera();

        assertEquals(hacha.getFuerza(), 2);
    }

    @Test
    public void test03HachaDePiedraSeInicializaConDurabilidad200() {
        Herramienta hacha = Herramienta.hachaDePiedra();

        assertEquals(hacha.getDurabilidad(), 200, 0);
    }

    @Test
    public void test03HachaDePiedraSeInicializaConFuerza5() {
        Herramienta hacha = Herramienta.hachaDePiedra();

        assertEquals(hacha.getFuerza(), 5);
    }

    @Test
    public void test04HachaDeMetalSeInicializaConDurabilidad400() {
        Herramienta hacha = Herramienta.hachaDeMetal();

        assertEquals(hacha.getDurabilidad(), 400, 0);
    }

    @Test
    public void test05HachaDeMetalSeInicializaConFuerza10() {
        Herramienta hacha = Herramienta.hachaDeMetal();

        assertEquals(hacha.getFuerza(), 10);
    }

    @Test
    public void test06HachaDeMaderaSeDesgastaIgualASuFuerza(){
        Herramienta hacha = Herramienta.hachaDeMadera();
        int fuerzaDesgaste = hacha.getFuerza();
        double durabilidad = hacha.getDurabilidad();

        hacha.desgastar(fuerzaDesgaste);
        
        assertEquals(hacha.getDurabilidad(), durabilidad - fuerzaDesgaste, 0);
    }

    @Test
    public void test07HachaDePiedraSeDesgastaIgualASuFuerza(){
        Herramienta hacha = Herramienta.hachaDePiedra();
        int fuerzaDesgaste = hacha.getFuerza();
        double durabilidad = hacha.getDurabilidad();

        hacha.desgastar(fuerzaDesgaste);
        
        assertEquals(hacha.getDurabilidad(), durabilidad - fuerzaDesgaste, 0);
    }

    @Test
    public void test08HachaDeMetalSeDesgastaConLaMitadDeSuFuerza(){
        Herramienta hacha = Herramienta.hachaDeMetal();
        int fuerzaDesgaste = hacha.getFuerza();
        double durabilidad = hacha.getDurabilidad();

        hacha.desgastar(fuerzaDesgaste);
        
        assertEquals(hacha.getDurabilidad(), durabilidad - fuerzaDesgaste / 2, 0);
    }

    @Test
    public void test09HachaDeMaderaSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDeMadera();
        Madera madera = new Madera();
        double durabilidad = hacha.getDurabilidad();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), durabilidad - hacha.getFuerza(), 0);
    }

    @Test
    public void test10HachaDePiedraSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDePiedra();
        Madera madera = new Madera();
        double durabilidad = hacha.getDurabilidad();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), durabilidad - hacha.getFuerza(), 0);
    }

    @Test
    public void test11HachaDeMetalSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDeMetal();
        Madera madera = new Madera();
        double durabilidad = hacha.getDurabilidad();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), durabilidad - hacha.getFuerza()/2, 0);
    }
    
    @Test
    public void test12HachaDeMaderaTieneElMismoHashCodeQueOtraHachaDeMadera(){
        Herramienta hacha1 = Herramienta.hachaDeMadera();
        Herramienta hacha2 = Herramienta.hachaDeMadera();

        assertEquals(hacha1.hashCode(), hacha2.hashCode());
    }
    
    @Test
    public void test13HachaDeMaderaNoTieneElMismoHashCodeQueUnHachaDePiedra(){
    	Herramienta hacha1 = Herramienta.hachaDeMadera();
        Herramienta hacha2 = Herramienta.hachaDePiedra();

        assertNotEquals(hacha1.hashCode(), hacha2.hashCode());
    }
    
    @Test
    public void test14HachaDeMaderaNoTieneElMismoHashCodeQueUnHachaDeMetal(){
    	Herramienta hacha1 = Herramienta.hachaDeMadera();
        Herramienta hacha2 = Herramienta.hachaDeMetal();

        assertNotEquals(hacha1.hashCode(), hacha2.hashCode());
    }
    
}
