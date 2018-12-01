package Ubicables.Unidades;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableDeMismaFaccionException;
import Exceptions.UbicableEstaOcupadoException;
import Exceptions.UbicableFueraDeRangoException;
import Posiciones.Posicion;
import Ubicables.Edificios.Edificio;
import Ubicables.Ubicable;

public class ArmaDeAsedio extends Unidad{
    boolean montada = false;

    public ArmaDeAsedio(Posicion posicion) throws PosicionInvalidaException {
        super(150,posicion);
        posicion.getMapa().ocuparCelda(this, posicion);
    }


    public void montarArma() {
        montada = true;
    }

    public void desmontarArma(){ montada = false;}

    public int getVida(){return vida;}


    @Override
    public void moverDerecha() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverDerecha();
    }
    @Override
    public void moverIzquierda() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverIzquierda();
    }
    @Override
    public void moverArriba() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverArriba();
    }
    @Override
    public void moverAbajo() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverAbajo();
    }
    @Override
    public void moverArribaDer() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverArribaDer();
    }
    @Override
    public void moverArribaIzq() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverArribaIzq();
    }
    @Override
    public void moverAbajoDer() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverAbajoDer();
    }
    @Override
    public void moverAbajoIzq() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (montada) {
            throw new UbicableEstaOcupadoException();
        }
        super.moverAbajoIzq();
    }



    public void atacarUnidad(Edificio objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if(!posicion.edificioEstaEnRango(objetivo.getPosicion(),3)){
            throw new UbicableFueraDeRangoException();
        }
        if (faccion.perteneceFaccion(objetivo)) {
            throw new UbicableDeMismaFaccionException();
        }
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }
}
