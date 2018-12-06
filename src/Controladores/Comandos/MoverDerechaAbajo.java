package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.Unidad;

public class MoverDerechaAbajo implements Comando {
    Unidad invoker;
    public MoverDerechaAbajo(Unidad unidad) {
        invoker = unidad;

    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invoker.moverAbajoDer();
    }

    @Override
    public String getNombre() {
        return "der-abajo";
    }
}