package Ubicables.Unidades;

import Exceptions.ArmaNoDesmontadaException;
import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;

public class ArmaDeAsedio extends Unidad {
        boolean montada = false;
        Faccion faccion;

    public ArmaDeAsedio(Posicion posicion, Faccion faccionRecibida){
            super(150,posicion);
            faccion = faccionRecibida;
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
    public boolean estaMuerto() {
        return vida<1;
    }

    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }
    @Override
    public Posicion getPosicion() {
        return posicion;
    }


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

    @Override
    public void moverArribaDer() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverArribaDer();
    }
    @Override
    public void moverAbajoDer() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverAbajoDer();
    }
    @Override
    public void moverArribaIzq() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverArribaIzq();
    }
    @Override
    public void moverAbajoIzq() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        if (this.getEstaMontada()) {
            throw new MovimientoNoPermitidoException();
        }
        super.moverAbajoIzq();
    }
}
