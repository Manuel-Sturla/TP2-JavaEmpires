package Controladores.Comandos;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.Aldeano;

public class CrearPlazaCentral implements Comando {

    Aldeano invocador;
    public CrearPlazaCentral(Aldeano ubicable){
        invocador=ubicable;
    }
    @Override
    public void execute() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        invocador.crearPlazaCentral();
    }

    @Override
    public  String getNombre(){
        return "Crear Plaza Central";
    }
}
