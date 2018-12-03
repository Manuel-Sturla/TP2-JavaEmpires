package Posiciones;

import Exceptions.PosicionInvalidaException;
import Mapa.Mapa;
import Ubicables.Ubicable;

import java.util.ArrayList;
import java.util.HashSet;

public class PosicionEdificio{
    private Mapa mapa;
    int largoLado;
    Posicion posiciones[][];

    public PosicionEdificio(Posicion posicionRecibida, int largoLadoRecibido) throws PosicionInvalidaException {
        mapa = posicionRecibida.getMapa();
        largoLado = largoLadoRecibido;
        posiciones = new Posicion[largoLado][largoLado];
        int coordenadaHorizontalInicial = posicionRecibida.getCoordenadaHorizontal();
        int coordenadaVerticalIncial = posicionRecibida.getCoordenadaVertical();
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                posiciones[i][j] = new Posicion(mapa, coordenadaHorizontalInicial + i, coordenadaVerticalIncial + j);
            }
        }
        if (!mapa.estaEnMapa(posiciones[largoLado - 1][largoLado - 1])) throw new PosicionInvalidaException();
    }

    public Mapa getMapa() {
        return mapa;
    }

    public ArrayList getArrayPosiciones() {
        ArrayList arrayPosiciones = new ArrayList();
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                arrayPosiciones.add(posiciones[i][j]);
            }
        }
        return arrayPosiciones;
    }

    public void ocuparPosiciones(Ubicable edificio) throws PosicionInvalidaException {
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                mapa.ocuparCelda(edificio, posiciones[i][j]);
            }
        }
    }

    public void desocuparPosiciones() throws PosicionInvalidaException {
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                mapa.desocuparCelda(posiciones[i][j]);
            }
        }
    }

    public Posicion obtenerPosicionDeDespliegue() {
        Posicion posicionDespliegue = new Posicion(mapa, posiciones[0][1].getCoordenadaHorizontal() - 1, posiciones[0][1].getCoordenadaVertical());
        return posicionDespliegue;
    }

    public boolean estanDisponible() throws PosicionInvalidaException {
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                if (mapa.celdaEstaOcupada(posiciones[i][j])) return false;
            }
        }
        return true;
    }

    public HashSet<Ubicable> obtenerUnidadesEnRango(int rango) throws PosicionInvalidaException {
        HashSet<Ubicable> unidades = new HashSet();
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                unidades.addAll(posiciones[i][j].obtenerUnidadesEnRango(rango));
            }
        }
        return unidades;
    }


    public boolean estaEnRango(Posicion posicion, int rango) throws PosicionInvalidaException {
        for (int i = 0; i < largoLado; i++) {
            for (int j = 0; j < largoLado; j++) {
                if (mapa.estaEnRango(posiciones[i][j],posicion,rango)) return true;
            }
        }
        return false;
    }
}
