package Tablero;

import Exceptions.PosicionNoDisponibleException;
import Unidades.Ubicable;

public class Mapa {
    Celda mapa[][];
    int largo;
    int ancho;

    public Mapa(int largoRecibido, int anchoRecibido){
        largo = largoRecibido;
        ancho = anchoRecibido;
        mapa = new Celda[largo][ancho];
        for(int i = 0;i < largo; i++){
            for(int j = 0; j < ancho;j++){
                mapa[i][j] = new Celda();
            }
        }
    }

    public boolean celdaEstaOcupada(Posicion posicion) {
        return (this.obtenerCelda(posicion).estaOcupada());
    }

    public void ocuparCelda(Ubicable elementoMapa, Posicion posicion) {
        this.obtenerCelda(posicion).ocuparCelda(elementoMapa);
    }

    public void desocuparCelda(Posicion posicion) {
        this.obtenerCelda(posicion).desocuparCelda();
    }

    private Celda obtenerCelda(Posicion posicion){
        int coordenadaHorizontal = posicion.getCoordenadaHorizontal();
        int coordenadaVertical = posicion.getCoordenadaVertical();
        return mapa[coordenadaHorizontal][coordenadaVertical];
    }

    public void moverElemento(Posicion posicion, Posicion posicion_llegada) throws PosicionNoDisponibleException {
        Ubicable elemento = this.obtenerCelda(posicion).getElemento();

        if(this.obtenerCelda(posicion_llegada).estaOcupada()){
            throw new PosicionNoDisponibleException();
        }
        this.obtenerCelda(posicion_llegada).ocuparCelda(elemento);
        this.obtenerCelda(posicion).desocuparCelda();
    }


}
