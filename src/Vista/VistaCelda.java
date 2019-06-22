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

import java.util.HashMap;
import java.util.Map;

public class VistaCelda extends Button {
    ImageView imageView;

    protected Map<Class, Class> vistas = new HashMap<>();
    Image imagenJugador = new Image("Vista/images/materiales/jugador.jpg", 25, 25, false, true);
    Image imagenMadera = new Image("Vista/images/materiales/madera.jpg", 25, 25, false, true);
    Image imagenPiedra = new Image("Vista/images/materiales/piedra.jpg", 25, 25, false, true);
    Image imagenMetal = new Image("Vista/images/materiales/metal.jpg", 25, 25, false, true);
    Image imagenDiamante = new Image("Vista/images/materiales/diamante.jpg", 25, 25, false, true);
    Image imagenPasto = new Image("Vista/images/materiales/pasto.jpg", 25, 25, false, true);

    public VistaCelda(){
        imageView = new ImageView(imagenPasto);
        this.setGraphic(imageView);
    }

    public VistaCelda(Ubicable ubicable) {
        Class<? extends Ubicable> x = ubicable.getClass();

        if (x == Madera.class) {
            imageView = new ImageView(imagenMadera);
        }
        if (x == Piedra.class) {
            imageView = new ImageView(imagenPiedra);
        }
        if (x == Metal.class) {
            imageView = new ImageView(imagenMetal);
        }
        if (x == Diamante.class) {
            imageView = new ImageView(imagenDiamante);
        }
        if (x == Jugador.class) {
            imageView = new ImageView(imagenJugador);
        }
        if (x == null){
            imageView = new ImageView(imagenPasto);
        }
        this.setGraphic(imageView);
    }
}
