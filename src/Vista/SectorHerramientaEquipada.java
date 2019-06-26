package Vista;

import Herramientas.Herramienta;
import Juego.Jugador.Jugador;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class SectorHerramientaEquipada extends HBox {

    Jugador jugador;
    StackPane panelHerramienta;

    public SectorHerramientaEquipada(Jugador j){
        this.jugador = j;
        panelHerramienta = new StackPane();

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        Image img = new Image("Vista/images/materiales/map_vacio.png", 35,35,false,false);

        panelHerramienta.getChildren().add(new ImageView(img));

        this.setBackground(new Background(new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

        getChildren().add(panelHerramienta);

        actualizar();
    }

    public void actualizar(){
        Herramienta h = jugador.herramientaEquipada();

        //this.panelHerramienta.setBackground();

    }
}
