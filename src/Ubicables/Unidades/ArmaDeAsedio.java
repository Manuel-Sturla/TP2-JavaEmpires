package Ubicables.Unidades;

import Exceptions.ArmaNoDesmontadaException;
import Exceptions.MovimientoNoPermitidoException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;

public class ArmaDeAsedio extends Unidad {
        boolean montada = false;

    public ArmaDeAsedio(Posicion posicion, Faccion faccionRecibida) throws PosicionFueraDeRangoException {
            super(150,posicion);
            faccion = faccionRecibida;
            crear(this);
            posicion.getMapa().ocuparCelda(this, posicion);
        }


    public void montarArma() {
            montada = true;
        }

    public void desmontarArma(){ montada = false;}

    public boolean getEstaMontada() {
            return montada;
        }

    public int getVida(){return vida;}


    @Override
    public void moverDerecha() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverDerecha();
    }
    @Override
    public void moverIzquierda() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverIzquierda();
    }
    @Override
    public void moverArriba() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverArriba();
    }
    @Override
    public void moverAbajo() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverAbajo();
    }


    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }
}
