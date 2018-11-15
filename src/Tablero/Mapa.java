package Tablero;

public class Mapa {

    int TamMapa;
    ElementoDeMapa[][] mapaAOE;

    public Mapa() {
        TamMapa = 10;
        mapaAOE = new ElementoDeMapa[TamMapa][TamMapa];
    }

    public boolean agregarElementoDeMapa(ElementoDeMapa elemento, Posicion posicion, int coordenadaHorizontal, int coordenadaVertical) {
        if (esCoordenadaValida(coordenadaHorizontal) && esCoordenadaValida(coordenadaVertical)
                && mapaAOE[coordenadaHorizontal][coordenadaVertical] == null) {
            mapaAOE[coordenadaHorizontal][coordenadaVertical] = elemento;
            posicion.actualizarPosicion(coordenadaHorizontal, coordenadaVertical);
            return true;
        }
        return false;
    }

    private boolean esCoordenadaValida(int coordenada) {
        if (coordenada < TamMapa && coordenada >= 0) {
            return true;
        }
        return false;
    }

    public boolean estaOcupadoElCasillero(int coordenadaHorizontal, int coordenadaVertical) {
        return (mapaAOE[coordenadaHorizontal][coordenadaVertical] != null);
    }

    public void borrarElementoDeMapa(int coordenadaHorizontal, int coordenadaVertical) {
        mapaAOE[coordenadaHorizontal][coordenadaVertical] = null;
    }

    public boolean sonContiguos(int P1Vorizontal, int P1Vertical, int P2Horizontal,int P2Vertical) {
        return true;
    }
}