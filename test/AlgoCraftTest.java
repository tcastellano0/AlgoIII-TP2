import Juego.AlgoCraft;
import Juego.Mapa.Posicion;
import Juego.Jugador.Jugador;
import Materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class AlgoCraftTest {

    @Test
    public void testAlgoCraftVerPosicionInicialDeJugadorCasteaAJugadorYNoLanzaError(){
        AlgoCraft juego = AlgoCraft.getInstancia();

        juego.verEnPosicion(new Posicion(1, 1));
    }

    @Test(expected = ClassCastException.class)
    public void testAlgoCraftVerPosicion1Y6CasteaAJugadorYLanzaError(){
        AlgoCraft juego = AlgoCraft.getInstancia();
        
        Jugador unJugador = (Jugador)juego.verEnPosicion(new Posicion(1,6));
    }

    @Test
    public void testAlgoCraftPosicionJugadorDevuelvePosicion1Y1(){
        AlgoCraft juego = AlgoCraft.getInstancia();
        Posicion posJugador = juego.posicionDelJugador();
        Posicion posEsperada = new Posicion(1,1);

        assertEquals(posJugador, posEsperada);
    }

    @Test
    public void testAlgoCraftPosicionJugadorNoDevuelvePosicion1Y2(){
        AlgoCraft juego = AlgoCraft.getInstancia();
        Posicion posJugador = juego.posicionDelJugador();
        Posicion posNoEsperada = new Posicion(1,2);

        assertNotEquals(posJugador, posNoEsperada);
    }

    @Test
    public void testAlgoCraftVerEnPosicion1Y6DevuelveUnaMadera() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(1, 6));
        Madera unaMadera = new Madera();

        assertTrue(unaMadera.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion8Y15DevuelveUnaMadera() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(8, 15));
        Madera unaMadera = new Madera();

        assertTrue(unaMadera.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion20Y20DevuelveUnaMadera() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(20, 20));
        Madera unaMadera = new Madera();

        assertTrue(unaMadera.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion4Y6DevuelveUnaPiedra() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(4, 6));
        Piedra unaPiedra = new Piedra();

        assertTrue(unaPiedra.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion15Y2DevuelveUnaPiedra() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(15, 2));
        Piedra unaPiedra = new Piedra();

        assertTrue(unaPiedra.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion19Y14DevuelveUnaPiedra() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(19, 14));
        Piedra unaPiedra = new Piedra();

        assertTrue(unaPiedra.esIgual(ubicable));
    }


    @Test
    public void testAlgoCraftVerEnPosicion7Y7DevuelveUnMetal() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(7, 7));
        Metal unMetal = new Metal();

        assertTrue(unMetal.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion11Y13DevuelveUnMetal() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(11, 13));
        Metal unMetal = new Metal();

        assertTrue(unMetal.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion13Y13DevuelveUnMetal() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(13, 13));
        Metal unMetal = new Metal();

        assertTrue(unMetal.esIgual(ubicable));
    }

    @Test
    public void testAlgoCraftVerEnPosicion10Y10DevuelveUnDiamante() {
        AlgoCraft juego = AlgoCraft.getInstancia();
        Material ubicable = (Material) juego.verEnPosicion(new Posicion(10, 10));
        Diamante unDiamante = new Diamante();

        assertTrue(unDiamante.esIgual(ubicable));
    }

}
