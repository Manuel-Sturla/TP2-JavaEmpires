import Exceptions.PosicionInvalidaException;
import Jugador.Jugador;

import java.util.*;

public class ControladorDeTurnos implements Observer {

    LinkedList<Jugador> colaTurnos;


    public ControladorDeTurnos(ArrayList<Jugador> jugadores){
        Random random = new Random();
        int jugadorInicial = random.nextInt(2);
        colaTurnos = new LinkedList<Jugador>();
        colaTurnos.add(jugadores.remove(jugadorInicial));
        colaTurnos.add(jugadores.remove(0));
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

        }
    }
}
