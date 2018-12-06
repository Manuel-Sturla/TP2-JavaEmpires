package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.Unidad;

public class MoverArriba implements Comando {
    Unidad invoker;
    public MoverArriba(Unidad unidad) {
        invoker = unidad;

    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invoker.moverArriba();
    }

    @Override
    public String getNombre() {
        return "arriba-arriba";
    }
}

