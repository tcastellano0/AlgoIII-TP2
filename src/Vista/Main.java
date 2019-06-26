package Vista;

import Juego.AlgoCraft;
import javafx.application.Application;
import javafx.geometry.Insets;
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
    AlgoCraft algoCraft = AlgoCraft.getInstancia();

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
    	VistaMapa vistaMapa = VistaMapa.getInstancia();

    	VBox menuDerecha = new VBox();
    	menuDerecha.setSpacing(25);
    	menuDerecha.setPadding(new Insets(10, 50, 50, 50));

        SectorConstructor sectorConstructor = new SectorConstructor(algoCraft.getJugador());
    	menuDerecha.getChildren().add(sectorConstructor);

        VistaInventarioHerramientas herramientas = new VistaInventarioHerramientas();
    	BorderPane borderpane = new BorderPane();
    	borderpane.setRight(menuDerecha);
    	borderpane.setBottom(herramientas);
    	borderpane.setCenter(vistaMapa);
    	
        escenaJuego = new Scene(borderpane);
        
        escenaJuego.setOnKeyPressed(key -> {
	            KeyCode keyCode = key.getCode();
	            
	            if(keyCode.equals(KeyCode.W)) {
                    EligeVistas.getInstance().jugadorMiraArriba();
                    algoCraft.moverJugadorArriba();
	        	}
	    		
	            if(keyCode.equals(KeyCode.S)) {
                    EligeVistas.getInstance().jugadorMiraAbajo();
	    			algoCraft.moverJugadorAbajo();
	        	}
				
	    		if(keyCode.equals(KeyCode.A)) {
                    EligeVistas.getInstance().jugadorMiraIzquierda();
					algoCraft.moverJugadorIzquierda();
	        	}
				
				if(keyCode.equals(KeyCode.D)) {
                    EligeVistas.getInstance().jugadorMiraDerecha();
					algoCraft.moverJugadorDerecha();
	        	}
				
				if(keyCode.equals(KeyCode.G)) {
					algoCraft.golpearMaterialSiguiente();
					
					sectorConstructor.actualizar();
	        	}
				
				
				vistaMapa.actualizar();
			}
		);
    }

    public void prepararMenuInicio() {
        window.setTitle("AlgoCraft");
        window.setMaxHeight(800);
        window.setMinHeight(800);
        window.setMaxWidth(950);
        window.setMinWidth(950);

        Button empezarJuego = new Button("Empezar Juego");
        Button salir = new Button("Salir");
        
        empezarJuego.setOnAction(e -> window.setScene(escenaJuego));
        salir.setOnAction(e -> System.exit(0));

        BorderPane layout = new BorderPane();
        VBox vertical = new VBox(8);
        vertical.getSpacing();
        vertical.getChildren().add(empezarJuego);
        vertical.getChildren().add(salir);
        vertical.setAlignment(Pos.CENTER);

        layout.setCenter(vertical);
        Scene scene = new Scene(layout, 300, 250);

        Image titleBackground = new Image("Vista/images/menu/title.png", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));

        window.setScene(scene);
    }

}