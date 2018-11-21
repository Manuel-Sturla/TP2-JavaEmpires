package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;

public class PlazaCentral extends Edificios {
    Faccion faccion;

    public PlazaCentral(Posicion posicionAldeano, Faccion faccionRecibida) throws PosicionFueraDeRangoException {
        super(posicionAldeano,450,2);
        estado = new Ocupado(3);
        faccion = faccionRecibida;
    }


    public void crearAldeano() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);

    }

}
