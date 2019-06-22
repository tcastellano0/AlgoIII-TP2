package Vista;

import Juego.AlgoCraft;
import Juego.Mapa.Posicion;
import Juego.Mapa.Tablero;
import Juego.Mapa.Ubicable;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene escenaJuego;
    Button empezarJuego;
    Button salir;
    AlgoCraft algoCraft;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        this.prepararMapa();
        this.prepararMenuInicio();

        window.show();
    }

    public void prepararMapa() {
        GridPane vistaMapa = new GridPane();
        Tablero<Ubicable> mapa = AlgoCraft.getInstancia().getMapa();
        int filas = mapa.getFilas();
        int columnas = mapa.getColumnas();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                try {
                    String clase = String.valueOf((mapa.ver(new Posicion(i + 1, j + 1)).getClass()));
                    System.out.println(clase);
                    Image fondo = null;
                    switch (clase) {
                        case "class Juego.Jugador.Jugador":
                            fondo = new Image("Vista/images/menu/jugador.jpg", 25, 25, false, true);
                            break;
                        case "class Materiales.Madera":
                            fondo = new Image("Vista/images/menu/madera.jpg", 25, 25, false, true);
                            break;
                        case "class Materiales.Piedra":
                            fondo = new Image("Vista/images/menu/piedra.jpg", 25, 25, false, true);
                            break;
                        case "class Materiales.Metal":
                            fondo = new Image("Vista/images/menu/metal.jpg", 25, 25, false, true);
                            break;
                        case "class Materiales.Diamante":
                            fondo = new Image("Vista/images/menu/diamante.jpg", 25, 25, false, true);
                            break;
                    }
                    ImageView iw = new ImageView(fondo);
                    Button boton = new Button("", iw);
                    vistaMapa.add(boton, i, j);
                } catch (NullPointerException e) {
                    Image fondo = new Image("Vista/images/menu/pasto.jpg", 25, 25, false, true);
                    ImageView iw = new ImageView(fondo);
                    Button boton = new Button("",iw);
                    vistaMapa.add(boton, i, j);
                }

            }
        }
        escenaJuego = new Scene(vistaMapa);
    }

    public void prepararMenuInicio() {
        window.setTitle("AlgoCraft");
        window.setMaxHeight(600);
        window.setMinHeight(600);
        window.setMaxWidth(800);
        window.setMinWidth(800);


        empezarJuego = new Button("Empezar Juego");
        empezarJuego.setOnAction(e -> window.setScene(escenaJuego));
        salir = new Button("Salir");
        salir.setOnAction(e -> System.exit(0));

        BorderPane layout = new BorderPane();
        VBox vertical = new VBox(8);
        vertical.getSpacing();
        vertical.getChildren().add(empezarJuego);
        vertical.getChildren().add(salir);
        vertical.setAlignment(Pos.CENTER);

        layout.setCenter(vertical);
        Scene scene = new Scene(layout, 300, 250);

        Image titleBackground = new Image("Vista/images/menu/title.png", 800, 600, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));

        window.setScene(scene);
    }

}