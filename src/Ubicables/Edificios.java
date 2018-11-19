package Ubicables;

import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Estado;

public abstract class Edificios implements Ubicable {

    int vida,vidaActual;
    PosicionEdificio posicion;
    Estado estado;

    public Edificios(Posicion posicionAldeano){

    }
}
