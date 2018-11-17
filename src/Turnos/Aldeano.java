package Turnos;

import Exceptions.UbicableEstaOcupadoException;
import Tablero.Posicion;

public class Aldeano {
    Posicion posicion;
    Estado estado;

    public Aldeano(Posicion posicionRecibida){
        posicion = posicionRecibida;
        //Crearia otra posicion pero me da paja
        estado = new Desocupado();

    }

    public boolean moverDerecha() throws UbicableEstaOcupadoException {
        //Falta hacer el movimiento
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado();
        return true;
    }


    public boolean estaOcupado() {
        return estado.estaOcupado();
    }
}
