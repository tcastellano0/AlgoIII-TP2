import Juego.Mapa.*;
import Materiales.*;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class CeldaTest {
	
    @Test
    public void test01SePuedeObtenerElContenidoDeUnaCeldaOcupada(){
        Celda<String> celda = new Celda<>("hola");
        String contenido = celda.sacar();

        assertEquals(contenido, "hola");
    }

    @Test(expected = ContenedorOcupadoException.class)
    public void test02setContenidoEnUnaCeldaOcupadaLanzaError() {
        Celda<Integer> celda = new Celda<Integer>(5);
        celda.poner(5);
    }

    @Test
    public void test03SePuedePonerContenidoEnUnaCeldaVacia(){
        Celda<String> celda = new Celda<>();
        celda.poner("hola");

        String contenido = celda.sacar();

        assertEquals(contenido, "hola");
    }

    @Test(expected = ContenedorVacioException.class)
    public void test04getContenidoDeUnaCeldaVaciaLanzaError(){
        Celda<String> celda = new Celda<>();
        celda.sacar();
    }

    @Test(expected = ContenedorOcupadoException.class)
    public void test05ocuparCeldaOcupadaLanzaContenedorOcupadoException(){
        Celda<Material> celda = new Celda<>();
        celda.poner(new Madera());
        celda.poner(new Madera());
    }
    
    @Test
    public void test06sePuedeVerElContenidoDeCeldaOcupada(){
    	Celda<String> celda = new Celda<>();
        celda.poner("hola");

        String contenido = celda.ver();

        assertEquals(contenido, "hola");
    }
    
    @Test
    public void test06verElContenidoDeCeldaVaciaEsNull(){
    	Celda<String> celda = new Celda<>();

        String contenido = celda.ver();

        assertEquals(contenido, null); //esto no deberia tirar una excepcion?
    }
    
    @Test
    public void test07CeldaSeInstanciaVacia(){
    	Celda<String> celda = new Celda<>();

    	assertTrue(celda.estaVacia());
    }
    
    @Test
    public void test08CeldaSeInstanciaVaciaAlPonerAlgoYaNoEstaVacia(){
    	Celda<String> celda = new Celda<>();
    	celda.poner("hola");

    	assertFalse(celda.estaVacia());
    }
     
    @Test
    public void test09CeldaOcupadaLuegoDeSacarQuedaVacia(){
    	Celda<Material> celda = new Celda<>();
    	celda.poner(new Madera());
    	celda.sacar();

        assertTrue(celda.estaVacia());
    }
    
    @Test
    public void test10verElContenidoDeCeldaDevuelveElMismoObjeto(){
    	Celda<Material> celda = new Celda<>();
    	Madera madera = new Madera();
    	celda.poner(madera);

        assertSame(celda.ver(), madera);
    }
    
    @Test
    public void test11ObetnerElContenidoDeCeldaDevuelveElMismoObjeto(){
    	Celda<Material> celda = new Celda<>();
    	Madera madera = new Madera();
    	celda.poner(madera);

        assertSame(celda.sacar(), madera);
    }


}
