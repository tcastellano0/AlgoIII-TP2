import Materiales.*;
import Herramientas.*;
import Juego.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegracionTest {

    @Test
    public void test01CreoJugadorYUsoSuArmaEquipadaParaGolpearUnBloqueDeMaderaYBloqueSeDesgasta(){
        Jugador jugador = new Jugador();
        Herramienta hacha = jugador.herramientaEquipada();
        Material bloqueMadera = new Madera();
        double durabilidadInicialMadera = bloqueMadera.getDurabilidad();

        hacha.golpear(bloqueMadera);

        assertTrue(bloqueMadera.getDurabilidad() < durabilidadInicialMadera);
    }

    @Test
    public void test02CreoJugadorYUsoSuArmaEquipadaParaGolpearUnBloqueDeMaderaYArmaSeDesgasta(){
        Jugador jugador = new Jugador();
        Herramienta hacha = jugador.herramientaEquipada();
        Material bloqueMadera = new Madera();
        double durabilidadInicialHacha = hacha.getDurabilidad();

        hacha.golpear(bloqueMadera);

        assertTrue(hacha.getDurabilidad() < durabilidadInicialHacha);
    }

    @Test
    public void test03CreoJugadorYUsoSuArmaEquipadaParaGolpearUnBloqueDeMaderaYBloqueNoSeDesgasta(){
        Jugador jugador = new Jugador();
        Herramienta hacha = jugador.herramientaEquipada();
        Material bloqueMetal = new Metal();
        double durabilidadInicialMetal = bloqueMetal.getDurabilidad();

        hacha.golpear(bloqueMetal);

        assertEquals(bloqueMetal.getDurabilidad(), durabilidadInicialMetal);
    }

    @Test
    public void test04CreoJugadorYUsoSuArmaEquipadaParaGolpearUnBloqueDeMaderaYArmaSeDesgasta(){
        Jugador jugador = new Jugador();
        Herramienta hacha = jugador.herramientaEquipada();
        Material bloqueMetal = new Metal();
        double durabilidadInicialHacha = hacha.getDurabilidad();

        hacha.golpear(bloqueMetal);

        assertTrue(hacha.getDurabilidad() < durabilidadInicialHacha);
    }

}
