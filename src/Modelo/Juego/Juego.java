package Modelo.Juego;

import Modelo.Exceptions.FinDelJuego;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.Mapa;

import java.util.ArrayList;
import java.util.Arrays;

public class Juego {
    Jugador jugador1;
    Jugador jugador2;
    Mapa mapa;
    ControladorDeTurnos controlador;


    public void inicializarJuego() throws PosicionInvalidaException, FinDelJuego {
        mapa = new Mapa(25,25);
        jugador1 = new Jugador(mapa);
        jugador2 = new Jugador(mapa);
        jugador1.inicializarJugador(1);
        jugador2.inicializarJugador(2);
        controlador = new ControladorDeTurnos(
                new ArrayList<Jugador>(Arrays.asList(jugador1, jugador2)));
    }

    public void iniciarPrimerTurno() throws PosicionInvalidaException, FinDelJuego {
        controlador.obtenerJugadorActual().iniciarTurno();
    }

    public ControladorDeTurnos getControladorDeTurnos(){
        return controlador;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Jugador getJugador1(){return jugador1;}
    public Jugador getJugador2(){return jugador2;}

}
