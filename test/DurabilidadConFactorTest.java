import Durabilidad.Durabilidad;
import Durabilidad.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DurabilidadConFactorTest {

    @Test
    public void test01DurabilidadConFactorUnoReduceDurabilidadDeAcuerdoALaFuerza(){
        int fuerza = 5;
        double durabilidadInicial = 100;
        Durabilidad durabilidad = new DurabilidadConFactor(1, durabilidadInicial);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza, 0);

    }

    @Test
    public void test02DurabilidadConFactorUnoYDistintasFuerzasReduceDurabilidadDeAcuerdoALaFuerza(){
        int fuerza = 5;
        int otraFuerza = 6;
        int otraFuerzaMas = 10;
        double durabilidadInicial = 100;
        Durabilidad durabilidad = new DurabilidadConFactor(1, durabilidadInicial);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza, 0);

        durabilidad.desgastar(otraFuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza - otraFuerza, 0);

        durabilidad.desgastar(otraFuerzaMas);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza - otraFuerza - otraFuerzaMas, 0);
    }

    @Test
    public void test03DurabilidadConFactorReduceDurabilidadDeAcuerdoALaFuerzaYAlFactor(){
        int fuerza = 5;
        double factor = 2;
        double durabilidadInicial = 100;
        Durabilidad durabilidad = new DurabilidadConFactor(factor, durabilidadInicial);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza/factor, 2);
    }
    
    @Test
    public void test04DurabilidadConFactorUnoDecreceLinealmenteConLaFuerza() {
    	int fuerza = 1;
    	double factor = 1;
    	double durabilidadInicial = 5;
    	Durabilidad durabilidad = new DurabilidadConFactor(factor, durabilidadInicial);
    	
    	for(int i=0; i < durabilidadInicial; i++) {
    		durabilidad.desgastar(fuerza);
    	}
    	
    	assertEquals(durabilidad.getDurabilidad(), 0, 0);
    }

}