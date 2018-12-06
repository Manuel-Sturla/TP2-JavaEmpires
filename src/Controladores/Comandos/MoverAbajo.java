package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Unidades.Unidad;

public class MoverAbajo implements Comando {
    Unidad invoker;
    public MoverAbajo(Unidad unidad) {
        invoker = unidad;

    }

    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invoker.moverAbajo();
    }

    @Override
    public String getNombre() {
        return "abajo-abajo";
    }
}