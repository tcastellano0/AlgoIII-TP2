import Juego.AlgoCraft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import Juego.Jugador.Jugador;
import Juego.Mapa.Posicion;
import Materiales.*;

public class AlgoCraftTest {

    @Test
    void testAlgoCraftVerPosicionInicialDeJugadorCasteaAJugadorYNoLanzaError(){
        AlgoCraft juego = new AlgoCraft();

        Jugador j = (Jugador) juego.verEnPosicion(new Posicion(1, 1));
    }

    @Test
    void testAlgoCraftVerPosicion1Y6CasteaAJugadorYLanzaError(){
        AlgoCraft juego = new AlgoCraft();

        assertThrows(ClassCastException.class, () -> {
            Jugador j = (Jugador) juego.verEnPosicion(new Posicion(1,6));
        });

    }

    @Test
    void testAlgoCraftPosicionJugadorDevuelvePosicion1Y1(){
        AlgoCraft juego = new AlgoCraft();
        Posicion posJugador = juego.posicionDelJugador();
        Posicion posEsperada = new Posicion(1,1);

        assertEquals(posJugador, posEsperada);
    }

    @Test
    void testAlgoCraftPosicionJugadorNoDevuelvePosicion1Y2(){
        AlgoCraft juego = new AlgoCraft();
        Posicion posJugador = juego.posicionDelJugador();
        Posicion posNoEsperada = new Posicion(1,2);

        assertNotEquals(posJugador, posNoEsperada);
    }

    @Test
    void testAlgoCraftVerEnPosicion1Y6DevuelveUnaMadera() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(1, 6));
        Madera unaMadera = new Madera();

        assertTrue(unaMadera.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion8Y15DevuelveUnaMadera() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(8, 15));
        Madera unaMadera = new Madera();

        assertTrue(unaMadera.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion20Y20DevuelveUnaMadera() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(20, 20));
        Madera unaMadera = new Madera();

        assertTrue(unaMadera.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion4Y6DevuelveUnaPiedra() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(4, 6));
        Piedra unaPiedra = new Piedra();

        assertTrue(unaPiedra.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion15Y2DevuelveUnaPiedra() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(15, 2));
        Piedra unaPiedra = new Piedra();

        assertTrue(unaPiedra.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion19Y14DevuelveUnaPiedra() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(19, 14));
        Piedra unaPiedra = new Piedra();

        assertTrue(unaPiedra.esIgual(ubicable));
    }


    @Test
    void testAlgoCraftVerEnPosicion7Y7DevuelveUnMetal() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(7, 7));
        Metal unMetal = new Metal();

        assertTrue(unMetal.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion11Y13DevuelveUnMetal() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(11, 13));
        Metal unMetal = new Metal();

        assertTrue(unMetal.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion13Y13DevuelveUnMetal() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(13, 13));
        Metal unMetal = new Metal();

        assertTrue(unMetal.esIgual(ubicable));
    }

    @Test
    void testAlgoCraftVerEnPosicion10Y10DevuelveUnDiamante() {
        AlgoCraft juego = new AlgoCraft();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(10, 10));
        Diamante unDiamante = new Diamante();

        assertTrue(unDiamante.esIgual(ubicable));
    }

}
