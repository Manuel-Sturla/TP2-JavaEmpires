package Ubicables;

import Exceptions.PosicionFueraDeRangoException;
import Tablero.Posicion;
import Tablero.PosicionEdificio;
import Turnos.Desocupado;
import Turnos.Estado;

public abstract class Edificios implements Ubicable {

    protected int vida,vidaActual;
    protected PosicionEdificio posicion;
    protected Estado estado;

    public Edificios(Posicion posicionInicioConstruccion,int largo,int vidaRecibida) throws PosicionFueraDeRangoException {
        posicion = new PosicionEdificio(posicionInicioConstruccion,largo);
        posicion.ocuparPosiciones(this);
        int vida =vidaRecibida;
        int vidaActual = vidaRecibida;
        Estado estado = new Desocupado();
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
