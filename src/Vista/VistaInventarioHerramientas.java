package Vista;

import Juego.Jugador.Jugador;
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
        VistaHerramientaEquipada herramientaEquipada = new VistaHerramientaEquipada(new Jugador());

        ImageView imgHerr1 = new ImageView(new Image("Vista/images/herramientas/hachaMadera.png",35,35, false, false));
        Button slotHerramienta1 = new Button("", imgHerr1);
        Text cantHerramienta1 = new Text("x N");
        cantHerramienta1.setStyle("-fx-font: 12 arial;");

        ImageView imgHerr2 = new ImageView(new Image("Vista/images/herramientas/hachaPiedra.png",35,35, false, false));
        Button slotHerramienta2 = new Button("", imgHerr2);

        ImageView imgHerr3 = new ImageView(new Image("Vista/images/herramientas/hachaMetal.png",35,35, false, false));
        Button slotHerramienta3 = new Button("", imgHerr3);

        ImageView imgHerr4 = new ImageView(new Image("Vista/images/herramientas/picoMadera.png",35,35, false, false));
        Button slotHerramienta4 = new Button("", imgHerr4);

        ImageView imgHerr5 = new ImageView(new Image("Vista/images/herramientas/picoPiedra.png",35,35, false, false));
        Button slotHerramienta5 = new Button("", imgHerr5);

        ImageView imgHerr6 = new ImageView(new Image("Vista/images/herramientas/picoMetal.png",35,35, false, false));
        Button slotHerramienta6 = new Button("", imgHerr6);

        ImageView imgHerr7 = new ImageView(new Image("Vista/images/herramientas/picoFino.png",35,35, false, false));
        Button slotHerramienta7 = new Button("", imgHerr7);


        //getChildren().addAll(slotHerramienta1, cantHerramienta1, slotHerramienta2, cantidadHachaPiedra,
        //        slotHerramienta3, cantidadHachaMetal, slotHerramienta4, cantidadPicoMadera,
        //        slotHerramienta5,cantidadPicoPiedra, slotHerramienta6, cantidadPicoMetal,
        //        slotHerramienta7, cantidadPicoFino);
        getChildren().addAll(herramientaEquipada, slotHerramienta1, cantHerramienta1, slotHerramienta2,
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
