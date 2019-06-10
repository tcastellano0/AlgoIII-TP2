import Juego.Mapa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CeldaTest {
    @Test
    void test01SePuedeObtenerElContenidoDeUnaCeldaOcupada(){
        Celda<String> celda = new Celda<>("hola");
        String contenido = celda.sacar();

        assertEquals(contenido, "hola");
    }

    @Test
    void test02setContenidoEnUnaCeldaOcupadaLanzaError() {
        Celda<Integer> celda = new Celda<Integer>(5);

        assertThrows(ContenedorOcupadoException.class, () -> {
            celda.poner(5);
        });
    }

    @Test
    void test03SePuedePonerContenidoEnUnaCeldaVacia(){
        Celda<String> celda = new Celda<>();
        celda.poner("hola");

        String contenido = celda.sacar();

        assertEquals(contenido, "hola");
    }
    @Test
    void test04getContenidoDeUnaCeldaVaciaLanzaError(){
        Celda<String> celda = new Celda<>();
        assertThrows(ContenedorVacioException.class, () -> {
            celda.sacar();
        });
    }

}
