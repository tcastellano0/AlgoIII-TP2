package Vista;

import Juego.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class VistaInventarioHerramientas extends HBox {
    public VistaInventarioHerramientas(Jugador j) {
        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(10);
        setTitutloEquipada();
        agregarSectorHerramientaEquipada(j);
        setTitutloInventario();
        agregarBotonesHerramientas(j);

    }

    private void setTitutloEquipada(){
        Text herramientasTexto = new Text("Herramienta\nequipada");
        herramientasTexto.setTextAlignment(TextAlignment.CENTER);
        herramientasTexto.setStyle("-fx-font: 18 arial;");

        getChildren().add(herramientasTexto);
    }


    private void agregarSectorHerramientaEquipada (Jugador j){
        SectorHerramientaEquipada herramientaEquipada = new SectorHerramientaEquipada(j);
        getChildren().add(herramientaEquipada);
    }

    private void agregarBotonesHerramientas(Jugador j){
        Text cantidadHachaMadera = new Text("x "+ j.cantidadDeHachasDeMadera());
        cantidadHachaMadera.setStyle("-fx-font: 12 arial;");
        
        Text cantidadHachaPiedra = new Text("x "+ j.cantidadDeHachasDePiedra());
        cantidadHachaPiedra.setStyle("-fx-font: 12 arial;");
        
        Text cantidadHachaMetal = new Text("x "+ j.cantidadDeHachasDeMetal());
        cantidadHachaMetal.setStyle("-fx-font: 12 arial;");
        
        Text cantidadPicoMadera = new Text("x "+ j.cantidadDePicosDeMadera());
        cantidadPicoMadera.setStyle("-fx-font: 12 arial;");
        
        Text cantidadPicoPiedra = new Text("x "+ j.cantidadDePicosDePiedra());
        cantidadPicoPiedra.setStyle("-fx-font: 12 arial;");
        
        Text cantidadPicoMetal = new Text("x "+ j.cantidadDePicosDeMetal());
        cantidadPicoMetal.setStyle("-fx-font: 12 arial;");
        
        Text cantidadPicoFino = new Text("x "+ j.cantidadDePicosFinos());
        cantidadPicoFino.setStyle("-fx-font: 12 arial;");

        ImageView imgHerr1 = new ImageView(new Image("Vista/images/herramientas/hachaMadera.png",25,25, false, false));
        Button slotHachaMadera = new Button("", imgHerr1);

        ImageView imgHerr2 = new ImageView(new Image("Vista/images/herramientas/hachaPiedra.png",25,25, false, false));
        Button slotHachaPiedra = new Button("", imgHerr2);

        ImageView imgHerr3 = new ImageView(new Image("Vista/images/herramientas/hachaMetal.png",25,25, false, false));
        Button slotHachaMetal = new Button("", imgHerr3);

        ImageView imgHerr4 = new ImageView(new Image("Vista/images/herramientas/picoMadera.png",25,25, false, false));
        Button slotPicoMadera = new Button("", imgHerr4);

        ImageView imgHerr5 = new ImageView(new Image("Vista/images/herramientas/picoPiedra.png",25,25, false, false));
        Button slotPicoPiedra = new Button("", imgHerr5);

        ImageView imgHerr6 = new ImageView(new Image("Vista/images/herramientas/picoMetal.png",25,25, false, false));
        Button slotPicoMetal = new Button("", imgHerr6);

        ImageView imgHerr7 = new ImageView(new Image("Vista/images/herramientas/picoFino.png",25,25, false, false));
        Button slotPicoFino = new Button("", imgHerr7);


        getChildren().addAll(slotHachaMadera, cantidadHachaMadera, slotHachaPiedra, cantidadHachaPiedra,
        		slotHachaMetal, cantidadHachaMetal, slotPicoMadera, cantidadPicoMadera, slotPicoPiedra, cantidadPicoPiedra,
        		slotPicoMetal, cantidadPicoMetal, slotPicoFino, cantidadPicoFino);

    }

    private void setTitutloInventario(){
        Text herramientasTexto = new Text("Herramientas:");
        herramientasTexto.setStyle("-fx-font: 18 arial;");
        getChildren().add(herramientasTexto);
    }
}
