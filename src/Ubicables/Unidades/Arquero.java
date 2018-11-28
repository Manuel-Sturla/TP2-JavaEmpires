package Ubicables.Unidades;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;
import Ubicables.Unidades.Unidad;

public class Arquero extends Unidad {
    Faccion faccion;

    public Arquero(Posicion posicionRecibida, Faccion faccionRecibida) throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        super(100, posicionRecibida);
        faccion = faccionRecibida;
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
        faccion.agregarMiembro(this);
    }

    public void atacarUnidad(Unidad objetivo) throws PosicionFueraDeRangoException {
        posicion.estaEnRango(objetivo.getPosicion(), 3);
        if (!faccion.perteneceFaccion(objetivo)) {
            objetivo.recibirDanio(25);
        }
    }


    public Posicion getPosicion() {
        return posicion;
    }


}