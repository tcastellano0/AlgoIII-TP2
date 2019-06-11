import Juego.Mapa.*;
import org.junit.jupiter.api.Test;
import Materiales.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    void test05ocuparCeldaOcupadaLanzaContenedorOcupadoException(){
        Celda<Material> celda = new Celda<>();
        celda.poner(new Madera());
        assertThrows(ContenedorOcupadoException.class, () -> {
            celda.poner(new Madera());
        });
    }
    
    @Test
    void test06sePuedeVerElContenidoDeCeldaOcupada(){
    	Celda<String> celda = new Celda<>();
        celda.poner("hola");

        String contenido = celda.ver();

        assertEquals(contenido, "hola");
    }
    
    @Test
    void test06verElContenidoDeCeldaVaciaEsNull(){
    	Celda<String> celda = new Celda<>();

        String contenido = celda.ver();

        assertEquals(contenido, null);
    }
    
    @Test
    void test07CeldaSeInstanciaVacia(){
    	Celda<String> celda = new Celda<>();

    	assertTrue(celda.estaVacia());
    }
    
    @Test
    void test08CeldaSeInstanciaVaciaAlPonerAlgoYaNoEstaVacia(){
    	Celda<String> celda = new Celda<>();
    	celda.poner("hola");

    	assertTrue(!celda.estaVacia());
    }
     
    @Test
    void test09CeldaOcupadaLuegoDeSacarQuedaVacia(){
    	Celda<Material> celda = new Celda<>();
    	celda.poner(new Madera());
    	celda.sacar();

        assertTrue(celda.estaVacia());
    }


}
