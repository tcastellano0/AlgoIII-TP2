import Herramientas.Herramienta;
import Juego.Jugador.Inventario;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class InventarioTest {

    @Test
    public void test01InventarioSeInicializaConCeroItems() {
        Inventario<Herramienta> inventario = new Inventario<Herramienta>();

        assertEquals(inventario.cantidad(), 0);
    }

    @Test
    public void test02InventarioSeLeAgregaUnItemYSuCantidadAumentaEn1() {
        Inventario<Herramienta> inventario = new Inventario<Herramienta>();
        Herramienta hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);

        assertEquals(inventario.cantidad(), 1);
    }

    @Test
    public void test03InventarioSeLeAgregaUnItemCincoVecesYSuCantidadAumentaEn1CadaVez() {
        Inventario<Herramienta> inventario = new Inventario<Herramienta>();
        Herramienta hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);
        assertEquals(inventario.cantidad(), 1);
        hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);
        assertEquals(inventario.cantidad(), 2);
        hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);
        assertEquals(inventario.cantidad(), 3);
        hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);
        assertEquals(inventario.cantidad(), 4);
        hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);
        assertEquals(inventario.cantidad(), 5);
    }

    @Test
    public void test04InventarioDevuelveElMismoUltimoItem() {
        Inventario<Herramienta> inventario = new Inventario<Herramienta>();
        Herramienta hacha = Herramienta.hachaDeMadera();
        inventario.agregar(hacha);

        assertSame(inventario.ultimoItemAgregado(), hacha);
    }

}
