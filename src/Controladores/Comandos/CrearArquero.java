package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Edificios.Cuartel;

public class CrearArquero implements Comando {

    Cuartel invoker;
    public CrearArquero(Cuartel cuartel) {
        invoker = cuartel;
    }


    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException, UnidadesMaximasException {
        invoker.crearArquero();
    }

    @Override
    public String getNombre() {
        return "Crear Arquero";
    }
}
