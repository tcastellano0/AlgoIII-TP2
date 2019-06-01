import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurabilidadConFactorTest {

    @Test
    public void test01DurabilidadConFactorUnoReduceDurabilidadDeAcuerdoALaFuerza(){
        double durabilidadInicial = 100;
        int fuerza = 5;
        Durabilidad durabilidad = new DurabilidadConFactor(durabilidadInicial, 1);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza);

    }

    @Test
    public void test02DurabilidadConFactorUnoYDistintasFuerzasReduceDurabilidadDeAcuerdoALaFuerza(){
        double durabilidadInicial = 100;
        int fuerza = 5;
        int otraFuerza = 6;
        int otraFuerzaMas = 10;
        Durabilidad durabilidad = new DurabilidadConFactor(durabilidadInicial, 1);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza);

        durabilidad.desgastar(otraFuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza - otraFuerza);

        durabilidad.desgastar(otraFuerzaMas);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza - otraFuerza - otraFuerzaMas);
    }

    @Test
    public void test03DurabilidadConFactorReduceDurabilidadDeAcuerdoALaFuerzaYAlFactor(){
        double durabilidadInicial = 100;
        int fuerza = 5;
        double factor;
        factor = 2;
        Durabilidad durabilidad = new DurabilidadConFactor(durabilidadInicial, factor);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza/factor);

    }

    @Test
    public void test04DurabilidadConFactorReduceDurabilidadDeAcuerdoALaFuerzaYAlFactor(){
        double durabilidadInicial = 100;
        int fuerza = 5;
        double factor;
        factor = 2;
        Durabilidad durabilidad = new DurabilidadConFactor(durabilidadInicial, factor);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza/factor);

    }

}