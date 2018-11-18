package Tablero;

import Exceptions.PosicionFueraDeRangoException;
import Ubicables.Ubicable;

public class PosicionEdificio {

    Posicion posiciones[][];
    Mapa mapa;
    int largoLado;

    public PosicionEdificio(Posicion posicionRecibida, int largoLadoRecibido){
        mapa = posicionRecibida.getMapa();
        largoLado = largoLadoRecibido;
        posiciones = new Posicion[largoLado][largoLado];
        int coordenadaHorizontalInicial = posicionRecibida.getCoordenadaHorizontal() + 1;
        int coordenadaVerticalIncial = posicionRecibida.getCoordenadaVertical();
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                posiciones[i][j] = new Posicion(mapa, coordenadaHorizontalInicial + i, coordenadaVerticalIncial + j);
            }
        }
    }



    public Mapa getMapa() {
        return mapa;
    }

    public void ocuparPosiciones(Ubicable edificio) throws PosicionFueraDeRangoException {
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                mapa.ocuparCelda(edificio,posiciones[i][j]);
            }
        }
    }

    public Posicion obtenerPosicionDeAldeano(){
        Posicion posicionDeploy = new Posicion(mapa, posiciones[0][1].getCoordenadaHorizontal() - 1, posiciones[0][1].getCoordenadaVertical());
        return posicionDeploy;
    }
}
