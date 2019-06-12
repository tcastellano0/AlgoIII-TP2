import Juego.Jugador.Direccion;
import Juego.Jugador.DireccionNorte;
import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import Juego.Mapa.Mapa;
import Juego.Mapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovimientoTest {
	
    @Test
    void testLaDireccionInicialDelMovimientoEsNorte(){
    	Mapa mapa = new Mapa(20, 20);
        Movimiento movimiento = new Movimiento(mapa);
        Direccion direccion = movimiento.getDireccion();
        
        assertEquals(direccion, DireccionNorte.getInstancia());
    }

    @Test
    void testMoverUnJugadorModificaSuPosicion(){
    	Mapa mapa = new Mapa(20, 20);
    	Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(mapa);
        
        Posicion posicion = new Posicion(1,1);
        
        mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }
    
    @Test
    void testNoMoverUnJugadorNoDeberiaModificarSuPosicion() {
    	Mapa mapa = new Mapa(20, 20);
    	Jugador jugador = new Jugador();
    	
    	Posicion posicion = new Posicion(1,1);
        
        mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        assertEquals(jugador.getPosicion(), posicion);
    }
    
    @Test
    void testMoverUnJugadorNPasosDeberiaModificarLaPosicionDelJugadorNVeces() {
    	Mapa mapa = new Mapa(20, 20);
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	int numeroPasos = 15;
    	
    	Posicion posicion = new Posicion(1,1);
    	Posicion posicionProxima = new Posicion(1, 1 + numeroPasos);
        
        mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        
        for(int i = 1; i <= numeroPasos; i++) {
        	movimiento.avanzar(jugador);
        }
        
        assertEquals(jugador.getPosicion(), posicionProxima);
    }

/*    @Test
    void test03sarasa(){
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento();
        Posicion posicion = new Posicion(1,1);
        jugador.setPosicion(posicion);
        for(int i=0; i<15; i++) {
            movimiento.avanzar(jugador);
            System.out.println(jugador.getPosicion().getCoordenadaY());
        }
    }*/

}
