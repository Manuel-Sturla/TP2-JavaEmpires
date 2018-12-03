package PruebasIntegracion;

import Exceptions.PosicionInvalidaException;
import Juego.Juego;
import Jugador.Jugador;
import Mapa.Mapa;
import org.junit.jupiter.api.Test;
import Juego.ControladorDeTurnos;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebasTurnos {

    @Test
    void elPrimerJugadorEsUnoDeLosPosibles() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(50,50);
        Jugador jugador1 = new Jugador(mapa);
        Jugador jugador2 = new Jugador(mapa);
        ArrayList jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ArrayList jugadoresCopia = new ArrayList(jugadores);
        jugador1.inicializarJugador(1);
        jugador2.inicializarJugador(2);
        ControladorDeTurnos controlador = new ControladorDeTurnos(jugadores);
        assertTrue(jugadoresCopia.contains(controlador.obtenerJugadorActual()));
    }

    @Test
    void jugador1TerminaTurnoEntoncesVaJugador2() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(50,50);

        Jugador jugador1 = new Jugador(mapa);
        Jugador jugador2 = new Jugador(mapa);
        jugador1.inicializarJugador(1);
        jugador2.inicializarJugador(2);
        ArrayList jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ArrayList jugadoresCopia = new ArrayList(jugadores);
        ControladorDeTurnos controlador = new ControladorDeTurnos(jugadores);

        Jugador jugadorPrimerTurno = controlador.obtenerJugadorActual();
        jugadorPrimerTurno.iniciarTurno();
        jugadorPrimerTurno.terminarTurno();
        assertTrue(controlador.obtenerJugadorActual() != jugadorPrimerTurno);
        assertTrue(jugadoresCopia.contains(controlador.obtenerJugadorActual()));
    }

    @Test
    void losJugadoresSeAlternanEnCadaTurno() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(50,50);
        Jugador jugador1 = new Jugador(mapa);
        Jugador jugador2 = new Jugador(mapa);
        jugador1.inicializarJugador(1);
        jugador2.inicializarJugador(2);
        ArrayList <Jugador>jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ControladorDeTurnos controlador = new ControladorDeTurnos(jugadores);

        Jugador jugadorActual = controlador.obtenerJugadorActual();
        for (int i = 0; i<10; i++){
            jugadorActual.iniciarTurno();
            jugadorActual.terminarTurno();
            Jugador jugadorSiguiente = controlador.obtenerJugadorActual();
            assertNotEquals(jugadorActual, jugadorSiguiente);
            jugadorActual = jugadorSiguiente;
        }
    }

    @Test
    void iniciarJuegoEIniciarElPrimerTurnoInicianAlosJugadoresYUnTurno() throws PosicionInvalidaException {

        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.iniciarPrimerTurno();

        ControladorDeTurnos controlador = juego.getControladorDeTurnos();
        assertTrue(controlador.obtenerJugadorActual()!= null);

    }
}
