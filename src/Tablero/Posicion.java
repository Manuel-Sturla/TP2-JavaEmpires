package Tablero;

import Exceptions.PosicionNoDisponibleException;
import Unidades.Aldeano;

public class Posicion {
    private int coordenadaHorizontal;
    private int coordenadaVertical;
    private Mapa mapa;

    //constructor
    public Posicion(Mapa mapaRecibido, int CH, int CV) {
        this.coordenadaHorizontal = CH;
        this.coordenadaVertical = CV;
        mapa = mapaRecibido;
    }

    //getters
    public int getCoordenadaHorizontal() {
        return this.coordenadaHorizontal;
    }
    public int getCoordenadaVertical() {
        return coordenadaVertical;
    }

    // metodos de movimiento
    public void moverDer() throws PosicionNoDisponibleException {

        Posicion posicionLlegada = new Posicion(mapa, coordenadaHorizontal+1, coordenadaVertical);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal+=1;

    }

    public void moverIzq() throws PosicionNoDisponibleException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical);
        mapa.moverElemento(this,posicionLlegada);
        coordenadaHorizontal-=1;
    }

    public void moverArriba() throws PosicionNoDisponibleException{
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal,coordenadaVertical+1);
        mapa.moverElemento(this,posicionLlegada);
        coordenadaVertical += 1;
    }

    public void moverAbajo() throws PosicionNoDisponibleException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal,coordenadaVertical-1);
        mapa.moverElemento(this,posicionLlegada);
        coordenadaVertical -= 1;
    }

    public void moverArribaDer() throws PosicionNoDisponibleException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal+1,coordenadaVertical+1);
        mapa.moverElemento(this,posicionLlegada);
        coordenadaHorizontal += 1;
        coordenadaVertical += 1;
    }
}
