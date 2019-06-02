public class Hacha extends Herramienta {

    public Hacha(int fuerza, Durabilidad durabilidad){
        this.fuerza = fuerza;
        this.durabilidad = durabilidad;
    }

    @Override
    public void golpear(Material material) {
        material.golpeadoPor(this);
        this.desgastar(this.fuerza);
    }

    public static Hacha crearHachaDeMadera(){
        return new Hacha(2, new DurabilidadConFactor(1, 100));
    }

    public static Hacha crearHachaDePiedra(){
        return new Hacha(5, new DurabilidadConFactor(1, 200));
    }

    public static Hacha crearHachaDeMetal(){
        return new Hacha(10, new DurabilidadConFactor(2, 400));
    }

}

