package Mapa;

import ElementosDeMapa.ElementoDeMapa;

public class Mapa {
    ElementoDeMapa[][] mapa;
    int TamMapa;

    public Mapa(){
        mapa = new ElementoDeMapa[10][10];
        TamMapa = 10;
    }

    public boolean agregarElementoDeMapa(ElementoDeMapa elemento, int coordenadaX, int coordenadaY) {
        if(esCoordenadaValida(coordenadaX) && esCoordenadaValida(coordenadaY) && mapa[coordenadaX][coordenadaY] == null){
            mapa[coordenadaX][coordenadaY] = elemento;
            return true;
        }
        return false;
    }

    private boolean esCoordenadaValida(int coordenada) {
        if(coordenada < TamMapa && coordenada >= 0){
            return true;
        }
        return false;
    }
}
