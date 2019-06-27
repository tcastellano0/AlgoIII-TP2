import Juego.Jugador.*;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Juego.Mapa.Ubicable;
import Materiales.Madera;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovimientoTest {

    @Test
    public void testLaDireccionInicialDelMovimientoEsNorte(){
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Movimiento movimiento = new Movimiento(tablero);
        Direccion direccion = movimiento.getDireccion();

        assertEquals(direccion, DireccionNorte.getInstancia());
    }


    @Test
    public void testMoverArribaUnJugadorModificaSuPosicion(){
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        movimiento.moverArriba(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }

    @Test
    public void testNoMoverUnJugadorNoModificaSuPosicion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        assertEquals(jugador.getPosicion(), posicion);
    }

    @Test
    public void testMoverUnJugadorNPasosModificaLaPosicionDelJugadorNVeces() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        int numeroPasos = 5;

        Posicion posicionInicial = new Posicion(2, numeroPasos);
        Posicion posicionFinal = new Posicion(2, 1);

        tablero.poner(jugador, posicionInicial);
        jugador.setPosicion(posicionInicial);

        for(int i = 1; i <= numeroPasos; i++) {
            movimiento.moverArriba(jugador);
        }

        assertEquals(jugador.getPosicion(), posicionFinal);
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionNorteConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.moverArriba(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionNorteConLugarOcupadoYSeMantieneSuDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.moverArriba(jugador);

        assertEquals(movimiento.getDireccion(), DireccionNorte.getInstancia());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionSurConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.moverAbajo(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionSurConLugarOcupadoMantieneLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.moverAbajo(jugador);

        assertEquals(movimiento.getDireccion(), DireccionSur.getInstancia());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionEsteConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,2);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.derecha());
        jugador.setPosicion(posicion);
        movimiento.moverDerecha(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionEsteConLugarOcupadoMantieneLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,2);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.derecha());
        jugador.setPosicion(posicion);
        movimiento.moverDerecha(jugador);

        assertEquals(movimiento.getDireccion(), DireccionEste.getInstancia());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionOesteConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.izquierda());
        jugador.setPosicion(posicion);
        movimiento.moverIzquierda(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionOesteConLugarOcupadoMantieneLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.izquierda());
        jugador.setPosicion(posicion);
        movimiento.moverIzquierda(jugador);

        assertEquals(movimiento.getDireccion(), DireccionOeste.getInstancia());
    }


    @Test
    public void testIntentarMoverUnJugadorEnDireccionNorteSuperandoLaDimensionDelTableroNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        jugador.setPosicion(posicion);
        tablero.poner(jugador, posicion);

        movimiento.moverArriba(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testMoverUnJugadorEnDireccionSurSuperandoLaDimensionDelTableroNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(20,20);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        movimiento.moverAbajo(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testMoverUnJugadorEnDireccionEsteSuperandoLaDimensionDelTableroNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(20, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.moverDerecha(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testMoverUnJugadorEnDireccionOesteSuperandoLaDimensionDelTableroNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.moverIzquierda(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testMoverUnJugadorEnDireccionEsteConPosicionOcupadaEnNorteEsPosible() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);

        movimiento.moverDerecha(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }

    @Test
    public void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionNorteMantieneSuPosicion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.moverArriba(jugador);
        movimiento.moverArriba(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }


}
