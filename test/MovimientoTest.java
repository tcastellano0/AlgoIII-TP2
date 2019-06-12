import Juego.Jugador.Direccion;
import Juego.Jugador.DireccionNorte;
import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import Juego.Mapa.Mapa;
import Juego.Mapa.Posicion;
import Materiales.Madera;

import Juego.Mapa.UbicacionInvalidaException;
import Juego.Mapa.ContenedorOcupadoException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoTest {
	
    @Test
    void testLaDireccionInicialDelMovimientoEsNorte(){
    	Mapa mapa = new Mapa();
        Movimiento movimiento = new Movimiento(mapa);
        Direccion direccion = movimiento.getDireccion();
        
        assertEquals(direccion, DireccionNorte.getInstancia());
    }
    
    @Test
    void testMoverUnJugadorModificaSuPosicion(){
    	Mapa mapa = new Mapa();
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
    	Mapa mapa = new Mapa();
    	Jugador jugador = new Jugador();
    	
    	Posicion posicion = new Posicion(1,1);
        
        mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        assertEquals(jugador.getPosicion(), posicion);
    }
    
    @Test
    void testMoverUnJugadorNPasosDeberiaModificarLaPosicionDelJugadorNVeces() {
    	Mapa mapa = new Mapa();
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
    
    @Test
    void testMoverUnJugadorEnDireccionNorteConLugarOcupadoNoEsPosible() {
    	Mapa mapa = new Mapa();
    	Madera madera = new Madera();
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	Posicion posicion = new Posicion(1,1);
    	
    	mapa.poner(jugador, posicion);
    	mapa.poner(madera, posicion.arriba());
        jugador.setPosicion(posicion);
    	
        assertThrows(ContenedorOcupadoException.class, () -> {
        	movimiento.avanzar(jugador);
		});
    }
    
    @Test
    void testMoverUnJugadorEnDireccionNorteFueraDelMapaNoEsPosible() {
    	Mapa mapa = new Mapa();
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	Posicion posicion = new Posicion(1,20);
    	
    	mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        
        assertThrows(UbicacionInvalidaException.class, () -> {
        	movimiento.avanzar(jugador);
		});
    }
    
    @Test
    void testMoverUnJugadorEnDireccionSurFueraDelMapaNoEsPosible() {
    	Mapa mapa = new Mapa();
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	Posicion posicion = new Posicion(1,1);
    	
    	mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);
    	
        movimiento.invertir();
        
        assertThrows(UbicacionInvalidaException.class, () -> {
        	movimiento.avanzar(jugador);
		});
    }
    
    @Test
    void testMoverUnJugadorEnDireccionEsteFueraDelMapaNoEsPosible() {
    	Mapa mapa = new Mapa();
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	Posicion posicion = new Posicion(20, 1);
    	
    	mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);
    	
        movimiento.rotar();
        
        assertThrows(UbicacionInvalidaException.class, () -> {
        	movimiento.avanzar(jugador);
		});
    }
    
    @Test
    void testMoverUnJugadorEnDireccionOesteFueraDelMapaNoEsPosible() {
    	Mapa mapa = new Mapa();
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	Posicion posicion = new Posicion(1, 1);
    	
    	mapa.poner(jugador, posicion);
        jugador.setPosicion(posicion);
    	
        movimiento.invertir();
        movimiento.rotar();
        
        assertThrows(UbicacionInvalidaException.class, () -> {
        	movimiento.avanzar(jugador);
		});
    }
    
    @Test
    void testMoverUnJugadorEnDireccionEsteConPosicionOcupadaEnNorteEsPosible() {
    	Mapa mapa = new Mapa();
    	Madera madera = new Madera();
    	Jugador jugador = new Jugador();
    	Movimiento movimiento = new Movimiento(mapa);
    	
    	Posicion posicion = new Posicion(1,1);
    	
    	mapa.poner(jugador, posicion);
    	mapa.poner(madera, posicion.arriba());
        jugador.setPosicion(posicion);
    	
        movimiento.rotar();
        movimiento.avanzar(jugador);
        
        assertNotEquals(jugador.getPosicion(), posicion);
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
