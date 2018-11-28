package Ubicables.Unidades;

import Exceptions.*;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;
import Ubicables.Edificios.Cuartel;
import Ubicables.Edificios.PlazaCentral;

public class Aldeano extends Unidad {

    public Aldeano(Posicion posicionRecibida, Faccion faccionRecibida) throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        super(50,posicionRecibida);
        faccion = faccionRecibida;
        crear(this);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);

    }

    public PlazaCentral crearPlazaCentral(Posicion posicionConstruccion) throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        //ver si hay plata
        PlazaCentral plazaCentral = new PlazaCentral(posicionConstruccion, faccion);
        estado = new Ocupado(3);
        //gasta plata
        return plazaCentral;
    }

    public Cuartel aldaeanoCreaCuartel(Posicion posicionConstruccion) throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        if(!posicion.edificioEstaEnRango(posicionConstruccion)) throw new PosicionFueraDeRangoException();
        Cuartel cuartel = new Cuartel(posicionConstruccion, faccion);
        estado = new Ocupado(3);
        return cuartel;
    }


    public int getVida(){return vida;}



    public Posicion getPosicion(){
        return posicion;
    }
}



