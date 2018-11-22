package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;
import Ubicables.Ubicable;

public abstract class Edificios implements Ubicable {

    protected int vida,vidaActual;
    protected PosicionEdificio posicion;
    protected Estado estado;
    protected Faccion faccion;

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
    public void recibirDanio(int danioRecibido) {
        vidaActual -= danioRecibido;
    }

}
