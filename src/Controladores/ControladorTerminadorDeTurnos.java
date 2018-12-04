package Controladores;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Juego.ControladorDeTurnos;
import Modelo.Jugador.Jugador;
import Vista.PanelSuperior;
import Vista.PantallaDelJuego;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorTerminadorDeTurnos extends Button implements EventHandler<ActionEvent> {

    ControladorDeTurnos controladorDeTurnos;
    public ControladorTerminadorDeTurnos(ControladorDeTurnos controladorDeTurnosRecivido){
        controladorDeTurnos = controladorDeTurnosRecivido;
    }

    @Override
    public void handle(ActionEvent event) {
        Jugador jugadorActual= controladorDeTurnos.obtenerJugadorActual();
        jugadorActual.terminarTurno();
        
        PantallaDelJuego.actualizarPantallaSuperior();
    }
}
