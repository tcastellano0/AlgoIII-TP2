import Herramientas.Herramienta;
import Materiales.Madera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HachaTest {
    @Test
    void test01HachaDeMaderaSeInicializaConDurabilidad100() {
        Herramienta hacha = Herramienta.hachaDeMadera();

        assertEquals(hacha.getDurabilidad(), 100);
    }

    @Test
    void test02HachaDeMaderaSeInicializaConFuerza2() {
        Herramienta hacha = Herramienta.hachaDeMadera();

        assertEquals(hacha.getFuerza(), 2);
    }

    @Test
    void test03HachaDePiedraSeInicializaConDurabilidad200() {
        Herramienta hacha = Herramienta.hachaDePiedra();

        assertEquals(hacha.getDurabilidad(), 200);
    }

    @Test
    void test03HachaDePiedraSeInicializaConFuerza5() {
        Herramienta hacha = Herramienta.hachaDePiedra();

        assertEquals(hacha.getFuerza(), 5);
    }

    @Test
    void test04HachaDeMetalSeInicializaConDurabilidad400() {
        Herramienta hacha = Herramienta.hachaDeMetal();

        assertEquals(hacha.getDurabilidad(), 400);
    }

    @Test
    void test05HachaDeMetalSeInicializaConFuerza10() {
        Herramienta hacha = Herramienta.hachaDeMetal();

        assertEquals(hacha.getFuerza(), 10);
    }

    @Test
    void test06HachaDeMaderaSeDesgastaIgualASuFuerza(){
        Herramienta hacha = Herramienta.hachaDeMadera();
        int fuerzaDesgaste = hacha.getFuerza();
        double durabilidad = hacha.getDurabilidad();

        hacha.desgastar(fuerzaDesgaste);
        
        assertEquals(hacha.getDurabilidad(), durabilidad - fuerzaDesgaste);
    }

    @Test
    void test07HachaDePiedraSeDesgastaIgualASuFuerza(){
        Herramienta hacha = Herramienta.hachaDePiedra();
        int fuerzaDesgaste = hacha.getFuerza();
        double durabilidad = hacha.getDurabilidad();

        hacha.desgastar(fuerzaDesgaste);
        
        assertEquals(hacha.getDurabilidad(), durabilidad - fuerzaDesgaste);
    }

    @Test
    void test08HachaDeMetalSeDesgastaConLaMitadDeSuFuerza(){
        Herramienta hacha = Herramienta.hachaDeMetal();
        int fuerzaDesgaste = hacha.getFuerza();
        double durabilidad = hacha.getDurabilidad();

        hacha.desgastar(fuerzaDesgaste);
        
        assertEquals(hacha.getDurabilidad(), durabilidad - fuerzaDesgaste / 2);
    }

    @Test
    void test09HachaDeMaderaSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDeMadera();
        Madera madera = new Madera();
        double durabilidad = hacha.getDurabilidad();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), durabilidad - hacha.getFuerza());
    }

    @Test
    void test10HachaDePiedraSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDePiedra();
        Madera madera = new Madera();
        double durabilidad = hacha.getDurabilidad();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), durabilidad - hacha.getFuerza());
    }

    @Test
    void test11HachaDeMetalSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDeMetal();
        Madera madera = new Madera();
        double durabilidad = hacha.getDurabilidad();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), durabilidad - hacha.getFuerza()/2);
    }
}
