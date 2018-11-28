package Ubicables.Edificios;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Ubicables.Ubicable;

public class Castillo extends Edificios {
    Faccion faccion;

    public Castillo(Posicion posicionInicial, Faccion faccionRecibida) throws PosicionFueraDeRangoException, NoSePudoConstruirException, PosicionNoDisponibleException {
        super(posicionInicial,1000,4);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }


    @Override
    public boolean estaMuerto() {
        return vidaActual < 1;
    }

    @Override
    public void recibirDanio(int danioRecibido) {
        vidaActual -= danioRecibido;
    }
}