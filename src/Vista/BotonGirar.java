package Vista;

import Juego.AlgoCraft;
import Juego.Jugador.Movimiento;
import javafx.scene.control.Button;

public class BotonGirar extends Button {

    public BotonGirar() {
        Movimiento movimiento = AlgoCraft.getInstancia().getMovimiento();
        setText("Girar");
        setOnAction(actionEvent -> {
            movimiento.rotar();
        });
    }
}

