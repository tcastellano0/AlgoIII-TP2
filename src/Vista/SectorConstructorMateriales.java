package Vista;

import Juego.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class SectorConstructorMateriales extends VBox {

    Jugador jugador;

    public SectorConstructorMateriales(Jugador jugador) {
    	
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);
        
        Text materialesTituloTexto = new Text("Materiales:");
        materialesTituloTexto.setStyle("-fx-font: 24 arial;");
        getChildren().add(materialesTituloTexto);
        
        agregarPanelMadera(jugador.cantidadDeMaderas());
        agregarPanelPiedra(jugador.cantidadDePiedras());
        agregarPanelMetal(jugador.cantidadDeMetales());
        agregarPanelDiamante(jugador.cantidadDeDiamantes());
    }

    private void agregarPanelMadera(int cantidadMadera) {
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_madera.png",28,28,false,false)));

        Text maderaTexto = new Text("Madera: " + cantidadMadera);
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);

    }

    private void agregarPanelPiedra(int cantidadPiedras) {
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_piedra.png",28,28,false,false)));

        Text maderaTexto = new Text("Piedra: " + cantidadPiedras);
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);
    }

    private void agregarPanelMetal(int cantidadMetales) {
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_metal.png",28,28,false,false)));

        Text maderaTexto = new Text("Metal: " + cantidadMetales);
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);
    }

    private void agregarPanelDiamante(int cantidadDiamantes) {
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_diamante.png",28,28,false,false)));

        Text maderaTexto = new Text("Diamante: " + cantidadDiamantes);
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);
    }

}
