package Vista;

import Modelo.Juego.ControladorDeTurnos;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class PantallaFinJuego implements Observer {
    Stage ventana;

    public PantallaFinJuego(Stage ventanaRecibida){
        ventana = ventanaRecibida;
    }

    @Override
    public void update(Observable o, Object arg) {
        ventana.setScene(crearPantallaFinJuego());
    }

    private Scene crearPantallaFinJuego() {
        Button cerrarJuego = new Button("Has ganado!!");
        cerrarJuego.setOnAction(e -> Platform.exit());
        StackPane layout = new StackPane();
        layout.getChildren().add(cerrarJuego);
        Scene escenaFinal = new Scene(layout, 300, 300);
        return escenaFinal;
    }

    public void agregarControlador(ControladorDeTurnos controladorDeTurnos) {
        controladorDeTurnos.addObserver(this);
    }
}
