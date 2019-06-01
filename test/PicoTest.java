import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoTest {
    @Test
    public void test01PicoDeMaderaSeInicializaConDurabilidad100(){
        PicoMadera pico = new PicoMadera();

        assertEquals(pico.getDurabilidad(), 100);
    }
    @Test
    public void test02PicoDeMaderaSeInicializaConFuerza2(){
        PicoMadera pico = new PicoMadera();

        assertEquals(pico.getFuerza(), 2);

    }

}