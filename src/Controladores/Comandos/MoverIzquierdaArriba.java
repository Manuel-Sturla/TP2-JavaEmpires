package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.Unidad;

public class MoverIzquierdaArriba implements Comando {
    Unidad invoker;
    public MoverIzquierdaArriba(Unidad unidad) {
        invoker = unidad;

    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invoker.moverArribaIzq();
    }

    @Override
    public String getNombre() {
        return "izq-arriba";
    }
}
