package Modelo.Juego;

import Modelo.Exceptions.FinDelJuego;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Jugador.Jugador;

import java.util.*;

public class ControladorDeTurnos extends Observable implements Observer {
    static ControladorDeTurnos controladorDeTurnos;
    LinkedList<Jugador> colaTurnos;


    public ControladorDeTurnos(ArrayList<Jugador> jugadores) throws FinDelJuego {
        Random random = new Random();
        int jugadorInicial = random.nextInt(2);
        ControladorDeTurnos controladorDeTurnos = this;
        colaTurnos = new LinkedList<Jugador>();
        Jugador jugador = jugadores.remove(jugadorInicial);
        jugador.addObserver(this);
        colaTurnos.add(jugador);
        Jugador jugador2 = jugadores.remove(0);
        colaTurnos.add(jugador2);
        jugador2.terminarTurno();
        jugador2.addObserver(this);

    }


    public Jugador obtenerJugadorActual() {
        return colaTurnos.peekFirst();
    }

    public Jugador siguienteTurno() {
        Jugador jugadorActual = colaTurnos.removeFirst();
        colaTurnos.add(jugadorActual);
        return colaTurnos.peekFirst();
    }

    @Override
    public void update(Observable o, Object arg) {
        Jugador jugadorTurnoActual = siguienteTurno();
        try {
            jugadorTurnoActual.iniciarTurno();
        } catch (PosicionInvalidaException e) {

        } catch (FinDelJuego finDelJuego) {
            notifyObservers();
        }
    }
}
