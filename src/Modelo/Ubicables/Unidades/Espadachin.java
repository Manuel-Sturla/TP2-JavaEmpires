package Modelo.Ubicables.Unidades;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Edificio;

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
