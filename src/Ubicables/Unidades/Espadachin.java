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

    @Override
    public void atacarUnidad(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        super.atacarUnidad(objetivo);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }
}
