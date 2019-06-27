package Vista;

import Herramientas.Herramienta;
import Juego.Jugador.Jugador;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.HashMap;

public class SectorHerramientaEquipada extends HBox {

    Jugador jugador;
    StackPane panelHerramienta;
    private HashMap<Herramienta, String> rutaHerramienta;

    public SectorHerramientaEquipada(Jugador j){
        this.jugador = j;

        rutaHerramienta = new HashMap<>();
        rutaHerramienta.put(Herramienta.hachaDeMadera(), "Vista/images/herramientas/hachaMadera.png");
        rutaHerramienta.put(Herramienta.hachaDePiedra(), "Vista/images/herramientas/hachaPiedra.png");
        rutaHerramienta.put(Herramienta.hachaDeMetal(), "Vista/images/herramientas/hachaMetal.png");
        rutaHerramienta.put(Herramienta.picoDeMadera(), "Vista/images/herramientas/picoMadera.png");
        rutaHerramienta.put(Herramienta.picoDePiedra(), "Vista/images/herramientas/picoPiedra.png");
        rutaHerramienta.put(Herramienta.picoDeMetal(), "Vista/images/herramientas/picoMetal.png");
        rutaHerramienta.put(Herramienta.picoFino(), "Vista/images/herramientas/picoFino.png");

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


        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        Image img = new Image(rutaHerramienta.get(h), 35,35,false,false);
        this.panelHerramienta.setBackground(new Background(new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

    }
}
