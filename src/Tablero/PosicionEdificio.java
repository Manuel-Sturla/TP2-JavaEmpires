package Tablero;

import Exceptions.PosicionFueraDeRangoException;
import Ubicables.Ubicable;

public class PosicionEdificio {

    Posicion posiciones[];
    Mapa mapa;

    public PosicionEdificio(Posicion posicionRecibida){
        mapa = posicionRecibida.getMapa();
        posiciones = new Posicion[4];

        posiciones[0] = new Posicion(mapa, posicionRecibida.getCoordenadaHorizontal() + 1,posicionRecibida.getCoordenadaVertical());
        posiciones[1] = new Posicion(mapa, posicionRecibida.getCoordenadaHorizontal() + 2,posicionRecibida.getCoordenadaVertical());
        posiciones[2] = new Posicion(mapa, posicionRecibida.getCoordenadaHorizontal() + 1,posicionRecibida.getCoordenadaVertical() + 1);
        posiciones[3] = new Posicion(mapa, posicionRecibida.getCoordenadaHorizontal() + 2,posicionRecibida.getCoordenadaVertical() + 1);

    }



    public Mapa getMapa() {
        return mapa;
    }

    public void ocuparPosiciones(Ubicable edificio) throws PosicionFueraDeRangoException {
        for (int i = 0; i < 4; i++) {
            mapa.ocuparCelda(edificio,posiciones[i]);
        }
    }

    public Posicion obtenerPosicionDeAldeano(){
        Posicion posicionDeploy = new Posicion(mapa, posiciones[2].getCoordenadaHorizontal() - 1, posiciones[2].getCoordenadaVertical());
        return posicionDeploy;
    }
}
