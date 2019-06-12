package Juego.Mapa;

import Materiales.Madera;
import Materiales.Piedra;
import Materiales.Metal;
import Materiales.Diamante;



public class Mapa extends Tablero<Ubicable> {

    public Mapa() {
        super(20, 20);
        this.setUpTerreno();
    }
    
    private void setUpTerreno() {
    	this.setUpMadera();
    	this.setUpPiedra();
    	this.setUpMetal();
    	this.setUpDiamante();
    }
    
    private void setUpMadera() {
    	this.poner(new Madera(), new Posicion(1, 6));
    	this.poner(new Madera(), new Posicion(1, 8));
    	this.poner(new Madera(), new Posicion(2, 14));
    	this.poner(new Madera(), new Posicion(1, 17));
    	this.poner(new Madera(), new Posicion(1, 20));
    	this.poner(new Madera(), new Posicion(3, 8));
    	this.poner(new Madera(), new Posicion(4, 3));
    	this.poner(new Madera(), new Posicion(4, 5));
    	this.poner(new Madera(), new Posicion(4, 16));
    	this.poner(new Madera(), new Posicion(5, 1));
    	this.poner(new Madera(), new Posicion(5, 10));
    	this.poner(new Madera(), new Posicion(5, 20));
    	this.poner(new Madera(), new Posicion(7, 3));
    	this.poner(new Madera(), new Posicion(8, 15));
    	this.poner(new Madera(), new Posicion(8, 18));
    	this.poner(new Madera(), new Posicion(9, 5));
    	this.poner(new Madera(), new Posicion(10, 3));
    	this.poner(new Madera(), new Posicion(12, 1));
    	this.poner(new Madera(), new Posicion(12, 3));
    	this.poner(new Madera(), new Posicion(12, 15));
    	this.poner(new Madera(), new Posicion(12, 20));
    	this.poner(new Madera(), new Posicion(14, 17));
    	this.poner(new Madera(), new Posicion(15, 4));
    	this.poner(new Madera(), new Posicion(16, 11));
    	this.poner(new Madera(), new Posicion(17, 1));
    	this.poner(new Madera(), new Posicion(17, 8));
    	this.poner(new Madera(), new Posicion(17, 15));
    	this.poner(new Madera(), new Posicion(19, 17));
    	this.poner(new Madera(), new Posicion(20, 5));
    	this.poner(new Madera(), new Posicion(20, 10));
    	this.poner(new Madera(), new Posicion(20, 20));
    }
    
    private void setUpPiedra() {
    	this.poner(new Piedra(), new Posicion(4, 6));
    	this.poner(new Piedra(), new Posicion(5, 15));
    	this.poner(new Piedra(), new Posicion(6, 17));
    	this.poner(new Piedra(), new Posicion(10, 16));
    	this.poner(new Piedra(), new Posicion(10, 18));
    	this.poner(new Piedra(), new Posicion(14, 1));
    	this.poner(new Piedra(), new Posicion(14, 16));
    	this.poner(new Piedra(), new Posicion(15, 2));
    	this.poner(new Piedra(), new Posicion(15, 19));
    	this.poner(new Piedra(), new Posicion(16, 6));
    	this.poner(new Piedra(), new Posicion(17, 18));
    	this.poner(new Piedra(), new Posicion(19, 14));
    	this.poner(new Piedra(), new Posicion(20, 1));
    }
    
    private void setUpMetal() {
    	this.poner(new Metal(), new Posicion(7, 7));
    	this.poner(new Metal(), new Posicion(7, 8));
    	this.poner(new Metal(), new Posicion(7, 9));
    	this.poner(new Metal(), new Posicion(7, 10));
    	this.poner(new Metal(), new Posicion(7, 11));
    	this.poner(new Metal(), new Posicion(7, 12));
    	this.poner(new Metal(), new Posicion(7, 13));
    	this.poner(new Metal(), new Posicion(8, 7));
    	this.poner(new Metal(), new Posicion(8, 8));
    	this.poner(new Metal(), new Posicion(8, 9));
    	this.poner(new Metal(), new Posicion(8, 10));
    	this.poner(new Metal(), new Posicion(8, 11));
    	this.poner(new Metal(), new Posicion(8, 12));
    	this.poner(new Metal(), new Posicion(8, 13));
    	this.poner(new Metal(), new Posicion(9, 7));
    	this.poner(new Metal(), new Posicion(9, 8));
    	this.poner(new Metal(), new Posicion(9, 12));
    	this.poner(new Metal(), new Posicion(9, 13));
    	this.poner(new Metal(), new Posicion(10, 7));
    	this.poner(new Metal(), new Posicion(10, 8));
    	this.poner(new Metal(), new Posicion(10, 12));
    	this.poner(new Metal(), new Posicion(10, 13));
    	this.poner(new Metal(), new Posicion(11, 7));
    	this.poner(new Metal(), new Posicion(11, 8));
    	this.poner(new Metal(), new Posicion(11, 12));
    	this.poner(new Metal(), new Posicion(11, 13));
    	this.poner(new Metal(), new Posicion(12, 7));
    	this.poner(new Metal(), new Posicion(12, 8));
    	this.poner(new Metal(), new Posicion(12, 9));
    	this.poner(new Metal(), new Posicion(12, 10));
    	this.poner(new Metal(), new Posicion(12, 11));
    	this.poner(new Metal(), new Posicion(12, 12));
    	this.poner(new Metal(), new Posicion(12, 13));
    	this.poner(new Metal(), new Posicion(13, 7));
    	this.poner(new Metal(), new Posicion(13, 8));
    	this.poner(new Metal(), new Posicion(13, 9));
    	this.poner(new Metal(), new Posicion(13, 10));
    	this.poner(new Metal(), new Posicion(13, 11));
    	this.poner(new Metal(), new Posicion(13, 12));
    	this.poner(new Metal(), new Posicion(13, 13));
    }
    
    private void setUpDiamante() {
    	this.poner(new Diamante(), new Posicion(10, 10));
    }

}
