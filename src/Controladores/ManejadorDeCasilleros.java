package Controladores;

import Vista.Casillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class ManejadorDeCasilleros implements EventHandler<ActionEvent> {
    Casillero casilleroManejado;
    public ManejadorDeCasilleros(Casillero casillero) {
        casilleroManejado=casillero;

    }
    public ManejadorDeCasilleros(Object p0) {


    }

    @Override
    public void handle(ActionEvent event) {
        casilleroManejado.setFill(Color.BLACK);
    }
}
