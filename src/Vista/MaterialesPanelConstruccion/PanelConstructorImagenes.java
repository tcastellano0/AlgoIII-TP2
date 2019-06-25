package Vista.MaterialesPanelConstruccion;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PanelConstructorImagenes {

    //button.setGraphic(PanelConstructorImagenes.madera()); //Ejemplo

    public static ImageView madera(){
        return new ImageView(new Image("Vista/MaterialesPanelConstruccion/cons_madera.png"));
    }

    public static ImageView piedra(){
        return new ImageView(new Image("Vista/MaterialesPanelConstruccion/cons_piedra.png"));
    }

    public static ImageView metal(){
        return new ImageView(new Image("Vista/MaterialesPanelConstruccion/cons_metal.png"));
    }

    public static ImageView diamante(){
        return new ImageView(new Image("Vista/MaterialesPanelConstruccion/cons_diamante.png"));
    }

}
