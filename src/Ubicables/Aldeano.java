package Ubicables;

import Exceptions.*;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;

public class Aldeano implements Ubicable {
    Posicion posicion;
    Estado estado;
    int vida = 50;

   public Aldeano(Posicion posicionRecibida) throws PosicionFueraDeRangoException {
        posicion = new Posicion(posicionRecibida);
        estado = new Desocupado();
        posicionRecibida.getMapa().ocuparCelda(this, posicion);

    }

    public void moverDerecha() throws UbicableEstaOcupadoException, MovimientoNoPermitidoException {
       try{
           posicion.moverDer();

       } catch (PosicionException e) {
           throw new MovimientoNoPermitidoException();
       }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajo() throws UbicableEstaOcupadoException, PosicionNoDisponibleException, MovimientoNoPermitidoException {
        try{
            posicion.moverAbajo();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }
    public void moverIzquierda() throws UbicableEstaOcupadoException, PosicionNoDisponibleException, MovimientoNoPermitidoException {
        try{
            posicion.moverIzq();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    // FALTA MOVIMIENTOS: arriba, diagonales
    public boolean estaOcupado() {
        return estado.estaOcupado();
    }

    public void desocuparUnTurno(){
        estado = estado.desocuparUnTurno();
    }

    public PlazaCentral crearPlazaCentral() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
        PlazaCentral plazaCentral = new PlazaCentral(posicion);
        return plazaCentral;
    }


}



