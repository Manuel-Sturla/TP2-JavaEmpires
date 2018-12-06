package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Edificios.Cuartel;

public class CrearEspadachin implements Comando{
    Cuartel invoker;

    public CrearEspadachin(Cuartel cuartel){
        invoker = cuartel;
    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException, UnidadesMaximasException {
        invoker.crearEspadachin();
    }

    @Override
    public String getNombre() {
        return "Crear Espadachin";
    }
}
