package Vista;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class SectorConstructorMateriales extends VBox {

    protected SectorConstructor padre;

    public SectorConstructorMateriales(SectorConstructor sectorConstructor){
        this.padre = sectorConstructor;
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);
        Text materialesTituloTexto = new Text("Materiales:");
        materialesTituloTexto.setStyle("-fx-font: 24 arial;");
        getChildren().add(materialesTituloTexto);
        agregarPanelMadera();
        agregarPanelPiedra();
        agregarPanelMetal();
        agregarPanelDiamante();
        agregarIngresoParaConstruccion();
    }

    private void agregarPanelMadera(){
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_madera.png",28,28,false,false)));

        Text maderaTexto = new Text("Madera: ");
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);

    }

    private void agregarPanelPiedra(){
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_piedra.png",28,28,false,false)));

        Text maderaTexto = new Text("Piedra: ");
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);
    }

    private void agregarPanelMetal(){
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_metal.png",28,28,false,false)));

        Text maderaTexto = new Text("Metal: ");
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);
    }

    private void agregarPanelDiamante(){
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image("Vista/images/MaterialesPanelConstruccion/cons_diamante.png",28,28,false,false)));

        Text maderaTexto = new Text("Diamante: ");
        maderaTexto.setStyle("-fx-font: 20 arial;");

        panelH.getChildren().addAll(panelImagen, maderaTexto);
        getChildren().add(panelH);
    }

    private void agregarIngresoParaConstruccion(){
        TextField filaField = new TextField();

        filaField.setPrefHeight(40);
        getChildren().add(filaField);


    }

}
