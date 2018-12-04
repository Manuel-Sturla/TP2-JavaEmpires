package Modelo.Ubicables.Unidades;

import Modelo.Estados.Desocupado;
import Modelo.Estados.Muerto;
import Modelo.Estados.Ocupado;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Castillo;
import Modelo.Ubicables.Edificios.Edificio;
import Modelo.Ubicables.Ubicable;

public class Unidad extends Ubicable {
    Posicion posicion;

    public Unidad(int vidaRecibida, Posicion posicionRescibida){
        vida = vidaRecibida;
        posicion = posicionRescibida;
        estado = new Desocupado();
    }

    public void moverDerecha() throws UbicableEstaOcupadoException, PosicionInvalidaException{
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverDerecha();
        estado = new Ocupado(1);
    }
    public void moverAbajo() throws UbicableEstaOcupadoException, PosicionInvalidaException{
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverAbajo();
        estado = new Ocupado(1);
    }
    public void moverIzquierda() throws UbicableEstaOcupadoException, PosicionInvalidaException{
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverIzquierda();
        estado = new Ocupado(1);
    }
    public void moverArriba() throws UbicableEstaOcupadoException, PosicionInvalidaException{
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverArriba();
        estado = new Ocupado(1);
    }
    public void moverArribaIzq() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverArribaIzq();
        estado = new Ocupado(1);
    }
    public void moverArribaDer() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverArribaDer();
        estado = new Ocupado(1);
    }
    public void moverAbajoIzq() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverAbajoIzq();
        estado = new Ocupado(1);
    }
    public void moverAbajoDer() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        posicion.moverAbajoDer();
        estado = new Ocupado(1);
    }


    public Posicion getPosicion(){
        return posicion;
    }

    public void atacar(Unidad objetivo, int rango) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if(!objetivo.getPosicion().estaEnRango(posicion, rango)){
            throw new UbicableFueraDeRangoException();
        }
        if (faccion.perteneceFaccion(objetivo)) {
            throw new UbicableDeMismaFaccionException();
        }

    }

    public void atacar(Edificio objetivo, int rango) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if(!posicion.estaEnRango(objetivo.getPosicion(), rango)){
            throw new UbicableFueraDeRangoException();
        }
        if (faccion.perteneceFaccion(objetivo)) {
            throw new UbicableDeMismaFaccionException();
        }


    }

    public void recibirDanio(Espadachin espadachin) throws PosicionInvalidaException {
        super.recibirDanio(25);
    }
    public void recibirDanio(Arquero arquero) throws PosicionInvalidaException {
        super.recibirDanio(15);
    }

    public void recibirDanio(Castillo castillo) throws PosicionInvalidaException {
        super.recibirDanio(20);
    }



    public void morir() throws PosicionInvalidaException {
        posicion.desocupar(posicion);
        estado = new Muerto();
    }
}
