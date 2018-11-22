package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Ocupado;
import Ubicables.Unidades.Aldeano;
import Ubicables.Unidades.Espadachin;

public class Cuartel extends Edificios {

    Faccion faccion;
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

    public Espadachin crearEspadachin() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Desocupado();
        return new Espadachin(posicion.obtenerPosicionDeDespliegue(), faccion);
    }

}
