package Vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PreparadorEscenaJuego {

    protected VistaMapa vistaMapa;
    protected VBox menuDerecha;
    protected Scene escenaJuego;

    private static EscenaJuego escenaJuego = new EscenaJuego();
    public EscenaJuego getInstancia() {
        return escenaJuego;
    }

    private EscenaJuego(){

        this.vistaMapa = VistaMapa.getInstancia();
        this.menuDerecha = new VBox();
        menuDerecha.setSpacing(25);
        menuDerecha.setPadding(new Insets(10, 50, 50, 50));
        Text contructorTexto = new Text("Constructor");
        contructorTexto.setStyle("-fx-font: 24 arial;");
        menuDerecha.getChildren().add(contructorTexto);

        GridPane gridpane = new GridPane();
        gridpane.add(new Button(), 0, 0);
        gridpane.add(new Button(), 0, 1);
        gridpane.add(new Button(), 0, 2);
        gridpane.add(new Button(), 1, 0);
        gridpane.add(new Button(), 1, 1);
        gridpane.add(new Button(), 1, 2);
        gridpane.add(new Button(), 2, 0);
        gridpane.add(new Button(), 2, 1);
        gridpane.add(new Button(), 2, 2);

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



}
