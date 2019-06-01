public class Hacha extends Herramienta {

    public Hacha(double durabilidad, int fuerza){
        this.durabilidad = durabilidad;
        this.fuerza = fuerza;
    }

    public static Hacha crearHachaDeMadera(){
        return new Hacha(100,2);
    }

    public static Hacha crearHachaDePiedra(){
        return new Hacha(200,5);
    }

    public static Hacha crearHachaDeMetal(){
        return new Hacha(400,10);
    }

    public double getFuerzaa() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void desgastar(){
        this.durabilidad -= this.getFuerza();
    }
}

