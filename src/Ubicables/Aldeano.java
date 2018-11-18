package Ubicables;

import Exceptions.*;
import Tablero.Posicion;
import Turnos.Desocupado;
import Turnos.Estado;
import Turnos.Ocupado;

public class Aldeano implements Ubicable {
    Posicion posicion;
    Estado estado;
    int vida = 50;

<<<<<<< Updated upstream:src/Ubicables/Aldeano.java
   public Aldeano(Posicion posicionRecibida){
=======
    public Aldeano(Posicion posicionRecibida) throws PosicionFueraDeRangoException {
>>>>>>> Stashed changes:src/Unidades/Aldeano.java
        posicion = new Posicion(posicionRecibida);
        estado = new Desocupado();
        posicionRecibida.getMapa().ocuparCelda(this, posicion);

    }
<<<<<<< Updated upstream:src/Ubicables/Aldeano.java

    public void moverDerecha() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
       posicion.moverDer();
=======
    public void moverDerecha() throws UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverDer();
        }catch(PosicionException e){
            throw new MovimientoNoPermitidoException();
        }

        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverAbajo() throws UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverAbajo();
        }catch(PosicionException e){
            throw new MovimientoNoPermitidoException();
        }
>>>>>>> Stashed changes:src/Unidades/Aldeano.java
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }

    public void moverIzquierda() throws UbicableEstaOcupadoException, MovimientoNoPermitidoException {
        try{
            posicion.moverIzq();
        }catch(PosicionException e){
            throw new MovimientoNoPermitidoException();
        }

        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(1);
    }
// FALTAN METODOS PARA MOVIMIENTOS: arriba, y diagonales


    public boolean estaOcupado() {
        return estado.estaOcupado();
    }

    public void desocuparUnTurno(){
        estado = estado.desocuparUnTurno();
    }

    public PlazaCentral crearPlazaCentral() throws UbicableEstaOcupadoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
        PlazaCentral plazaCentral = new PlazaCentral(posicion);
        return plazaCentral;
    }


}



