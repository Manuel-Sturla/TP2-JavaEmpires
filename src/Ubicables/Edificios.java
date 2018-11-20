package Ubicables;

import Exceptions.PosicionFueraDeRangoException;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;

public abstract class Edificios implements Ubicable {

    protected int vida,vidaActual;
    protected PosicionEdificio posicion;
    protected Estado estado;

    public Edificios(Posicion posicionCostruccion,int vidaRecibida,int largo) throws PosicionFueraDeRangoException {
        posicion = new PosicionEdificio(posicionCostruccion, largo);
        posicion.ocuparPosiciones(this);
        vida =vidaRecibida;
        vidaActual =vidaRecibida;
    }

    public void desocuparUnTurno() {
        estado = estado.desocuparUnTurno();
    }
    public boolean estaOcupada() {
        return estado.estaOcupado();
    }

    @Override
    public boolean estaMuerto() {
        return vidaActual<1;
    }

    @Override
    public void quitarVida(int dañoRecibido) {
        vidaActual -= dañoRecibido;
    }

}
