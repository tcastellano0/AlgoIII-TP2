package Herramientas;

import java.util.Objects;

import Durabilidad.*;

import Materiales.Material;

public class Herramienta {

	protected Durabilidad durabilidad;
	protected Golpeador golpeador;

    public Herramienta(Durabilidad durabilidad, Golpeador golpeador) {
        this.durabilidad = durabilidad;
        this.golpeador = golpeador;
    }

    public double getDurabilidad() {
        return this.durabilidad.getDurabilidad();
    }

    public int getFuerza() {
        return this.golpeador.getFuerza();
    }

    public void desgastar(int fuerzaDesgaste){
        this.durabilidad.desgastar(fuerzaDesgaste);
    }

    public void golpear(Material material) {
        material.golpeadoPor(this.golpeador);
        this.desgastar(this.getFuerza());
    }

    public boolean estaRota(){
        return this.durabilidad.esCeroOMenor();
    }

    //metodos de clase para instanciar cada tipo de herramienta
    public static Herramienta hachaDeMadera(){
        return new Herramienta(new DurabilidadConFactor(1, 100), new GolpeadorHachaDeMadera());
    }

    public static Herramienta hachaDePiedra(){
        return new Herramienta(new DurabilidadConFactor(1, 200), new GolpeadorHachaDePiedra());
    }

    public static Herramienta hachaDeMetal(){
        return new Herramienta(new DurabilidadConFactor(2, 400), new GolpeadorHachaDeMetal());
    }

    public static Herramienta picoDeMadera() {
        return new Herramienta(new DurabilidadConFactor(1, 100), new GolpeadorPicoDeMadera());
    }

    public static Herramienta picoDePiedra() {
        return new Herramienta(new DurabilidadConFactor(1.5, 200), new GolpeadorPicoDePiedra());
    }

    public static Herramienta picoDeMetal() {
        return new Herramienta(new DurabilidadConUsos(10, 400), new GolpeadorPicoDeMetal());
    }

    public static Herramienta picoFino() {
        return new Herramienta(new DurabilidadConFactor(10, 1000), new GolpeadorPicoFino());
    }
    
    @Override 
    public int hashCode() { 
    	return Objects.hash(this.golpeador.getClass()); 
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herramienta herramienta = (Herramienta) o;
        
        return this.golpeador.getClass() == herramienta.golpeador.getClass();
    }



}
