package Unidades;

import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;

public class Aldeano implements Ubicable {
    Posicion posicion;
    Estado estado;
    int vida = 50;

    public Aldeano(Posicion posicionRecibida){
        posicion = new Posicion(posicionRecibida);
        estado = new Desocupado();
        posicionRecibida.getMapa().ocuparCelda(this, posicion);

    }
    public void moverDerecha() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
       posicion.moverDer();
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajo() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        posicion.moverAbajo();
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public boolean estaOcupado() {
        return estado.estaOcupado();
    }

    public void desocuparUnTurno(){
        estado = estado.desocuparUnTurno();
    }

    public void crearEdificio() throws UbicableEstaOcupadoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
    }

    public void moverIzquierda() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        posicion.moverIzq();
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }
}



