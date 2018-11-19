package Ubicables;

import Exceptions.*;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;

public class Aldeano extends Unidad {

   public Aldeano(Posicion posicionRecibida) throws PosicionFueraDeRangoException {
        super(50,posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }

    public PlazaCentral crearPlazaCentral() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
        PlazaCentral plazaCentral = new PlazaCentral(posicion);
        return plazaCentral;
    }


}



