package Controladores.Comandos;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Ubicables.Unidades.Aldeano;

public class CrearCuartel implements Comando {
    Aldeano invocador;

    public CrearCuartel(Aldeano aldeano){
        invocador=aldeano;
    }
    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        invocador.crearCuartel();
    }

    @Override
    public  String getNombre(){
        return "Crear Cuartel";
    }
}
