package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Faccion;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;
import Ubicables.Pieza;
import Ubicables.Ubicable;

public abstract class Edificios extends Pieza implements Ubicable {

    protected int vidaActual;
    protected PosicionEdificio posicion;

    public Edificios(Posicion posicionCostruccion,int vidaRecibida,int largo) throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        posicion = new PosicionEdificio(posicionCostruccion, largo);
        if(!posicion.estanDisponible()) throw new PosicionNoDisponibleException();
        posicion.ocuparPosiciones(this);
        vida =vidaRecibida;
        vidaActual =vidaRecibida;
    }





}
