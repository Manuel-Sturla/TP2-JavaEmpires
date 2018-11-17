package Turnos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControladorDeTurnosTests {
/*
    @Test
    void elPrimerJugadorEsElJugador1(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.inicializarJugador();
        jugador2.inicializaJugador();
        ControladorDeTurnos controlador = new ControladorDeTurnos(jugador1, jugador2);
        assertTrue(controlador.obtenerJugadorActual() = jugador1);
    }

    @Test
    void jugador1TerminaTurnoEntoncesVaJugador2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.inicializarJugador();
        jugador2.inicializaJugador();
        ControladorDeTurnos controlador = new ControladorDeTurnos(jugador1, jugador2);
        jugador1.finalizarTurno();

        assertTrue(controlador.obtenerJugadorActual() = jugador2);
    }
/*
    @Test
    void losJugadoresSeAlternanCorrectamente(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
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
