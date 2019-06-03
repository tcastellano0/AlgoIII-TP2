package Materiales;

import Herramientas.*;

public interface Golpeable {
    public void golpeadoPor(Golpeador golpeador);
    
    public void golpeadoPor(GolpeadorHachaDeMadera golpeador);
    public void golpeadoPor(GolpeadorHachaDePiedra golpeador);
    public void golpeadoPor(GolpeadorHachaDeMetal golpeador);
    
    public void golpeadoPor(GolpeadorPicoDeMadera golpeador);
    public void golpeadoPor(GolpeadorPicoDePiedra golpeador);
    public void golpeadoPor(GolpeadorPicoDeMetal golpeador);
    public void golpeadoPor(GolpeadorPicoFino golpeador);
}
