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

        Posicion posicion_llegada = new Posicion(mapa, coordenadaHorizontal+1, coordenadaVertical);
        mapa.moverElemento(this, posicion_llegada);
    }

}
