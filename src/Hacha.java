public class Hacha extends Herramienta {

    public Hacha(Durabilidad durabilidad, int fuerza){
        this.durabilidad = durabilidad;
        this.fuerza = fuerza;
    }

    public static Hacha crearHachaDeMadera(){
        return new Hacha(new DurabilidadConFactor(100, 1), 2);
    }

    public static Hacha crearHachaDePiedra(){
        return new Hacha(new DurabilidadConFactor(200, 1), 5);
    }

    public static Hacha crearHachaDeMetal(){
        return new Hacha(new DurabilidadConFactor(400, 2), 10);
    }

    public void desgastar(){
        this.durabilidad -= this.getFuerza();
    }
}

