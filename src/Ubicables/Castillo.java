package Ubicables;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Tablero.PosicionEdificio;

public class Castillo implements Ubicable {
    PosicionEdificio posicion;

    public Castillo(Posicion posicionInicial) throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        posicion = new PosicionEdificio(posicionInicial, 4);
        posicion.ocuparPosiciones(this);
    }
}
