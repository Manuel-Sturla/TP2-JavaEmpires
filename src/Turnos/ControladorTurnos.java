package Turnos;

import Jugador.Jugador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

public class ControladorTurnos {
    LinkedList<Jugador> colaTurnos;


    public ControladorTurnos(ArrayList<Jugador> jugadores){
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
}
