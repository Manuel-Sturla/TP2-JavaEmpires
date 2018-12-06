package Modelo.Ubicables.Unidades;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Ubicables.Edificios.Edificio;

public interface Ejercito {

    void atacar(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException;

    void atacar(Edificio objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException;
}
