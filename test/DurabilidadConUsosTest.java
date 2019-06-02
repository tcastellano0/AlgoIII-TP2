import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurabilidadConUsosTest {

    @Test
    public void test01DurabilidadConUsosSinDesgastarTieneDurabilidadInicial(){
        double durabilidadInicial = 400;
        Durabilidad durabilidad = new DurabilidadConUsos(10, durabilidadInicial);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);

    }

    @Test
    public void test02DurabilidadConUsosYPocoDesgasteTieneDurabilidadInicial(){
        double durabilidadInicial = 400;
        Durabilidad durabilidad = new DurabilidadConUsos(10, durabilidadInicial);

        durabilidad.desgastar(5);
        durabilidad.desgastar(5);
        durabilidad.desgastar(5);
        durabilidad.desgastar(5);
        durabilidad.desgastar(5);

        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);

    }

    @Test
    public void test03DurabilidadConDosUsosTieneDurabilidadCeroDespuesDeDosUsosConFuerzaCinco(){
        double durabilidadInicial = 400;
        Durabilidad durabilidad = new DurabilidadConUsos(2, durabilidadInicial);
        durabilidad.desgastar(5);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(5);
        assertEquals(durabilidad.getDurabilidad(), 0);

    }

    @Test
    public void test04DurabilidadConDosUsosTieneDurabilidadCeroDespuesDeDosUsosConFuerzaCero(){
        double durabilidadInicial = 400;
        Durabilidad durabilidad = new DurabilidadConUsos(2, durabilidadInicial);
        durabilidad.desgastar(0);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(0);
        assertEquals(durabilidad.getDurabilidad(), 0);

    }

    @Test
    public void test05DurabilidadConUsosDesgasteNoDependeDeLaFuerza(){
        double durabilidadInicial = 400;
        Durabilidad durabilidad = new DurabilidadConUsos(5, durabilidadInicial);

        durabilidad.desgastar(1);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(2);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(3);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(4);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(5);
        assertEquals(durabilidad.getDurabilidad(), 0);

        durabilidad = new DurabilidadConUsos(5, durabilidadInicial);

        durabilidad.desgastar(100);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(200);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(300);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(400);
        assertEquals(durabilidad.getDurabilidad(), durabilidadInicial);
        durabilidad.desgastar(500);
        assertEquals(durabilidad.getDurabilidad(), 0);

    }
    
    @Test
    public void test06DurabilidadConUsosConUsosDeMasSigueSiendoCero() {
    	double durabilidadInicial = 400;
        Durabilidad durabilidad = new DurabilidadConUsos(1, durabilidadInicial);
        
        durabilidad.desgastar(100);
        durabilidad.desgastar(100);
        assertEquals(durabilidad.getDurabilidad(), 0);
        
        durabilidad.desgastar(100);
        assertEquals(durabilidad.getDurabilidad(), 0);
    }

}