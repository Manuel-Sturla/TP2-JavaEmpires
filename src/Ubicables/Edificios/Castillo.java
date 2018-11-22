package Ubicables.Edificios;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Ubicables.Ubicable;

public class Castillo implements Ubicable {
    PosicionEdificio posicion;
    private int vida = 1000;
    private int vidaActual = vida;
    Faccion faccion;

    public Castillo(Posicion posicionInicial, Faccion faccionRecibida) throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        posicion = new PosicionEdificio(posicionInicial, 4);
        posicion.ocuparPosiciones(this);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }


    @Override
    public boolean estaMuerto() {
        return vidaActual < 1;
    }

    @Override
    public void recibirDanio(int danioRecibido) {
        vidaActual -= danioRecibido;
    }
}