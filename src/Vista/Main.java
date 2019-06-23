package Vista;

import Juego.AlgoCraft;
import Juego.Jugador.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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
    	
    	VBox menuDerecha = new VBox();
    	menuDerecha.setSpacing(25);
    	menuDerecha.setPadding(new Insets(10, 50, 50, 50));
    	
    	Button slotMaterial1 = new Button();
    	Button slotMaterial2 = new Button();
    	Button slotMaterial3 = new Button();
    	Button slotMaterial4 = new Button();
    	Button slotMaterial5 = new Button();
    	Button slotMaterial6 = new Button();
    	Button slotMaterial7 = new Button();
    	Button slotMaterial8 = new Button();
    	Button slotMaterial9 = new Button();

    	Text contructorTexto = new Text("Constructor");
    	contructorTexto.setStyle("-fx-font: 24 arial;");
    	menuDerecha.getChildren().add(contructorTexto);
    	
    	GridPane gridpane = new GridPane();
    	gridpane.add(slotMaterial1, 0, 0);
    	gridpane.add(slotMaterial2, 0, 1);
    	gridpane.add(slotMaterial3, 0, 2);
    	gridpane.add(slotMaterial4, 1, 0);
    	gridpane.add(slotMaterial5, 1, 1);
    	gridpane.add(slotMaterial6, 1, 2);
    	gridpane.add(slotMaterial7, 2, 0);
    	gridpane.add(slotMaterial8, 2, 1);
    	gridpane.add(slotMaterial9, 2, 2);
    	
    	menuDerecha.getChildren().add(gridpane);
    	
    	Button limpiar = new Button("Limpiar");
    	Button crear = new Button("Crear");
    	HBox botonesLimpiarYCrearContenedor = new HBox();
    	botonesLimpiarYCrearContenedor.setSpacing(10);
    	botonesLimpiarYCrearContenedor.getChildren().addAll(limpiar, crear);
    	menuDerecha.getChildren().add(botonesLimpiarYCrearContenedor);
    	
    	
    	HBox menuInferior = new HBox();
    	menuInferior.setPadding(new Insets(10, 10, 10, 10));
    	menuInferior.setSpacing(25);
    	
    	Button slotHerramienta1 = new Button();
    	Button slotHerramienta2 = new Button();
    	Button slotHerramienta3 = new Button();
    	Button slotHerramienta4 = new Button();
    	Button slotHerramienta5 = new Button();
    	Button slotHerramienta6 = new Button();
    	Button slotHerramienta7 = new Button();
    		
    	Text herramientasTexto = new Text("Herramientas:");
    	herramientasTexto.setStyle("-fx-font: 18 arial;");
    	menuInferior.getChildren().add(herramientasTexto);
    	
    	menuInferior.getChildren().addAll(slotHerramienta1,slotHerramienta2,slotHerramienta3,slotHerramienta4,slotHerramienta5,slotHerramienta6,slotHerramienta7);
    	
    	BorderPane borderpane = new BorderPane();
    	borderpane.setRight(menuDerecha);
    	borderpane.setBottom(menuInferior);
    	borderpane.setCenter(VistaMapa.getInstancia());
    	
        escenaJuego = new Scene(borderpane);
        
        escenaJuego.setOnKeyPressed(key -> {
	            KeyCode keyCode = key.getCode();
	            
	            if(keyCode.equals(KeyCode.W)) {
	            	jugador.moverArriba();
	        	}
	    		if(keyCode.equals(KeyCode.S)) {
	    			jugador.moverAbajo();
	        	}
				if(keyCode.equals(KeyCode.A)) {
					jugador.moverIzquierda();
	        	}
				if(keyCode.equals(KeyCode.D)) {
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