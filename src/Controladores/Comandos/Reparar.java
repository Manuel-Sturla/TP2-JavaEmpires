package Controladores.Comandos;

import Modelo.Exceptions.*;
import Modelo.Ubicables.Edificios.Edificio;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.Aldeano;

public class Reparar implements ComandoConObjetivo {
    Aldeano invocador;
    Edificio edificio;
    public Reparar(Aldeano aldeano){
        invocador = aldeano;
    }

    public void agregarObjetivo(Ubicable objetivo){
        edificio = (Edificio) objetivo;
    }
    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException, UbicableDeOtraFaccionException {
        invocador.reparar(edificio);
    }

    @Override
    public String getNombre() {
        return "Reparar";
    }
}
