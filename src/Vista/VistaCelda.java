package Vista;


import Juego.Mapa.Ubicable;
import javafx.scene.layout.StackPane;
import Juego.Mapa.Celda;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class VistaCelda extends StackPane {

    Celda celda;

    EligeVistas rutaVistas = EligeVistas.getInstance();

    public VistaCelda(){

    }

    public VistaCelda(Celda celda) {
        this.celda = celda;
        this.actualizar();
    }

    public void actualizar() {
        //ACORDARSE DE SACAR
        Ubicable u = (Ubicable) celda.ver();
        String ruta = this.rutaVistas.getRutaImagen(u);
        Image img = new Image(ruta, 40, 40, false, false);
        this.getChildren().add(new ImageView((img)));
    }
}
