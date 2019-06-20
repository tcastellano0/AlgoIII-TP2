import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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

        window.setScene(scene);
        window.show();
    }


}