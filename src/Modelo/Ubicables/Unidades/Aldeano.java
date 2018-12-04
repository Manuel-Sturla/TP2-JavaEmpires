package Modelo.Ubicables.Unidades;

import Modelo.Estados.Ocupado;
import Modelo.Estados.Reparando;
import Modelo.Exceptions.*;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Cuartel;
import Modelo.Ubicables.Edificios.Edificio;
import Modelo.Ubicables.Edificios.PlazaCentral;

public class Aldeano extends Unidad {
    ConstructorDeUbicables constructor;

    public Aldeano(Posicion posicionRecibida, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(50, posicionRecibida);
        constructor = constructorRecibido;
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }

    public void crearPlazaCentral() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        Posicion posicionConstruccion = new Posicion(posicion.getMapa(), posicion.getCoordenadaHorizontal() + 1,posicion.getCoordenadaVertical()); //Parche
        PlazaCentral plaza = null;
        try {
            plaza = constructor.crearPlazaCentral(posicionConstruccion);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        estado = new Ocupado(3);
        plaza.asignarFaccion(faccion);
    }

    public void crearCuartel() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        Posicion posicionConstruccion = new Posicion(posicion.getMapa(), posicion.getCoordenadaHorizontal() + 1,posicion.getCoordenadaVertical()); //Parche
        Cuartel cuartel = null;
        try {
            cuartel = constructor.crearCuartel(posicionConstruccion);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        estado = new Ocupado(3);
        cuartel.asignarFaccion(faccion);
    }

    public void reparar(Edificio edificio) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeOtraFaccionException {
        if (edificio.estaEnConstruccion()){
            return; //no hace nadaaaa
        }
        if (!posicion.estaEnRango(edificio.getPosicion())){
            throw new UbicableFueraDeRangoException();
        }
        if (!faccion.perteneceFaccion(edificio)){
            throw  new UbicableDeOtraFaccionException();
        }
        estado = new Reparando(edificio);
        edificio.reparar();
    }

    public int getVida(){return vida;}



}
