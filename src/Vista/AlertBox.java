package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertBox {
	
	public static void mostrar(String mensaje) {
		
		Stage window = new Stage();
		window.setTitle("Error");
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(mensaje);
		Button botonCerrar = new Button("Cerrar");
		botonCerrar.setOnAction(e -> window.close());
		
		VBox layout= new VBox(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.getChildren().addAll(label, botonCerrar);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	

}
