package Turnos;

import Jugador.Jugador;
import org.junit.jupiter.api.Test;
import Jugador.Faccion;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControladorDeTurnosTests {

    @Test
    void elPrimerJugadorEsUnoDeLosPosibles(){
        ArrayList ubicables = new ArrayList();
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Jugador jugador1 = new Jugador(ubicables, faccion1);
        Jugador jugador2 = new Jugador(ubicables, faccion2);
        ArrayList jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ArrayList jugadoresCopia = new ArrayList(jugadores);
        ControladorTurnos controlador = new ControladorTurnos(jugadores);
        assertTrue(jugadoresCopia.contains(controlador.obtenerJugadorActual()));
    }

    @Test
    void jugador1TerminaTurnoEntoncesVaJugador2(){
        ArrayList ubicables = new ArrayList();
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Jugador jugador1 = new Jugador(ubicables, faccion1);
        Jugador jugador2 = new Jugador(ubicables, faccion2);
        ArrayList jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ControladorTurnos controlador = new ControladorTurnos(jugadores);

        Jugador jugadorPrimerTurno = controlador.obtenerJugadorActual();
        controlador.siguienteTurno();
        assertTrue(controlador.obtenerJugadorActual() != jugadorPrimerTurno);
    }
/*
    @Test
    void losJugadoresSeAlternanCorrectamente(){
          ArrayList ubicables = new ArrayList();
        Faccion faccion1 = new Faccion();
        Faccion faccion2 = new Faccion();
        Jugador jugador1 = new Jugador(ubicables, faccion1);
        Jugador jugador2 = new Jugador(ubicables, faccion2);
        jugador1.inicializarJugador();
        jugador2.inicializaJugador();
        ControladorDeTurnos controlador = new ControladorDeTurnos(jugador1, jugador2);

        boolean check = true;
        Jugador jugadorActual = jugador1;
        for (int i=1; i < 15; i++){
            if (controlador.obtenerJugadorActual() != jugadorActual){
                check = false;
            }
            jugadorActual.finalizarTurno();
            jugadorActual // FALTA ALTERNAR LOS JUGADORES
        }
        return check
    }
*/
}
