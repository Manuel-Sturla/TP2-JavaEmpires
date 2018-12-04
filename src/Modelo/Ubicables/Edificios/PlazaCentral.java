package Modelo.Ubicables.Edificios;

import Modelo.Estados.Ocupado;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Unidades.Aldeano;

public class PlazaCentral extends Edificio {

    public PlazaCentral(Posicion posicionConstruccion, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionConstruccion, 450, 2, constructorRecibido, 25);
        estado = new Ocupado(3);
    }

    public void crearAldeano() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UnidadesMaximasException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        Aldeano aldeano = null;
        aldeano = constructor.crearAldeano(posicion.obtenerPosicionDeDespliegue());

        aldeano.asignarFaccion(faccion);
    }

}
