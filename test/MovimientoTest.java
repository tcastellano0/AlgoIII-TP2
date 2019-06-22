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
    public void testMoverUnJugadorModificaSuPosicion(){
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);
        movimiento.invertir();

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

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

        int numeroPasos = 15;

        Posicion posicionInicial = new Posicion(1, numeroPasos);
        Posicion posicionFinal = new Posicion(1, 1);

        tablero.poner(jugador, posicionInicial);
        jugador.setPosicion(posicionInicial);

        for(int i = 1; i <= numeroPasos; i++) {
            movimiento.avanzar(jugador);
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
        movimiento.avanzar(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionNorteConLugarOcupadoInvierteLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(movimiento.getDireccion(), DireccionNorte.getInstancia().invertir());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionSurConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,2);
        movimiento.invertir();

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionSurConLugarOcupadoInvierteLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,2);
        movimiento.invertir();

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.abajo());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(movimiento.getDireccion(), DireccionSur.getInstancia().invertir());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionEsteConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,2);
        movimiento.rotar();

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.derecha());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionEsteConLugarOcupadoInvierteLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,2);
        movimiento.rotar();

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.derecha());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(movimiento.getDireccion(), DireccionEste.getInstancia().invertir());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionOesteConLugarOcupadoNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);
        movimiento.invertir();
        movimiento.rotar();

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.izquierda());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    public void testIntentarMoverUnJugadorEnDireccionOesteConLugarOcupadoInvierteLaDireccion() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(2,2);
        movimiento.invertir();
        movimiento.rotar();

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.izquierda());
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertEquals(movimiento.getDireccion(), DireccionOeste.getInstancia().invertir());
    }


    @Test
    public void testIntentarMoverUnJugadorEnDireccionNorteSuperandoLaDimensionDelTableroNoLoMueve() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        jugador.setPosicion(posicion);
        tablero.poner(jugador, posicion);

        movimiento.avanzar(jugador);

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

        movimiento.invertir();

        movimiento.avanzar(jugador);

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

        movimiento.rotar();
        movimiento.avanzar(jugador);

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

        movimiento.invertir();
        movimiento.rotar();
        movimiento.avanzar(jugador);

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

        movimiento.rotar();
        movimiento.avanzar(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }

    @Test
    public void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionNortePasaAMoverseEnDireccionSur() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.avanzar(jugador); //choca contra el techo
        movimiento.avanzar(jugador);

        assertEquals(posicion.abajo(), jugador.getPosicion());
    }
    
    @Test
    public void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionSurPasaAMoverseEnDireccionNorte() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 20);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.invertir();
        movimiento.avanzar(jugador); //choca contra el piso
        movimiento.avanzar(jugador);

        assertEquals(posicion.arriba(), jugador.getPosicion());
    }
    @Test
    public void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionEstePasaAMoverseEnDireccionOeste() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(20, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.rotar();
        movimiento.avanzar(jugador); //choca contra la pared este
        movimiento.avanzar(jugador);

        assertEquals(posicion.izquierda(), jugador.getPosicion());
    }
    @Test
    public void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionOestePasaAMoverseEnDireccionEste() {
    	Tablero<Ubicable> tablero = new Tablero<Ubicable>(20,20);
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.invertir();
        movimiento.rotar();
        movimiento.avanzar(jugador); //choca contra la pared oeste
        movimiento.avanzar(jugador);

        assertEquals(posicion.derecha(), jugador.getPosicion());
    }

}
