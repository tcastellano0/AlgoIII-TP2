import Herramientas.Herramienta;
import Herramientas.TableroConstruccion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableroConstruccionTest {

    @Test
    void test01SeCreaConMaquetaVacia() {
        TableroConstruccion tableroConstruccion = new TableroConstruccion();

        assertEquals(tableroConstruccion.maqueta(), "VVVVVVVVV");
    }

    @Test
    void test02MaquetaParaHachaDeMadera() {
        TableroConstruccion tableroConstruccion = new TableroConstruccion();
        tableroConstruccion.ponerMadera(1, 1);
        tableroConstruccion.ponerMadera(1, 2);
        tableroConstruccion.ponerMadera(2, 1);
        tableroConstruccion.ponerMadera(2, 2);
        tableroConstruccion.ponerMadera(3, 2);
        assertEquals(tableroConstruccion.maqueta(), "MMVMMVVMV");
    }

    @Test
    void test0quieroversimedevuelveunhachademadera() {
        TableroConstruccion tableroConstruccion = new TableroConstruccion();
        Herramienta hacha;
        tableroConstruccion.ponerMadera(1, 1);
        tableroConstruccion.ponerMadera(1, 2);
        tableroConstruccion.ponerMadera(2, 1);
        tableroConstruccion.ponerMadera(2, 2);
        tableroConstruccion.ponerMadera(3, 2);
        hacha = tableroConstruccion.construir();

        Assertions.assertEquals(hacha.getDurabilidad(), 100);
        assertEquals(hacha.getFuerza(), 2);
    }
}
