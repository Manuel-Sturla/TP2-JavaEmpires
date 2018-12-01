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

    @Override
    public void atacarUnidad(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        super.atacarUnidad(objetivo);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }
}
