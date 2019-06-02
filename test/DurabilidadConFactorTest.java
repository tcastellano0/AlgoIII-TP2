import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurabilidadConFactorTest {

    @Test
    public void test01DurabilidadConFactorUnoReduceDurabilidadDeAcuerdoALaFuerza(){
        double durabilidadInicial = 100;
        int fuerza = 5;
        Durabilidad durabilidad = new DurabilidadConFactor(1, durabilidadInicial);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza);

    }

    @Test
    public void test02DurabilidadConFactorUnoYDistintasFuerzasReduceDurabilidadDeAcuerdoALaFuerza(){
        double durabilidadInicial = 100;
        int fuerza = 5;
        int otraFuerza = 6;
        int otraFuerzaMas = 10;
        Durabilidad durabilidad = new DurabilidadConFactor(1, durabilidadInicial);

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
        double factor = 2;
        Durabilidad durabilidad = new DurabilidadConFactor(factor, durabilidadInicial);

        durabilidad.desgastar(fuerza);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial - fuerza/factor);
    }
    
    @Test
    public void test04DurabilidadConFactorUnoDecreceLinealmenteConLaFuerza() {
    	double durabilidadInicial = 5;
    	int fuerza = 1;
    	double factor = 1;
    	
    	Durabilidad durabilidad = new DurabilidadConFactor(factor, durabilidadInicial);
    	
    	for(int i=0; i < durabilidadInicial; i++) {
    		durabilidad.desgastar(fuerza);
    	}
    	
    	assertEquals(durabilidad.getDurabilidad(), 0);
    }

    
    

}