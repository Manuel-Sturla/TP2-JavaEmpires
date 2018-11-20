package Ubicables;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Ubicables.Edificios.PlazaCentral;

public class CostructorEdificios {

    Jugador jugador;

    public CostructorEdificios(Jugador jugadorRecivido) {
        jugador = jugadorRecivido;
    }


    public void consturirPlazaCentral(Posicion posicionAldeano, Posicion posicionCostruccion) throws NoSePudoConstruirException, PosicionFueraDeRangoException {
        PosicionEdificio posicionEdificio = new PosicionEdificio(posicionCostruccion,2);
        if(!posicionAldeano.estaArango(posicionEdificio)) throw new PosicionFueraDeRangoException();
        PlazaCentral plazaCentral = new PlazaCentral(posicionCostruccion);
        jugador.agregar(plazaCentral);
    }
}
