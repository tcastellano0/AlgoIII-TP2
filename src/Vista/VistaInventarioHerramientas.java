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

    private SectorHerramientaEquipada sectorHerramientaEquipada;
    private Text cantidadHachaMadera;
    private Text cantidadHachaPiedra;
    private Text cantidadHachaMetal;
    private Text cantidadPicoMadera;
    private Text cantidadPicoPiedra;
    private Text cantidadPicoMetal;
    private Text cantidadPicoFino;
    private Jugador j;

    public VistaInventarioHerramientas(Jugador j) {
        this.j = j;
        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(10);
        setTitutloEquipada();
        agregarSectorHerramientaEquipada();
        setTitutloInventario();
        agregarBotonesHerramientas(j);
        actualizar();
    }

    private void setTitutloEquipada(){
        Text herramientasTexto = new Text("Herramienta\nequipada");
        herramientasTexto.setTextAlignment(TextAlignment.CENTER);
        herramientasTexto.setStyle("-fx-font: 18 arial;");

        getChildren().add(herramientasTexto);
    }


    private void agregarSectorHerramientaEquipada (){
        sectorHerramientaEquipada = new SectorHerramientaEquipada(j);
        getChildren().add(sectorHerramientaEquipada);
    }

    private void agregarBotonesHerramientas(Jugador j){
        cantidadHachaMadera = new Text();
        cantidadHachaMadera.setStyle("-fx-font: 12 arial;");
        
        cantidadHachaPiedra = new Text();
        cantidadHachaPiedra.setStyle("-fx-font: 12 arial;");
        
        cantidadHachaMetal = new Text();
        cantidadHachaMetal.setStyle("-fx-font: 12 arial;");
        
        cantidadPicoMadera = new Text();
        cantidadPicoMadera.setStyle("-fx-font: 12 arial;");
        
        cantidadPicoPiedra = new Text();
        cantidadPicoPiedra.setStyle("-fx-font: 12 arial;");
        
        cantidadPicoMetal = new Text();
        cantidadPicoMetal.setStyle("-fx-font: 12 arial;");
        
        cantidadPicoFino = new Text();
        cantidadPicoFino.setStyle("-fx-font: 12 arial;");

        ImageView imgHerr1 = new ImageView(new Image("Vista/images/herramientas/hachaMadera.png",25,25, false, false));
        Button slotHachaMadera = new Button("", imgHerr1);
        slotHachaMadera.setOnAction(
                e -> j.equiparHachaDeMadera()
        );

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
        slotPicoMetal.setOnAction(
                e -> {j.equiparPicoDeMetal();
                sectorHerramientaEquipada.actualizar();}
        );

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

    public void actualizar(){
        cantidadHachaMadera.setText("x " + j.cantidadDeHachasDeMadera());
        cantidadHachaPiedra.setText("x " + j.cantidadDeHachasDePiedra());
        cantidadHachaMetal.setText("x " + j.cantidadDeHachasDeMetal());
        cantidadPicoMadera.setText("x " + j.cantidadDePicosDeMadera());
        cantidadPicoPiedra.setText("x " + j.cantidadDePicosDePiedra());
        cantidadPicoMetal.setText("x " + j.cantidadDePicosDeMetal());
        cantidadPicoFino.setText("x " + j.cantidadDePicosFinos());

    }
}
