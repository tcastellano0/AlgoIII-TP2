public class Hacha extends Herramienta {

    public Hacha(int fuerza, Durabilidad durabilidad){
        this.fuerza = fuerza;
        this.durabilidad = durabilidad;
    }

    public static Hacha crearHachaDeMadera(){
        return new Hacha(2, new DurabilidadConFactor(100, 1));
    }

    public static Hacha crearHachaDePiedra(){
        return new Hacha(5, new DurabilidadConFactor(200, 1));
    }

    public static Hacha crearHachaDeMetal(){
        return new Hacha(10, new DurabilidadConFactor(400, 2));
    }

}

