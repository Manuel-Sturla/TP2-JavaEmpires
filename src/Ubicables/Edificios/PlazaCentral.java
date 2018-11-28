package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Ocupado;
import Ubicables.Unidades.Aldeano;

public class PlazaCentral extends Edificios {
    Faccion faccion;

    public PlazaCentral(Posicion posicionConstruccion, Faccion faccionRecibida) throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        super(posicionConstruccion,450,2);
        estado = new Ocupado(3);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }


    public Aldeano crearAldeano() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Desocupado();
        return new Aldeano(posicion.obtenerPosicionDeDespliegue(), faccion);
    }

}
