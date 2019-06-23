package Vista;

import Juego.AlgoCraft;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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
        Image imgVacio = new Image(EligeVistas.getInstance().vacio(), 35, 35, false, false);
    	VistaMapa vistaMapa = VistaMapa.getInstancia();


    	VBox menuDerecha = new VBox();
    	menuDerecha.setSpacing(25);
    	menuDerecha.setPadding(new Insets(10, 50, 50, 50));


    	Text contructorTexto = new Text("Constructor");
    	contructorTexto.setStyle("-fx-font: 24 arial;");
    	menuDerecha.getChildren().add(contructorTexto);
    	
        VistaConstructor vistaConstructor = new VistaConstructor();
    	
    	menuDerecha.getChildren().add(vistaConstructor);
    	
/*    	Button limpiar = new Button("Limpiar");
    	Button crear = new Button("Crear");
    	HBox botonesLimpiarYCrearContenedor = new HBox();
    	botonesLimpiarYCrearContenedor.setSpacing(10);
    	botonesLimpiarYCrearContenedor.getChildren().addAll(limpiar, crear);
    	menuDerecha.getChildren().add(botonesLimpiarYCrearContenedor);*/
    	
    	
    	HBox menuInferior = new HBox();
    	menuInferior.setPadding(new Insets(10, 10, 10, 10));
    	menuInferior.setSpacing(25);
    	
    	Button slotHerramienta1 = new Button("", new ImageView(imgVacio));
    	Button slotHerramienta2 = new Button("", new ImageView(imgVacio));
    	Button slotHerramienta3 = new Button("", new ImageView(imgVacio));
    	Button slotHerramienta4 = new Button("", new ImageView(imgVacio));
    	Button slotHerramienta5 = new Button("", new ImageView(imgVacio));
    	Button slotHerramienta6 = new Button("", new ImageView(imgVacio));
    	Button slotHerramienta7 = new Button("", new ImageView(imgVacio));
    		
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
	            	algoCraft.moverJugadorArriba();
	        	}
	    		
	            if(keyCode.equals(KeyCode.S)) {
	    			algoCraft.moverJugadorAbajo();
	        	}
				
	    		if(keyCode.equals(KeyCode.A)) {
					algoCraft.moverJugadorIzquierda();
	        	}
				
				if(keyCode.equals(KeyCode.D)) {
					algoCraft.moverJugadorDerecha();
	        	}
				
				if(keyCode.equals(KeyCode.G)) {
					algoCraft.golpearMaterialSiguiente();
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

        Image titleBackground = new Image("Vista/images/menu/title.png", 1200, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));

        window.setScene(scene);
    }

}