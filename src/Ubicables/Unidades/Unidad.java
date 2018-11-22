package Ubicables.Unidades;

import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;
import Ubicables.Ubicable;

public abstract class Unidad implements Ubicable {
    protected int vida;
    protected Estado estado;
    protected Posicion posicion;
    protected Faccion faccion;

    public Unidad(int vidaRecibida, Posicion posicionRescibida){
        vida = vidaRecibida;
        posicion = posicionRescibida;
        estado = new Desocupado();
    }

    public void moverDerecha() throws UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverDerecha();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }
    public void moverAbajo() throws UbicableEstaOcupadoException, PosicionNoDisponibleException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverAbajo();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }
    public void moverIzquierda() throws UbicableEstaOcupadoException, PosicionNoDisponibleException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()) throw new UbicableEstaOcupadoException();
        try {
            posicion.moverIzquierda();
        }catch (PosicionException e){
            throw new MovimientoNoPermitidoException();
        }

        estado = new Ocupado(1);
    }
    public void moverArriba() throws UbicableEstaOcupadoException, PosicionNoDisponibleException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverArriba();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }

    public void moverArribaIzq() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverArribaIzq();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }

    public void moverArribaDer() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverArribaDer();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajoIzq() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverAbajoIzq();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajoDer() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        try{
            posicion.moverAbajoDer();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        estado = new Ocupado(1);
    }
    //ESTADOS
    public boolean estaOcupado() {
        return estado.estaOcupado();
    }
    public void desocuparUnTurno(){
        estado = estado.desocuparUnTurno();
    }


}
