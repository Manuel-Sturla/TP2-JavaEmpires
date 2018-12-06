package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Edificios.Castillo;

public class CrearArmaDeAsedio implements Comando {
    Castillo invoker;
    public CrearArmaDeAsedio(Castillo castillo) {
        invoker = castillo;
    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException, UnidadesMaximasException {
        invoker.crearArmaDeAsedio();
    }

    @Override
    public String getNombre() {
        return "Crear Arma De Asedio";
    }
}
