package Modelo.Ubicables.Unidades;

import Controladores.Comandos.Atacar;
import Controladores.Comandos.Comando;
import Controladores.Comandos.Desmontar;
import Controladores.Comandos.Montar;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Edificio;

import java.util.ArrayList;

public class ArmaDeAsedio extends Unidad implements Ejercito{
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


    @Override
    public void atacar(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        return;
    }

    public void atacar(Edificio objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        if(!montada) {
            return;
        }
        super.atacar(objetivo, 5);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }

    public ArrayList<Comando> getAcciones(){
        ArrayList<Comando> acciones = new ArrayList<>();
        acciones.add(new Atacar(this));
        acciones.add(new Montar(this));
        acciones.add(new Desmontar(this));
        return acciones;
    }
}
