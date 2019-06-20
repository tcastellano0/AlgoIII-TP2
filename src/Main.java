import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Button empezarJuego;
    Button salir;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        this.prepararMenuInicio();

        window.show();
    }

    public void prepararMenuInicio(){
        window.setTitle("AlgoCraft");
        window.setMaxHeight(600);
        window.setMinHeight(600);
        window.setMaxWidth(800);
        window.setMinWidth(800);


        empezarJuego = new Button("Empezar Juego");
        empezarJuego.setOnAction(this);
        salir = new Button("Salir");
        salir.setOnAction(this);

        BorderPane layout = new BorderPane();
        VBox vertical = new VBox(8 );
        vertical.getSpacing();
        vertical.getChildren().add(empezarJuego);
        vertical.getChildren().add(salir);
        vertical.setAlignment(Pos.CENTER);

        layout.setCenter(vertical);
        Scene scene = new Scene(layout, 300, 250);

        Image titleBackground = new Image("images/menu/title.png",800,600, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));

        window.setScene(scene);
    }

    //When button is clicked, handle() gets called
    //Button click is an ActionEvent (also MouseEvents, TouchEvents, etc...)
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == empezarJuego)
            System.out.println("Todavia en desarrollo.");
        if (event.getSource() == salir)
            System.exit(0);;
    }

}