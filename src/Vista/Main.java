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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.Random;


public class Main extends Application {

    Stage window;
    Scene escenaJuego;
    AlgoCraft algoCraft = AlgoCraft.getInstancia();
    MediaPlayer mediaPlayer;
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        this.ponerMusicaDeFondo();
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

        VistaInventarioHerramientas herramientas = new VistaInventarioHerramientas(algoCraft.getJugador());
    	BorderPane borderpane = new BorderPane();
    	borderpane.setRight(menuDerecha);
    	borderpane.setBottom(herramientas);
    	borderpane.setCenter(vistaMapa);
    	
        escenaJuego = new Scene(borderpane);
        
        escenaJuego.setOnKeyPressed(key -> {
	            KeyCode keyCode = key.getCode();
	            
	            if(keyCode.equals(KeyCode.W)) {
                    EligeRutaImagenes.getInstance().jugadorMiraArriba();
                    ponerSonidoPisar();
                    algoCraft.moverJugadorArriba();
	        	}
	    		
	            if(keyCode.equals(KeyCode.S)) {
                    EligeRutaImagenes.getInstance().jugadorMiraAbajo();
                    ponerSonidoPisar();
	    			algoCraft.moverJugadorAbajo();
	        	}
				
	    		if(keyCode.equals(KeyCode.A)) {
                    EligeRutaImagenes.getInstance().jugadorMiraIzquierda();
                    ponerSonidoPisar();
					algoCraft.moverJugadorIzquierda();
	        	}
				
				if(keyCode.equals(KeyCode.D)) {
                    EligeRutaImagenes.getInstance().jugadorMiraDerecha();
                    ponerSonidoPisar();
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
    
    public void ponerMusicaDeFondo() {
    	String musicFile = "src/Sonidos/Minecraft Background Music.mp3";     

    	Media sound = new Media(new File(musicFile).toURI().toString());
    	this.mediaPlayer = new MediaPlayer(sound);
    	this.mediaPlayer.play();
    	
    }
    
    public void ponerSonidoPisar() {
    	String musicFile1 = "src/Sonidos/pisa1.mp3";  
    	String musicFile2 = "src/Sonidos/pisa2.mp3";
    	String musicFile3 = "src/Sonidos/pisa3.mp3";
    	String[] sonidos = {musicFile1, musicFile2, musicFile3};
    	
    	Random rand = new Random();
    	int n = rand.nextInt(3);

    	Media sound = new Media(new File(sonidos[n]).toURI().toString());
    	MediaPlayer mediaPlayerParaPisar = new MediaPlayer(sound);
    	mediaPlayerParaPisar.play();
    }

}