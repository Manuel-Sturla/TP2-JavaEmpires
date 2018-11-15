package Unidades;

import Tablero.*;

public abstract class Unidad implements ElementoDeMapa {

    protected int vida, vidaActual;
    protected Posicion posicion = null;
    private int posicionHorizontal = posicion.getCoordenadaHorizontal();
    private int posicionVertical = posicion.getCoordenadVertical();

    public Unidad(int vida,int vidaActual,Posicion pos){
        this.vida = vida;
        this.vidaActual = vidaActual;
        this.posicion = pos;
    }

    public void actualizarPosicion(int coordenadaHorizontal, int coordenadaVertical) {
        posicion.actualizarPosicion(coordenadaHorizontal,coordenadaVertical);
    }


    public void moverHaciaDerecha(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion, posicionHorizontal+1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal, posicionVertical);
    }
    public void moverHaciaIzquierda(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal - 1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaArriba(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal, posicionVertical + 1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaAbajo(Mapa mapa) {
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal,posicionVertical -1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }

    public void moverHaciaArribaDer(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal +1,posicionVertical+1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaAbajoDer(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal +1,posicionVertical-1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaArribaIzq(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal -1,posicionVertical+1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaAbajoIzq(Mapa mapa){
        mapa.agregarElementoDeMapa(this,posicion,posicionHorizontal -1,posicionVertical-1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }


}
