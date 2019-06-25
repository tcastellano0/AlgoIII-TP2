package Vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class VistaInventarioHerramientas extends HBox {
    public VistaInventarioHerramientas() {
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(25);
        setTitutlo();
        agregarBotonesHerramientas();

    }

    private void agregarBotonesHerramientas(){
        Image imgVacio = new Image(EligeVistas.getInstance().vacio(), 35, 35, false, false);

        Button slotHerramienta1 = new Button("", new ImageView(imgVacio));
        Button slotHerramienta2 = new Button("", new ImageView(imgVacio));
        Button slotHerramienta3 = new Button("", new ImageView(imgVacio));
        Button slotHerramienta4 = new Button("", new ImageView(imgVacio));
        Button slotHerramienta5 = new Button("", new ImageView(imgVacio));
        Button slotHerramienta6 = new Button("", new ImageView(imgVacio));
        Button slotHerramienta7 = new Button("", new ImageView(imgVacio));

        getChildren().addAll(slotHerramienta1,slotHerramienta2,slotHerramienta3,slotHerramienta4,slotHerramienta5,slotHerramienta6,slotHerramienta7);
    }

    private void setTitutlo(){
        Text herramientasTexto = new Text("Herramientas:");
        herramientasTexto.setStyle("-fx-font: 18 arial;");
        getChildren().add(herramientasTexto);
    }
}
