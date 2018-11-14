package Unidad;

import Mapa.*;

public class Unidad implements ElementoDeMapa {

    int posicionHorizontal;
    int posicionVertical;

    @Override
    public void actualizarPosicion(int coordenadaHorizontal, int coordenadaVertical) {
        posicionHorizontal = coordenadaHorizontal;
        posicionVertical = coordenadaVertical;
    }


    public void moverHaciaDerecha(Mapa mapa){
        Unidad unidadCopia = new Unidad();
        mapa.agregarElementoDeMapa(unidadCopia, posicionHorizontal + 1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal, posicionVertical);
    }
    public void moverHaciaIzquierda(Mapa mapa){
        Unidad unidadCopia = new Unidad();
        mapa.agregarElementoDeMapa(unidadCopia,posicionHorizontal - 1, posicionVertical);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaArriba(Mapa mapa){
        Unidad unidadCopia = new Unidad();
        mapa.agregarElementoDeMapa(unidadCopia,posicionHorizontal, posicionVertical + 1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaAbajo(Mapa mapa) {
        Unidad unidadCopia = new Unidad();
        mapa.agregarElementoDeMapa(unidadCopia,posicionHorizontal,posicionVertical -1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }

    public void moverHaciaArribaDer(Mapa mapa){
        Unidad copiaUniada = new Unidad();
        mapa.agregarElementoDeMapa(copiaUniada,posicionHorizontal +1,posicionVertical+1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaAbajoDer(Mapa mapa){
        Unidad copiaUniada = new Unidad();
        mapa.agregarElementoDeMapa(copiaUniada,posicionHorizontal +1,posicionVertical-1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaArribaIzq(Mapa mapa){
        Unidad copiaUniada = new Unidad();
        mapa.agregarElementoDeMapa(copiaUniada,posicionHorizontal -1,posicionVertical+1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }
    public void moverHaciaAbajoIzq(Mapa mapa){
        Unidad copiaUniada = new Unidad();
        mapa.agregarElementoDeMapa(copiaUniada,posicionHorizontal -1,posicionVertical-1);
        mapa.borrarElementoDeMapa(posicionHorizontal,posicionVertical);
    }


}
