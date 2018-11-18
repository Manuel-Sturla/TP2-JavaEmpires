package Ubicables;

import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Estado;
import Turnos.Ocupado;
import Ubicables.Ubicable;

public class PlazaCentral implements Ubicable {
    PosicionEdificio posicion;
    Estado estado;

    public PlazaCentral(Posicion posicionAldeano){
        posicion = new PosicionEdificio(posicionAldeano);
        posicion.ocuparPosiciones(this);
        estado = new Ocupado(3);
    }

    public void desocuparUnTurno() {
        estado = estado.desocuparUnTurno();
    }

    public boolean estaOcupada() {
        return estado.estaOcupado();
    }
}
