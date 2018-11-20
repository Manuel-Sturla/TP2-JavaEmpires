package Ubicables.Unidades;

import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;
import Ubicables.Ubicable;

public abstract class Unidad implements Ubicable {
    protected int vida;
    protected Estado estado;
    protected Posicion posicion;

    public Unidad(int vidaRecibida,Posicion posicionRescibida){
        vida = vidaRecibida;
        posicion = posicionRescibida;
        estado = new Desocupado();
    }


    //MOVIMIENTO
    // FALTA MOVIMIENTOS: arriba, diagonales
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
        try {
            posicion.moverIzq();
        }catch (PosicionException e){
            throw new MovimientoNoPermitidoException();
        }

        if(estado.estaOcupado()) throw new UbicableEstaOcupadoException();
        estado = new Ocupado(1);
    }
    public void moverArriba() throws UbicableEstaOcupadoException, PosicionNoDisponibleException, MovimientoNoPermitidoException {
        try{
            posicion.moverArriba();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverArribaIzq() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverArribaIzq();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverArribaDer() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverArribaDer();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajoIzq() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverAbajoIzq();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajoDer() throws PosicionNoDisponibleException, UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverAbajoDer();
        } catch (PosicionException e) {
            throw new MovimientoNoPermitidoException();
        }
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
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
/*
    public boolean estaEnRango(int rango,Ubicable objetivo){

    }
    */
}