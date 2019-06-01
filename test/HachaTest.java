import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HachaTest {
    @Test
    public void test01HachaDeMaderaSeInicializaConDurabilidad100(){
        HachaMadera hacha = new HachaMadera();

        assertEquals(hacha.getDurabilidad(), 100);
    }
    @Test
    public void test02HachaDeMaderaSeInicializaConFuerza2(){

    }

}
