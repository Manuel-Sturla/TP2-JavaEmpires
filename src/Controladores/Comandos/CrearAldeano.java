package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Edificios.PlazaCentral;

public class CrearAldeano implements Comando {
    PlazaCentral invoker;
    public CrearAldeano(PlazaCentral plazaCentral) {
        invoker = plazaCentral;
    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException, UnidadesMaximasException {
        invoker.crearAldeano();
    }

    @Override
    public String getNombre() {
        return "Crear Aldeano";
    }
}
