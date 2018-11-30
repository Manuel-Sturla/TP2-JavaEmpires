package Ubicables.Unidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableFueraDeRangoException;
import Posiciones.Posicion;

public class Espadachin extends Unidad{

    public Espadachin(Posicion posicionRecibida) throws PosicionInvalidaException {
        super(100, posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }

    public void atacarUnidad(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if(!posicion.estaEnRango(objetivo.getPosicion(), 1)){
            throw new UbicableFueraDeRangoException();
        }
        if(faccion.perteneceFaccion(objetivo)){
            throw new UbicableDeMismaFaccionException();
        }
        if(!faccion.perteneceFaccion(objetivo)) {
            objetivo.recibirDanio(25);
        }
    }
}
