package Ubicables.Unidades;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Faccion;
import Tablero.*;
import Turnos.Ocupado;

public class Espadachin extends Unidad {
    Faccion faccion;

    public Espadachin(Posicion posicionRecibida, Faccion faccionRecibida) throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        super(100, posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }

    public void atacarUnidad(Unidad objetivo) throws PosicionFueraDeRangoException {
        posicion.estaEnRango(objetivo.getPosicion(), 1);
        if(!faccion.perteneceFaccion(objetivo)) {
            objetivo.recibirDanio(25);
        }
    }

    public Posicion getPosicion(){
        return posicion;
    }
}
