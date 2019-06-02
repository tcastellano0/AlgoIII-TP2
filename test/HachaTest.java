import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HachaTest {
    @Test
    void test01HachaDeMaderaSeInicializaConDurabilidad100() {
        Hacha hacha = Hacha.crearHachaDeMadera();

        assertEquals(hacha.getDurabilidad(), 100);
    }

    @Test
    void test02HachaDeMaderaSeInicializaConFuerza2() {
        Hacha hacha = Hacha.crearHachaDeMadera();

        assertEquals(hacha.getFuerza(), 2);

    }

    @Test
    void test03HachaDePiedraSeInicializaConDurabilidad200() {
        Hacha hacha = Hacha.crearHachaDePiedra();

        assertEquals(hacha.getDurabilidad(), 200);
    }

    @Test
    void test03HachaDePiedraSeInicializaConFuerza5() {
        Hacha hacha = Hacha.crearHachaDePiedra();

        assertEquals(hacha.getFuerza(), 5);
    }

    @Test
    void test04HachaDeMetalSeInicializaConDurabilidad400() {
        Hacha hacha = Hacha.crearHachaDeMetal();

        assertEquals(hacha.getDurabilidad(), 400);
    }

    @Test
    void test05HachaDeMetalSeInicializaConFuerza10() {
        Hacha hacha = Hacha.crearHachaDeMetal();

        assertEquals(hacha.getFuerza(), 10);
    }

    @Test
    void test06HachaDeMaderaSeDesgastaIgualASuFuerza(){
        Hacha hacha = Hacha.crearHachaDeMadera(); //tiene fuerza 2, durabilidad 100
        int fuerzaDesgaste = hacha.getFuerza();

        hacha.desgastar(fuerzaDesgaste);
        assertEquals(hacha.getDurabilidad(), 100 - fuerzaDesgaste);
    }

    @Test
    void test07HachaDePiedraSeDesgastaIgualASuFuerza(){
        Hacha hacha = Hacha.crearHachaDePiedra(); //tiene fuerza 5, durabilidad 200
        int fuerzaDesgaste = hacha.getFuerza();

        hacha.desgastar(fuerzaDesgaste);
        assertEquals(hacha.getDurabilidad(), 200 - fuerzaDesgaste);
    }

    @Test
    void test08HachaDeMetalSeDesgastaConLaMitadDeSuFuerza(){
        Hacha hacha = Hacha.crearHachaDeMetal(); //tiene fuerza 10, durabilidad 400
        int fuerzaDesgaste = hacha.getFuerza();

        hacha.desgastar(fuerzaDesgaste);
        assertEquals(hacha.getDurabilidad(), 400 - fuerzaDesgaste/2);
    }

    @Test
    void test09HachaDeMaderaSeDesgastaAlGolpearMadera(){
        Hacha hacha = Hacha.crearHachaDeMadera(); //100, 2
        Madera madera = new Madera();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), 100 - hacha.getFuerza());
    }

    @Test
    void test10HachaDePiedraSeDesgastaAlGolpearMadera(){
        Hacha hacha = Hacha.crearHachaDePiedra(); //200, 5
        Madera madera = new Madera();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), 200 - hacha.getFuerza());
    }

    @Test
    void test11HachaDeMetalSeDesgastaAlGolpearMadera(){
        Hacha hacha = Hacha.crearHachaDeMetal(); //400,10
        Madera madera = new Madera();

        hacha.golpear(madera);

        assertEquals(hacha.getDurabilidad(), 400 - hacha.getFuerza()/2);
    }

}
