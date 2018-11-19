package Tablero;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;

public class Posicion {
    private int coordenadaHorizontal;
    private int coordenadaVertical;
    private Mapa mapa;

    //constructor
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

    //getters
    public int getCoordenadaHorizontal() {
        return this.coordenadaHorizontal;
    }
    public int getCoordenadaVertical() {
        return coordenadaVertical;
    }
    public Mapa getMapa(){
        return mapa;
    }

    // metodos de movimiento
    public void moverDer() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {

        Posicion posicionLlegada = new Posicion(mapa, coordenadaHorizontal+1, coordenadaVertical);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal+=1;

    }
    public void moverIzq() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal-=1;
    }
    public void moverArriba() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal,coordenadaVertical+1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaVertical += 1;
    }
    public void moverAbajo() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal,coordenadaVertical-1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaVertical -= 1;
    }

    public void moverArribaDer() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal+1,coordenadaVertical+1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal += 1;
        coordenadaVertical += 1;
    }
    public void moverArribaIzq() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical+1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal -= 1;
        coordenadaVertical += 1;
    }
    public void moverAbajoIzq() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal-1,coordenadaVertical-1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal -= 1;
        coordenadaVertical -= 1;
    }
    public void moverAbajoDer() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,coordenadaHorizontal+1,coordenadaVertical-1);
        mapa.moverElemento(this, posicionLlegada);
        coordenadaHorizontal += 1;
        coordenadaVertical -= 1;
    }
}
