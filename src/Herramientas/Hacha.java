package Herramientas;

import Materiales.Material;
import Durabilidad.*;

public class Hacha extends Herramienta {

    public Hacha(Durabilidad durabilidad, Golpeador golpeador){
        this.durabilidad = durabilidad;
        this.golpeador = golpeador;
    }

    @Override
    public void golpear(Material material) {
        material.golpeadoPor(this.golpeador);
        this.desgastar(this.getFuerza());
    }

    public static Hacha crearHachaDeMadera(){
        return new Hacha(new DurabilidadConFactor(1, 100), new GolpeadorHachaDeMadera());
    }

    public static Hacha crearHachaDePiedra(){
        return new Hacha(new DurabilidadConFactor(1, 200), new GolpeadorHachaDePiedra());
    }

    public static Hacha crearHachaDeMetal(){
        return new Hacha(new DurabilidadConFactor(2, 400), new GolpeadorHachaDeMetal());
    }

}

