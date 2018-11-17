package Tablero;

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

    public boolean celdaEstaOcupada(int coordenadaHorizontal, int coordenadaVertical) {
        return (mapa[coordenadaHorizontal][coordenadaVertical].estaOcupada());
    }

    public void ocupar(int coordenadaHorizontal, int coordenadaVertical) {
        mapa[coordenadaHorizontal][coordenadaVertical].ocuparCelda();
    }

    public void ocuparCelda(int i, int i1) {
        mapa[i][i1].ocuparCelda();
    }

    public void desocuparCelda(int i, int i1) {
        mapa[i][i1].desocuparCelda();

    }
}
