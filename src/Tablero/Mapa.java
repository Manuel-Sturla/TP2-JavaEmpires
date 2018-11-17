package Tablero;

public class Mapa {
    Celda mapa[][];
    int largo;
    int ancho;

    public Mapa(int largoRecibido, int anchoRecibido){
        largo = largoRecibido;
        ancho = anchoRecibido;
        mapa = new Celda[largo][ancho];
    }

    public boolean celdaEstaOcupada(int coordenadaHorizontal, int coordenadaVertical) {
        return (mapa[coordenadaHorizontal][coordenadaVertical] != null);
    }

    public void ocupar(int coordenadaHorizontal, int coordenadaVertical) {
        mapa[coordenadaHorizontal][coordenadaVertical].ocuparCelda();
    }
}
