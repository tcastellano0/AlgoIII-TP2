import Juego.Jugador.Direccion;
import Juego.Jugador.DireccionNorte;
import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Materiales.Madera;

import Juego.Mapa.ContenedorOcupadoException;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoTest {

    @Test
    void testLaDireccionInicialDelMovimientoEsNorte(){
        Tablero tablero = new Tablero();
        Movimiento movimiento = new Movimiento(tablero);
        Direccion direccion = movimiento.getDireccion();

        assertEquals(direccion, DireccionNorte.getInstancia());
    }

    @Test
    void testMoverUnJugadorModificaSuPosicion(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);
        movimiento.avanzar(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }

    @Test
    void testNoMoverUnJugadorNoDeberiaModificarSuPosicion() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        assertEquals(jugador.getPosicion(), posicion);
    }

    @Test
    void testMoverUnJugadorNPasosDeberiaModificarLaPosicionDelJugadorNVeces() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        int numeroPasos = 15;

        Posicion posicion = new Posicion(1,1);
        Posicion posicionProxima = new Posicion(1, 1 + numeroPasos);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        for(int i = 1; i <= numeroPasos; i++) {
            movimiento.avanzar(jugador);
        }

        assertEquals(jugador.getPosicion(), posicionProxima);
    }

    @Test
    void testMoverUnJugadorEnDireccionNorteConLugarOcupadoNoEsPosible() {
        Tablero tablero = new Tablero();
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.arriba());
        jugador.setPosicion(posicion);

        assertThrows(ContenedorOcupadoException.class, () -> {
            movimiento.avanzar(jugador);
        });
    }

    @Test
    void testIntentarMoverUnJugadorEnDireccionNorteSuperandoLaDimensionDelTableroNoLoMueve() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,20);

        jugador.setPosicion(posicion);
        tablero.poner(jugador, posicion);

        movimiento.avanzar(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    void testMoverUnJugadorEnDireccionSurFueraDelTableroNoEsPosible() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.invertir();

        movimiento.avanzar(jugador);

        assertEquals(posicion, jugador.getPosicion());
    }

    @Test
    void testMoverUnJugadorEnDireccionEsteFueraDelTableroNoEsPosible() {
        Tablero tablero = new Tablero();
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
    void testMoverUnJugadorEnDireccionOesteFueraDelTableroNoEsPosible() {
        Tablero tablero = new Tablero();
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
    void testMoverUnJugadorEnDireccionEsteConPosicionOcupadaEnNorteEsPosible() {
        Tablero tablero = new Tablero();
        Madera madera = new Madera();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1,1);

        tablero.poner(jugador, posicion);
        tablero.poner(madera, posicion.arriba());
        jugador.setPosicion(posicion);

        movimiento.rotar();
        movimiento.avanzar(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }

    @Test
    void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionNortePasaAMoverseEnDireccionSur() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 20);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.avanzar(jugador); //choca contra el techo
        movimiento.avanzar(jugador);

        assertEquals(posicion.abajo(), jugador.getPosicion());
    }
    @Test
    void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionSurPasaAMoverseEnDireccionNorte() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento(tablero);

        Posicion posicion = new Posicion(1, 1);

        tablero.poner(jugador, posicion);
        jugador.setPosicion(posicion);

        movimiento.invertir();
        movimiento.avanzar(jugador); //choca contra el piso
        movimiento.avanzar(jugador);

        assertEquals(posicion.arriba(), jugador.getPosicion());
    }
    @Test
    void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionEstePasaAMoverseEnDireccionOeste() {
        Tablero tablero = new Tablero();
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
    void testLuegoIntentarMoverUnJugadorFueraDelTableroEnDireccionOestePasaAMoverseEnDireccionEste() {
        Tablero tablero = new Tablero();
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
