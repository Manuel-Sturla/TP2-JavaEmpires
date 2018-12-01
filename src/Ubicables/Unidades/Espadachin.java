package Ubicables.Unidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableFueraDeRangoException;
import Posiciones.Posicion;
import Ubicables.Edificios.Edificio;

public class Espadachin extends Unidad{

    public Espadachin(Posicion posicionRecibida) throws PosicionInvalidaException {
        super(100, posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }


    public void atacar(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        super.atacar(objetivo, 1);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }
    public void atacar(Edificio objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        super.atacar(objetivo, 1);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }

}
