package Vista;

import Juego.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class SectorConstructorMateriales extends VBox {

    private Jugador jugador;
    
    private Text txtMadera;
    private Text txtPiedra;
    private Text txtMetal;
    private Text txtDiamante;

    public SectorConstructorMateriales(Jugador jugador) {

    	this.jugador = jugador;
    	
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);

        Text materialesTituloTexto = new Text("Materiales:");
        materialesTituloTexto.setStyle("-fx-font: 24 arial;");
        getChildren().add(materialesTituloTexto);
        
        txtMadera = new Text(); 
        txtMadera.setText("Madera: " + jugador.cantidadDeMaderas());
        txtMadera.setStyle("-fx-font: 20 arial;");
        
        txtPiedra = new Text(); 
        txtPiedra.setText("Piedra: " + jugador.cantidadDePiedras());
        txtPiedra.setStyle("-fx-font: 20 arial;");
        
        txtMetal = new Text(); 
        txtMetal.setText("Metal: " + jugador.cantidadDeMetales());
        txtMetal.setStyle("-fx-font: 20 arial;");
        
        txtDiamante = new Text(); 
        txtDiamante.setText("Diamante: " + jugador.cantidadDeDiamantes());
        txtDiamante.setStyle("-fx-font: 20 arial;");
        
        agregarPanelDeMaterial(txtMadera, "Vista/images/MaterialesPanelConstruccion/cons_madera.png");
        agregarPanelDeMaterial(txtPiedra, "Vista/images/MaterialesPanelConstruccion/cons_piedra.png");
        agregarPanelDeMaterial(txtMetal, "Vista/images/MaterialesPanelConstruccion/cons_metal.png");
        agregarPanelDeMaterial(txtDiamante, "Vista/images/MaterialesPanelConstruccion/cons_diamante.png");
    }

    private void agregarPanelDeMaterial(Text txtMaterial, String srcImagen) {
        HBox panelH = new HBox();
        panelH.setSpacing(10);
        StackPane panelImagen = new StackPane();
        panelImagen.getChildren().add(new ImageView(new Image(srcImagen,28,28,false,false)));

        panelH.getChildren().addAll(panelImagen, txtMaterial);
        getChildren().add(panelH);
    }
    
    public void actualizar() {
        this.txtMadera.setText("Madera: " + this.jugador.cantidadDeMaderas());
        this.txtPiedra.setText("Piedra: " + this.jugador.cantidadDePiedras());
        this.txtMetal.setText("Metal: " + this.jugador.cantidadDeMetales());
        this.txtDiamante.setText("Diamante: " + this.jugador.cantidadDeDiamantes());
    }

}
