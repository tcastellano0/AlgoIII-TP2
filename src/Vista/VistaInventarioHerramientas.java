package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class VistaInventarioHerramientas extends HBox {
    public VistaInventarioHerramientas() {
        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(10);
        setTitutlo();
        agregarBotonesHerramientas();

    }

    private void agregarBotonesHerramientas(){
        Image imgVacio = new Image(EligeVistas.getInstance().vacio(), 35, 35, false, false);

        Button slotHerramienta1 = new Button("", new ImageView(imgVacio));
        Text cantHerramienta1 = new Text("x 0");
        cantHerramienta1.setStyle("-fx-font: 12 arial;");

        Button slotHerramienta2 = new Button("", new ImageView(imgVacio));

        Button slotHerramienta3 = new Button("", new ImageView(imgVacio));

        Button slotHerramienta4 = new Button("", new ImageView(imgVacio));

        Button slotHerramienta5 = new Button("", new ImageView(imgVacio));

        Button slotHerramienta6 = new Button("", new ImageView(imgVacio));

        Button slotHerramienta7 = new Button("", new ImageView(imgVacio));


        //getChildren().addAll(slotHerramienta1, cantHerramienta1, slotHerramienta2, cantidadHachaPiedra,
        //        slotHerramienta3, cantidadHachaMetal, slotHerramienta4, cantidadPicoMadera,
        //        slotHerramienta5,cantidadPicoPiedra, slotHerramienta6, cantidadPicoMetal,
        //        slotHerramienta7, cantidadPicoFino);
        getChildren().addAll(slotHerramienta1, cantHerramienta1, slotHerramienta2,
                slotHerramienta3,  slotHerramienta4,
                slotHerramienta5, slotHerramienta6,
                slotHerramienta7);
    }

    private void setTitutlo(){
        Text herramientasTexto = new Text("Herramientas:");
        herramientasTexto.setStyle("-fx-font: 18 arial;");
        getChildren().add(herramientasTexto);
    }
}
