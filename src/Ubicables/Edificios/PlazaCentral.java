package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Posicion;
import Turnos.Ocupado;
import Ubicables.Unidades.Aldeano;

public class PlazaCentral extends Edificios {

    public PlazaCentral(Posicion posicionAldeano) throws PosicionFueraDeRangoException {
        super(posicionAldeano,450,2);
        estado = new Ocupado(3);
    }


    public Aldeano crearAldeano() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        Aldeano aldeano = new Aldeano(posicion.obtenerPosicionDeAldeano()); //Es posicion Despliegue
        return aldeano;
    }



}
