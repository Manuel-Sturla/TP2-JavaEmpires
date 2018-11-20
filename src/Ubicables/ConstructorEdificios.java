package Ubicables;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Ubicables.Edificios.PlazaCentral;

public class ConstructorEdificios {

    Jugador jugador;

    public ConstructorEdificios(Jugador jugadorRecibido) {
        jugador = jugadorRecibido;
    }


    public void consturirPlazaCentral(Posicion posicionAldeano, Posicion posicionCostruccion) throws NoSePudoConstruirException, PosicionFueraDeRangoException {
        PosicionEdificio posicionEdificio = new PosicionEdificio(posicionCostruccion,2);
        if(!posicionAldeano.estaEnRango(posicionEdificio)) throw new PosicionFueraDeRangoException();
        PlazaCentral plazaCentral = new PlazaCentral(posicionCostruccion);
        jugador.agregar(plazaCentral);
    }
}
