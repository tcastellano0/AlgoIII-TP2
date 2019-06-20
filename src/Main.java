import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Button empezarJuego;
    Button salir;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("AlgoCraft");
        window.setMaxHeight(600);
        window.setMinHeight(600);
        window.setMaxWidth(800);
        window.setMinWidth(800);

        
        empezarJuego = new Button("Empezar Juego");
        salir = new Button("Salir");

        StackPane layout = new StackPane();
        layout.getChildren().add(empezarJuego);
        Scene scene = new Scene(layout, 300, 250);

        Image titleBackground = new Image("images/menu/title.png",800,600, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));

        window.setScene(scene);
        window.show();
    }



}