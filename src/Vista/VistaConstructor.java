package Vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaConstructor extends VBox {
    private EligeVistas rutaVistas = EligeVistas.getInstance();

    public VistaConstructor() {
        Text contructorTexto = new Text("Constructor");
        contructorTexto.setStyle("-fx-font: 24 arial;");
        getChildren().add(contructorTexto);

        Button limpiar = new Button("Limpiar");
        Button crear = new Button("Crear");
        HBox botonesLimpiarYCrearContenedor = new HBox();
        botonesLimpiarYCrearContenedor.setSpacing(10);
        botonesLimpiarYCrearContenedor.getChildren().addAll(limpiar, crear);
        getChildren().add(botonesLimpiarYCrearContenedor);


        Image imgVacio = new Image(rutaVistas.vacio(), 35, 35, false, false);
        GridPane slots = new GridPane();
        Button slotMaterial1 = new Button("", new ImageView(imgVacio));
        Button slotMaterial2 = new Button("", new ImageView(imgVacio));
        Button slotMaterial3 = new Button("", new ImageView(imgVacio));
        Button slotMaterial4 = new Button("", new ImageView(imgVacio));
        Button slotMaterial5 = new Button("", new ImageView(imgVacio));
        Button slotMaterial6 = new Button("", new ImageView(imgVacio));
        Button slotMaterial7 = new Button("", new ImageView(imgVacio));
        Button slotMaterial8 = new Button("", new ImageView(imgVacio));
        Button slotMaterial9 = new Button("", new ImageView(imgVacio));

        slots.add(slotMaterial1, 0, 0);
        slots.add(slotMaterial2, 0, 1);
        slots.add(slotMaterial3, 0, 2);
        slots.add(slotMaterial4, 1, 0);
        slots.add(slotMaterial5, 1, 1);
        slots.add(slotMaterial6, 1, 2);
        slots.add(slotMaterial7, 2, 0);
        slots.add(slotMaterial8, 2, 1);
        slots.add(slotMaterial9, 2, 2);

        getChildren().add(slots);


    }
}
