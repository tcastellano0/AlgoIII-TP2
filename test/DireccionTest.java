import Juego.Jugador.*;
import Juego.Mapa.Posicion;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DireccionTest {
    @Test
    public void test01LaPosicionSiguienteEnDireccionEsteTieneCoordenadaXMayor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionEste = DireccionEste.getInstancia();

        assertTrue(direccionEste.siguiente(posicion).getCoordenadaX()>posicion.getCoordenadaX());
    }

    @Test
    public void test02LaPosicionSiguienteEnDireccionOesteTieneCoordenadaXMenor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionOeste = DireccionOeste.getInstancia();

        assertTrue(direccionOeste.siguiente(posicion).getCoordenadaX()< posicion.getCoordenadaX());
    }

    @Test
    public void test03LaPosicionSiguienteEnDireccionNorteTieneCoordenadaYMenor(){
        Posicion posicion = new Posicion(2,2);
        Direccion direccionNorte = DireccionNorte.getInstancia();

        assertTrue(direccionNorte.siguiente(posicion).getCoordenadaY() < posicion.getCoordenadaY());
    }

    @Test
    public void test04LaPosicionSiguienteEnDireccionSurTieneCoordenadaYMayor(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccionSur =  DireccionSur.getInstancia();

        assertTrue(direccionSur.siguiente(posicion).getCoordenadaY() > posicion.getCoordenadaY());
    }

    @Test
    public void test05DireccionNorteRotaYEsDireccionEste(){
        Posicion posicion = new Posicion(0, 0);
        Direccion direccion = DireccionNorte.getInstancia();
        direccion = direccion.rotar();

        assertTrue(direccion.siguiente(posicion).getCoordenadaX()>posicion.getCoordenadaX());
    }

    @Test
    public void test06DireccionEsteRotaYEsDireccionSur(){
        Posicion posicion = new Posicion(2, 2);
        Direccion direccion = DireccionEste.getInstancia();
        direccion = direccion.rotar();

        assertTrue(direccion.siguiente(posicion).getCoordenadaY() > posicion.getCoordenadaY());

    }

    @Test
    public void test07DireccionSurRotaYEsDireccionOeste(){
        Posicion posicion = new Posicion(0, 0);
        Direccion direccion = DireccionSur.getInstancia();
        direccion = direccion.rotar();

        assertTrue(direccion.siguiente(posicion).getCoordenadaX()< posicion.getCoordenadaX());

    }

    @Test
    public void test08DireccionOesteRotaYEsDireccionNorte(){
        Posicion posicion = new Posicion(2, 2);
        Direccion direccion = DireccionOeste.getInstancia();
        direccion = direccion.rotar();

        assertTrue(direccion.siguiente(posicion).getCoordenadaY() < posicion.getCoordenadaY());
    }

    @Test
    public void test09LaDireccionInversaALaNorteEsLaSur(){
        Posicion posicion = new Posicion(2,2);
        Direccion direccion = DireccionNorte.getInstancia();
        direccion = direccion.invertir();

        assertTrue(direccion.siguiente(posicion).getCoordenadaY() > posicion.getCoordenadaY());
    }

    @Test
    public void test10LaDireccionInversaALaSurEsLaNorte(){
        Posicion posicion = new Posicion(2, 2);
        Direccion direccion = DireccionSur.getInstancia();
        direccion = direccion.invertir();

        assertTrue(direccion.siguiente(posicion).getCoordenadaY() < posicion.getCoordenadaY());
    }
    @Test
    public void test11LaDireccionInversaALaEsteEsLaOeste(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccion = DireccionEste.getInstancia();
        direccion = direccion.invertir();

        assertTrue(direccion.siguiente(posicion).getCoordenadaX()< posicion.getCoordenadaX());
    }
    @Test
    public void test12LaDireccionInversaALaOEsteEsLaEste(){
        Posicion posicion = new Posicion(0,0);
        Direccion direccion = DireccionOeste.getInstancia();
        direccion = direccion.invertir();

        assertTrue(direccion.siguiente(posicion).getCoordenadaX()> posicion.getCoordenadaX());
    }
}
