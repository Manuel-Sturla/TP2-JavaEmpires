package Controladores;

import Exceptions.FinDelJuegoException;
import Modelo.Exceptions.FinDelJuego;
import Modelo.Juego.ControladorDeTurnos;
import Modelo.Jugador.Jugador;
import Vista.PantallaDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorTerminadorDeTurnos extends Button implements EventHandler<ActionEvent> {

    ControladorDeTurnos controladorDeTurnos;
    public ControladorTerminadorDeTurnos(ControladorDeTurnos controladorDeTurnosRecibido){
        controladorDeTurnos = controladorDeTurnosRecibido;
    }

    @Override
    public void handle(ActionEvent event) {
        Jugador jugadorActual = controladorDeTurnos.obtenerJugadorActual();
        jugadorActual.terminarTurno();
        PantallaDelJuego.actualizarPantallaSuperior();
    }
}
