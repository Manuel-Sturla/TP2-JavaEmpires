package Juego;

import Exceptions.PosicionInvalidaException;
import Exceptions.UnidadesMaximasException;
import Jugador.Jugador;
import Mapa.Mapa;

import java.util.ArrayList;
import java.util.Arrays;

public class Juego {
    Jugador jugador1;
    Jugador jugador2;
    Mapa mapa;
    ControladorDeTurnos controlador;


    public void inicializarJuego() throws PosicionInvalidaException {
        mapa = new Mapa(40,30);
        jugador1 = new Jugador(mapa);
        jugador2 = new Jugador(mapa);
        jugador1.inicializarJugador(1);
        jugador2.inicializarJugador(2);
        controlador = new ControladorDeTurnos(
                new ArrayList<Jugador>(Arrays.asList(jugador1, jugador2)));
        jugador1.iniciarTurno();
    }

    public void iniciarPrimerTurno() throws PosicionInvalidaException {
        jugador1.iniciarTurno();
    }

    public ControladorDeTurnos getControladorDeTurnos(){
        return controlador;
    }

    public Mapa getMapa() {
        return mapa;
    }
}
