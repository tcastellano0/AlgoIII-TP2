import Juego.Jugador.Direccion;
import Juego.Jugador.DireccionNorte;
import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import Juego.Mapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovimientoTest {
    @Test
    void test01LaDireccionInicialDelMovimientoEsNorte(){
        Movimiento movimiento = new Movimiento();
        Direccion direccion = movimiento.getDireccion();
        assertEquals(direccion, DireccionNorte.getInstancia());
    }

    @Test
    void test02MoverUnJugadorModificaSuPosicion(){
        Jugador jugador = new Jugador();
        Movimiento movimiento = new Movimiento();
        Posicion posicion = new Posicion(0,0);
        jugador.setPosicion(posicion);

        movimiento.avanzar(jugador);

        assertNotEquals(jugador.getPosicion(), posicion);
    }

}
