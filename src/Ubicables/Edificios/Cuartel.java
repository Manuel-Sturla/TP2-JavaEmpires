package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;

public class Cuartel extends Edificios {

    public Cuartel(Posicion posicionCostruccion) throws PosicionFueraDeRangoException {
        super(posicionCostruccion, 250, 2);
        estado = new Ocupado(3);
    }

    public Cuartel(Posicion posicionCostruccion, Faccion faccionRecibida) throws PosicionFueraDeRangoException {
        super(posicionCostruccion, 250, 2);
        estado = new Ocupado(3);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }

}
