package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.Unidad;

public class MoverIzquierdaAbajo implements Comando {
    Unidad invoker;
    public MoverIzquierdaAbajo(Unidad unidad) {
        invoker = unidad;

    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invoker.moverAbajoIzq();
    }

    @Override
    public String getNombre() {
        return "der-abajo";
    }
}