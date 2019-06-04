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
        Herramienta hacha = Herramienta.hachaDeMadera(); //tiene fuerza 2, durabilidad 100
        int fuerzaDesgaste = hacha.getFuerza();

        hacha.desgastar(fuerzaDesgaste);
        assertEquals(hacha.getDurabilidad(), 100 - fuerzaDesgaste);
    }

    @Test
    void test07HachaDePiedraSeDesgastaIgualASuFuerza(){
        Herramienta hacha = Herramienta.hachaDePiedra(); //tiene fuerza 5, durabilidad 200
        int fuerzaDesgaste = hacha.getFuerza();

        hacha.desgastar(fuerzaDesgaste);
        assertEquals(hacha.getDurabilidad(), 200 - fuerzaDesgaste);
    }

    @Test
    void test08HachaDeMetalSeDesgastaConLaMitadDeSuFuerza(){
        Herramienta hacha = Herramienta.hachaDeMetal(); //tiene fuerza 10, durabilidad 400
        int fuerzaDesgaste = hacha.getFuerza();

        hacha.desgastar(fuerzaDesgaste);
        assertEquals(hacha.getDurabilidad(), 400 - fuerzaDesgaste/2);
    }

    @Test
    void test09HachaDeMaderaSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDeMadera(); //100, 2
        Madera madera = new Madera();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), 100 - hacha.getFuerza());
    }

    @Test
    void test10HachaDePiedraSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDePiedra(); //200, 5
        Madera madera = new Madera();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), 200 - hacha.getFuerza());
    }

    @Test
    void test11HachaDeMetalSeDesgastaAlGolpearMadera(){
        Herramienta hacha = Herramienta.hachaDeMetal(); //400,10
        Madera madera = new Madera();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), 400 - hacha.getFuerza()/2);
    }

}
