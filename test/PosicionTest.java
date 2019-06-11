import Juego.Mapa.Posicion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosicionTest {
    @Test
    void test01DosPosicionesSonIgualesSiTienenLasMismasCoordenadas(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(2, 2);

        Assertions.assertEquals(pos1, pos2);
    }

    @Test
    void test02DosPosicionesSonDistintasSiTienenDistintaPrimeraCoordenada(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(3, 2);

        Assertions.assertNotEquals(pos1, pos2);
    }
    
    @Test
    void test03DosPosicionesSonDistintasSiTienenDistintaSegundaCoordenada(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(2, 3);

        Assertions.assertNotEquals(pos1, pos2);
    }
}
