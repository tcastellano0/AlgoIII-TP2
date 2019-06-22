package Vista;

import Juego.Jugador.Jugador;
import Juego.Mapa.Ubicable;
import Materiales.Diamante;
import Materiales.Madera;
import Materiales.Metal;
import Materiales.Piedra;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCelda extends Button {
    ImageView imageView;
    Image imagenJugador = new Image("Vista/images/menu/jugador.jpg", 25, 25, false, true);
    Image imagenMadera = new Image("Vista/images/menu/madera.jpg", 25, 25, false, true);
    Image imagenPiedra = new Image("Vista/images/menu/piedra.jpg", 25, 25, false, true);
    Image imagenMetal = new Image("Vista/images/menu/metal.jpg", 25, 25, false, true);
    Image imagenDiamante = new Image("Vista/images/menu/diamante.jpg", 25, 25, false, true);
    Image imagenPasto = new Image("Vista/images/menu/pasto.jpg", 25, 25, false, true);

    public VistaCelda(){
        imageView = new ImageView(imagenPasto);
        this.setGraphic(imageView);
    }

    public VistaCelda(Ubicable ubicable) {
        Class<? extends Ubicable> clase = ubicable.getClass();

        if (clase == Madera.class) {
            imageView = new ImageView(imagenMadera);
        }
        if (clase == Piedra.class) {
            imageView = new ImageView(imagenPiedra);
        }
        if (clase == Metal.class) {
            imageView = new ImageView(imagenMetal);
        }
        if (clase == Diamante.class) {
            imageView = new ImageView(imagenDiamante);
        }
        if (clase == Jugador.class) {
            imageView = new ImageView(imagenJugador);
        }
        if (clase == null){
            imageView = new ImageView(imagenPasto);
        }
        this.setGraphic(imageView);
    }
}
