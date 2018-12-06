package Controladores.Comandos;

import Controladores.Comandos.Comando;
import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.Unidad;

public class MoverDerechaArriba implements Comando {
    Unidad invoker;
    public MoverDerechaArriba(Unidad unidad) {
        invoker = unidad;

    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invoker.moverArribaDer();
    }

    @Override
    public String getNombre() {
        return "der-arriba";
    }
}