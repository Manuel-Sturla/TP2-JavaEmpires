package Tablero;

import Edificios.Edificio;
import Unidades.Unidad;

public class Posicion {
    int coordenadaHorizontal;
    int coordenadaVertical;
    Mapa mapaAOE;

    public Posicion(Mapa mapa, int CoordenadaHorizontal, int CoordenadaVertical) {
        coordenadaHorizontal = CoordenadaHorizontal;
        coordenadaVertical = CoordenadaVertical;
        mapaAOE = mapa;
    }


    public boolean estaEnRangoDeAccion() {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (mapaAOE.estaOcupadoElCasillero(coordenadaHorizontal + i, coordenadaVertical + j) && i != 0 && j != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moverPosicion(int moverCoordenadaHorizontal, int moverCoordenadaVertical) {
        coordenadaHorizontal = coordenadaHorizontal + moverCoordenadaHorizontal;
        coordenadaVertical = coordenadaVertical + moverCoordenadaVertical;
    }
}
