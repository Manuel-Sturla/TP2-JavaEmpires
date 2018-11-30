package Ubicables.Unidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableFueraDeRangoException;
import Posiciones.Posicion;

public class Arquero extends Unidad{

    public Arquero(Posicion posicionRecibida) throws PosicionInvalidaException {
        super(75, posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }

    public void atacarUnidad(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if(!posicion.estaEnRango(objetivo.getPosicion(), 3)){
            throw new UbicableFueraDeRangoException();
        }
        if (faccion.perteneceFaccion(objetivo)) {
            throw new UbicableDeMismaFaccionException();
        }
        objetivo.recibirDanio(25);
    }
}
