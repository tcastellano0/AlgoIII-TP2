import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HachaTest {
    @Test
    void test01HachaDeMaderaSeInicializaConDurabilidad100() {
        HachaMadera hacha = new HachaMadera();

        assertEquals(hacha.getDurabilidad(), 100);
    }

    @Test
    void test02HachaDeMaderaSeInicializaConFuerza2() {
        HachaMadera hacha = new HachaMadera();

        assertEquals(hacha.getFuerza(), 2);

    }

    @Test
    void test03HachaDePiedraSeInicializaConDurabilidad200() {
        HachaPiedra hacha = new HachaPiedra();

        assertEquals(hacha.getDurabilidad(), 200);
    }

    @Test
    void test03HachaDePiedraSeInicializaConFuerza5() {
        HachaPiedra hacha = new HachaPiedra();

        assertEquals(hacha.getFuerza(), 5);
    }

    @Test
    void test04HachaDeMetalSeInicializaConDurabilidad400() {
        HachaMetal hacha = new HachaMetal();

        assertEquals(hacha.getDurabilidad(), 400);
    }

    @Test
    void test05HachaDeMetalSeInicializaConFuerza10() {
        HachaMetal hacha = new HachaMetal();

        assertEquals(hacha.getFuerza(), 10);
    }

    @Test
    void test06HachaDeMaderaSeDesgastaIgualASuFuerza(){
        HachaMadera hacha = new HachaMadera(); //tiene fuerza 2, durabilidad 100

        hacha.desgastar();
        assertEquals(hacha.getDurabilidad(), 100 - hacha.getFuerza());
    }

    @Test
    void test07HachaDePiedraSeDesgastaIgualASuFuerza(){
        HachaPiedra hacha = new HachaPiedra(); //tiene fuerza 5, durabilidad 200

        hacha.desgastar();
        assertEquals(hacha.getDurabilidad(), 200 - hacha.getFuerza());
    }
    @Test
    void test08HachaDeMetalSeDesgastaConLaMitadDeSuFuerza(){
        HachaMetal hacha = new HachaMetal(); //tiene fuerza 10, durabilidad 400

        hacha.desgastar();
        assertEquals(hacha.getDurabilidad(), 400 - hacha.getFuerza()/2);
    }
}
