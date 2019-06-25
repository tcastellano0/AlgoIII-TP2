package Vista;

import Herramientas.Herramienta;
import Juego.Jugador.Jugador;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class VistaHerramientaEquipada extends HBox {

    Jugador jugador;
    StackPane panelHerramienta;

    public VistaHerramientaEquipada (Jugador j){
        this.jugador = j;
        panelHerramienta = new StackPane();
        getChildren().add(panelHerramienta);
        actualizar();
    }

    public void actualizar(){
        Herramienta h = jugador.herramientaEquipada();

        //this.panelHerramienta.setBackground();

    }
}
