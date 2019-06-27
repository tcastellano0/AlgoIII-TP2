package Vista;

import Juego.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class SectorInventarioHerramientas extends HBox {

    private SectorHerramientaEquipada sectorHerramientaEquipada;
    private Text cantidadHachaMadera;
    private Text cantidadHachaPiedra;
    private Text cantidadHachaMetal;
    private Text cantidadPicoMadera;
    private Text cantidadPicoPiedra;
    private Text cantidadPicoMetal;
    private Text cantidadPicoFino;
    private Jugador j;

    public SectorInventarioHerramientas(Jugador j) {
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
                e -> {j.equiparHachaDeMadera();
                sectorHerramientaEquipada.actualizar();
                }
        );

        ImageView imgHerr2 = new ImageView(new Image("Vista/images/herramientas/hachaPiedra.png",25,25, false, false));
        Button slotHachaPiedra = new Button("", imgHerr2);
        slotHachaPiedra.setOnAction(
                e -> {j.equiparHachaDePiedra();
                    sectorHerramientaEquipada.actualizar();
                }
        );

        ImageView imgHerr3 = new ImageView(new Image("Vista/images/herramientas/hachaMetal.png",25,25, false, false));
        Button slotHachaMetal = new Button("", imgHerr3);
        slotHachaMetal.setOnAction(
                e -> {j.equiparHachaDeMetal();
                    sectorHerramientaEquipada.actualizar();
                }
        );

        ImageView imgHerr4 = new ImageView(new Image("Vista/images/herramientas/picoMadera.png",25,25, false, false));
        Button slotPicoMadera = new Button("", imgHerr4);
        slotPicoMadera.setOnAction(
                e -> {j.equiparPicoDeMadera();
                    sectorHerramientaEquipada.actualizar();
                }
        );

        ImageView imgHerr5 = new ImageView(new Image("Vista/images/herramientas/picoPiedra.png",25,25, false, false));
        Button slotPicoPiedra = new Button("", imgHerr5);
        slotPicoPiedra.setOnAction(
                e -> {j.equiparPicoDePiedra();
                    sectorHerramientaEquipada.actualizar();
                }
        );

        ImageView imgHerr6 = new ImageView(new Image("Vista/images/herramientas/picoMetal.png",25,25, false, false));
        Button slotPicoMetal = new Button("", imgHerr6);
        slotPicoMetal.setOnAction(
                e -> {j.equiparPicoDeMetal();
                sectorHerramientaEquipada.actualizar();}
        );


        ImageView imgHerr7 = new ImageView(new Image("Vista/images/herramientas/picoFino.png",25,25, false, false));
        Button slotPicoFino = new Button("", imgHerr7);
        slotPicoFino.setOnAction(
                e -> {j.equiparPicoFino();
                    sectorHerramientaEquipada.actualizar();
                }
        );

        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().addAll(slotHachaMadera, cantidadHachaMadera);
        
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(slotHachaPiedra, cantidadHachaPiedra);
        
        VBox vbox3 = new VBox();
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().addAll(slotHachaMetal, cantidadHachaMetal);
        
        VBox vbox4 = new VBox();
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().addAll(slotPicoMadera, cantidadPicoMadera);
        
        VBox vbox5 = new VBox();
        vbox5.setAlignment(Pos.CENTER);
        vbox5.getChildren().addAll(slotPicoPiedra, cantidadPicoPiedra);
        
        VBox vbox6 = new VBox();
        vbox6.setAlignment(Pos.CENTER);
        vbox6.getChildren().addAll(slotPicoMetal, cantidadPicoMetal);
        
        VBox vbox7 = new VBox();
        vbox7.setAlignment(Pos.CENTER);
        vbox7.getChildren().addAll(slotPicoFino, cantidadPicoFino);
        
        getChildren().addAll(vbox1 ,vbox2 ,vbox3 ,vbox4 ,vbox5 ,vbox6 ,vbox7);

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
        sectorHerramientaEquipada.actualizar();
    }
}
