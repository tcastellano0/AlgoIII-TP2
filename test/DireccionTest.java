import Juego.Jugador.*;
import Juego.Mapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {
    @Test
    void test01LaPosicionSiguienteEnDireccionEsteTieneCoordenadaXMayor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionEste = DireccionEste.getInstancia();

        assertTrue(direccionEste.siguiente(posicion).getCoordenadaX()>posicion.getCoordenadaX());
    }

    @Test
    void test02LaPosicionSiguienteEnDireccionOesteTieneCoordenadaXMenor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionOeste = DireccionOeste.getInstancia();

        assertTrue(direccionOeste.siguiente(posicion).getCoordenadaX()< posicion.getCoordenadaX());
    }

    @Test
    void test03LaPosicionSiguienteEnDireccionNorteTieneCoordenadaYMayor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionNorte = DireccionNorte.getInstancia();

        assertTrue(direccionNorte.siguiente(posicion).getCoordenadaY()> posicion.getCoordenadaY());
    }

    @Test
    void test04LaPosicionSiguienteEnDireccionSurTieneCoordenadaYMenor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionSur =  DireccionSur.getInstancia();

        assertTrue(direccionSur.siguiente(posicion).getCoordenadaY()< posicion.getCoordenadaY());
    }
}
