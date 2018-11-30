package Posiciones;

import Exceptions.PosicionInvalidaException;
import Mapa.Mapa;

import java.util.ArrayList;

public class Posicion {
    private int coordenadaHorizontal;
    private int coordenadaVertical;
    private Mapa mapa;

    //Constructores:
    public Posicion(Posicion posicionRecibida){
        coordenadaVertical = posicionRecibida.getCoordenadaVertical();
        coordenadaHorizontal = posicionRecibida.getCoordenadaHorizontal();
        mapa = posicionRecibida.getMapa();
    }

    public Posicion(Mapa mapaRecibido, int CH, int CV) {
        this.coordenadaHorizontal = CH;
        this.coordenadaVertical = CV;
        mapa = mapaRecibido;
    }

    //Getters:
    public int getCoordenadaHorizontal() {
        return this.coordenadaHorizontal;
    }

    public int getCoordenadaVertical() {
        return coordenadaVertical;
    }

    public Mapa getMapa(){
        return mapa;
    }

    // Movimientos:
    public void moverDerecha() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa, coordenadaHorizontal+1, coordenadaVertical);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal+=1;

    }

    public void moverIzquierda() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal-=1;
    }

    public void moverArriba() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal,coordenadaVertical+1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaVertical += 1;
    }

    public void moverAbajo() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal,coordenadaVertical-1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaVertical -= 1;
    }

    public void moverArribaDer() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal+1,coordenadaVertical+1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal += 1;
        coordenadaVertical += 1;
    }

    public void moverArribaIzq() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical+1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal -= 1;
        coordenadaVertical += 1;
    }

    public void moverAbajoIzq() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical-1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal -= 1;
        coordenadaVertical -= 1;
    }

    public void moverAbajoDer() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal+1,coordenadaVertical-1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal += 1;
        coordenadaVertical -= 1;
    }

    //Verificacion posiciones adyacentes:
    public boolean esAdyacente(Posicion posicionAdyacente) throws PosicionInvalidaException {
        return mapa.esAdyacente(this, posicionAdyacente);
    }

    public boolean edificioEstaEnRango(PosicionEdificio posicionEdificio) throws PosicionInvalidaException {
        ArrayList posicionCostrucccion = posicionEdificio.getArrayPosiciones();
        Posicion posicionActual;
        for(int i=0; i < posicionCostrucccion.size(); i++) {
            posicionActual = (Posicion) posicionCostrucccion.get(i);
            if(posicionActual.esAdyacente(this)) return true;
        }
        return false;
    }

    public boolean estaEnRango(Posicion posicion, int rango) throws PosicionInvalidaException {
        return mapa.estaEnRango(this, posicion, rango);
    }

}
