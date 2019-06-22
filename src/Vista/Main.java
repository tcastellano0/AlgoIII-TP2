package Vista;

import Juego.AlgoCraft;
import Juego.Jugador.Jugador;
import Juego.Mapa.Posicion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene escenaJuego;
    Button empezarJuego;
    Button salir;
    AlgoCraft algoCraft;
    Jugador jugador = AlgoCraft.getInstancia().getJugador();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        this.prepararMenuInicio();
        this.prepararMapa();

        window.show();
    }

    public void prepararMapa() {

/*        HBox botones = new HBox();
        botones.getChildren().addAll(new BotonAvanzar(), new BotonGirar());
        VBox pantalla = new VBox();
        pantalla.getChildren().addAll(botones,VistaMapa.getInstancia());*/
    	
    	VistaMapa vistaMapa = VistaMapa.getInstancia();
    	
        escenaJuego = new Scene(vistaMapa);
        
        //Posicion posicionInicial = jugador.getPosicion();
        
        escenaJuego.setOnKeyPressed(key -> {
	            KeyCode keyCode = key.getCode();
	            
	            if(keyCode.equals(KeyCode.UP)) {
	            	jugador.moverArriba();
	        	}
	    		if(keyCode.equals(KeyCode.DOWN)) {
	    			jugador.moverAbajo();
	        	}
				if(keyCode.equals(KeyCode.LEFT)) {
					jugador.moverIzquierda();
	        	}
				if(keyCode.equals(KeyCode.RIGHT)) {
					jugador.moverDerecha();
	        	}
				
				vistaMapa.actualizar();
			}
		);
    }

    public void prepararMenuInicio() {
        window.setTitle("AlgoCraft");
        window.setMaxHeight(800);
        window.setMinHeight(800);
        window.setMaxWidth(1200);
        window.setMinWidth(1200);


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

        Image titleBackground = new Image("Vista/images/menu/title.png", 1200, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));

        window.setScene(scene);
    }

}