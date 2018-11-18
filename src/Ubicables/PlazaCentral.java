package Ubicables;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Estado;
import Turnos.Ocupado;
import Ubicables.Ubicable;

public class PlazaCentral implements Ubicable {
    PosicionEdificio posicion;
    Estado estado;

    public PlazaCentral(Posicion posicionAldeano) throws PosicionFueraDeRangoException {
        posicion = new PosicionEdificio(posicionAldeano, 4);
        posicion.ocuparPosiciones(this);
        estado = new Ocupado(3);
    }

    public void desocuparUnTurno() {
        estado = estado.desocuparUnTurno();
    }

    public boolean estaOcupada() {
        return estado.estaOcupado();
    }

    public Aldeano crearAldeano() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        Aldeano aldeano = new Aldeano(posicion.obtenerPosicionDeAldeano());
        return aldeano;
    }
}
