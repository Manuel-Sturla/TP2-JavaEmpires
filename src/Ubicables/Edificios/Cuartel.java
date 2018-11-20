package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Tablero.Posicion;
import Turnos.Ocupado;

public class Cuartel extends Edificios {

    public Cuartel(Posicion posicionCostruccion) throws PosicionFueraDeRangoException {
        super(posicionCostruccion, 250, 2);
        estado = new Ocupado(3);
    }

}
