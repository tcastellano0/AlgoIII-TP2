import Juego.Mapa.*;
import org.junit.jupiter.api.Test;
import Materiales.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertSame;

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

        assertEquals(contenido, null); //esto no deberia tirar una excepcion?
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

    	assertFalse(celda.estaVacia());
    }
     
    @Test
    void test09CeldaOcupadaLuegoDeSacarQuedaVacia(){
    	Celda<Material> celda = new Celda<>();
    	celda.poner(new Madera());
    	celda.sacar();

        assertTrue(celda.estaVacia());
    }
    
    @Test
    void test10verElContenidoDeCeldaDevuelveElMismoObjeto(){
    	Celda<Material> celda = new Celda<>();
    	Madera madera = new Madera();
    	celda.poner(madera);

        assertSame(celda.ver(), madera);
    }
    
    @Test
    void test11ObetnerElContenidoDeCeldaDevuelveElMismoObjeto(){
    	Celda<Material> celda = new Celda<>();
    	Madera madera = new Madera();
    	celda.poner(madera);

        assertSame(celda.sacar(), madera);
    }


}
