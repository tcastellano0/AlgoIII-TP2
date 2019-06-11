package Materiales;

import Durabilidad.DurabilidadConFactor;
import Herramientas.*;

public class MaterialNulo extends Material {

    public MaterialNulo() {
        this.durabilidad = new DurabilidadConFactor(1,0);
    }

    @Override
    public void golpeadoPor(GolpeadorHachaDeMadera golpeador) {
        
    }

    @Override
    public void golpeadoPor(GolpeadorHachaDePiedra golpeador) {

    }

    @Override
    public void golpeadoPor(GolpeadorHachaDeMetal golpeador) {

    }

    @Override
    public void golpeadoPor(GolpeadorPicoDeMadera golpeador) {

    }

    @Override
    public void golpeadoPor(GolpeadorPicoDePiedra golpeador) {

    }

    @Override
    public void golpeadoPor(GolpeadorPicoDeMetal golpeador) {

    }

    @Override
    public void golpeadoPor(GolpeadorPicoFino golpeador) {

    }
}
