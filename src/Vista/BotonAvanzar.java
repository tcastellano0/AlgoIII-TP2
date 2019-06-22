package Vista;


import Juego.AlgoCraft;
import Juego.Jugador.Jugador;
import Juego.Jugador.Movimiento;
import javafx.scene.control.Button;

public class BotonAvanzar extends Button {

    public BotonAvanzar() {
        Jugador jugador = AlgoCraft.getInstancia().getJugador();
        Movimiento movimiento = AlgoCraft.getInstancia().getMovimiento();
        setText("Avanzar");
        setOnAction(actionEvent ->  {
            movimiento.avanzar(jugador);
        });
    }
}
