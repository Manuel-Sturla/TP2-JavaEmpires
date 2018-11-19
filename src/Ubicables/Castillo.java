package Ubicables;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Tablero.PosicionEdificio;

public class Castillo implements Ubicable {
    PosicionEdificio posicion;
    private int vida = 1000;
    private int vidaActual = vida;

    public Castillo(Posicion posicionInicial) throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        posicion = new PosicionEdificio(posicionInicial, 4);
        posicion.ocuparPosiciones(this);
    }


    @Override
    public boolean estaMuerto() {
        return vidaActual < 1;
    }

    @Override
    public void quitarVida(int dañoRecibido) {
        vidaActual -= dañoRecibido;
    }
}