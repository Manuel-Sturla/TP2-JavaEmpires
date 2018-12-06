package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.ArmaDeAsedio;

public class Montar implements Comando {
    ArmaDeAsedio invoker;
    public Montar(ArmaDeAsedio armaDeAsedio) {
        invoker = armaDeAsedio;
    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException, UnidadesMaximasException {
        invoker.montarArma();
    }

    @Override
    public String getNombre() {
        return "Montar";
    }
}
