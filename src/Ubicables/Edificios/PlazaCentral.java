package Ubicables.Edificios;

import Estados.Ocupado;
import Exceptions.OroInsuficienteException;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Ubicables.Unidades.Aldeano;

public class PlazaCentral extends Edificio {

    public PlazaCentral(Posicion posicionConstruccion, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionConstruccion, 450, 2, constructorRecibido, 25);
        estado = new Ocupado(3);
    }

    public void crearAldeano() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        Aldeano aldeano = null;
        try {
            aldeano = constructor.crearAldeano(posicion.obtenerPosicionDeDespliegue());
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        aldeano.asignarFaccion(faccion);
    }

}
