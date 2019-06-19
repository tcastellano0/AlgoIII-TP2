import Juego.Mapa.Posicion;

import org.junit.Assert;
import org.junit.Test;

public class PosicionTest {
    @Test
    public void test01DosPosicionesSonIgualesSiTienenLasMismasCoordenadas(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(2, 2);

        Assert.assertEquals(pos1, pos2);
    }

    @Test
    public void test02DosPosicionesSonDistintasSiTienenDistintaPrimeraCoordenada(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(3, 2);

        Assert.assertNotEquals(pos1, pos2);
    }
    
    @Test
    public void test03DosPosicionesSonDistintasSiTienenDistintaSegundaCoordenada(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(2, 3);

        Assert.assertNotEquals(pos1, pos2);
    }

    @Test
    public void test04LaPosicionDeArribaEsLaQueTieneLaSegundaCoordenadaUnoMayor(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(2, 3);

        Assert.assertEquals(pos1.arriba(), pos2);
    }
    @Test
    public void test05LaPosicionDeAbajoEsLaQueTieneLaSegundaCoordenadaUnoMenor(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(2, 1);

        Assert.assertEquals(pos1.abajo(), pos2);
    }
    @Test
    public void test06LaPosicionDerechaEsLaQueTieneLaPrimeraCoordenadaUnoMayor(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(3, 2);

        Assert.assertEquals(pos1.derecha(), pos2);
    }
    @Test
    public void test07LaPosicionIzquierdaEsLaQueTieneLaPrimeraCoordenadaUnoMenor(){
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(1, 2);

        Assert.assertEquals(pos1.izquierda(), pos2);
    }
}
