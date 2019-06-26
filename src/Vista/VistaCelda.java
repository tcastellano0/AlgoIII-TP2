package Vista;


import Juego.Mapa.Ubicable;
import javafx.scene.layout.*;
import Juego.Mapa.Celda;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class VistaCelda extends StackPane {

    Celda celda;
    EligeVistas rutaVistas = EligeVistas.getInstance();
    Image imgVacio = new Image(rutaVistas.vacio(), 35, 35, false, false);


    public VistaCelda(Celda celda) {
        this.celda = celda;
        this.getChildren().add(new ImageView(imgVacio));
        this.actualizar();
    }

    public void actualizar() {

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        Image img = imgVacio;
        if (!celda.estaVacia()) {
            //ACORDARSE DE SACAR
            Ubicable u = (Ubicable) celda.ver();
            String ruta = this.rutaVistas.getRutaImagen(u);
            img = new Image(ruta, 35, 35, false, false);
        }

        this.setBackground(new Background(new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }
}
