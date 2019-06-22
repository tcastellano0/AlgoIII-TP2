package Vista;

import Juego.Mapa.Ubicable;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class VistaCelda extends StackPane {

    EligeVistas rutaVistas = EligeVistas.getInstance();

    public VistaCelda(){

    }

    public VistaCelda(Ubicable ubicable) {
        String ruta = this.rutaVistas.getRutaImagen(ubicable);
        Image img = new Image(ruta, 40, 40, false, false);
        this.getChildren().add(new ImageView((img)));
    }
}
