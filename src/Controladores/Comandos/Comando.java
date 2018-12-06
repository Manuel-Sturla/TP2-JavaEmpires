package Controladores.Comandos;

import Modelo.Exceptions.*;

public interface Comando {

    void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException, UnidadesMaximasException;

    String getNombre();
}
