package Ubicables.Edificios;

import Estados.Ocupado;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Posiciones.PosicionEdificio;
import Ubicables.Ubicable;
import Ubicables.Unidades.Aldeano;

public class PlazaCentral extends Edificio {

    public PlazaCentral(Posicion posicionConstruccion, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionConstruccion, 450, 2, constructorRecibido, 25);
        estado = new Ocupado(3);
    }

    public void crearAldeano() throws PosicionInvalidaException, UbicableEstaOcupadoException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        estado = new Ocupado(3);
        Aldeano aldeano = constructor.crearAldeano(posicion.obtenerPosicionDeDespliegue());
        aldeano.asignarFaccion(faccion);
    }

}
