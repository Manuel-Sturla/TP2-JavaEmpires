package Modelo.Ubicables.Edificios;

import Modelo.Estados.Ocupado;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Espadachin;

public class Cuartel extends Edificio {

    public Cuartel(Posicion posicionCostruccion, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionCostruccion, 250, 2, constructorRecibido, 50);
        estado = new Ocupado(3);
    }

    public void crearEspadachin() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        Espadachin espadachin = constructor.crearEspadachin(posicion.obtenerPosicionDeDespliegue());
        espadachin.asignarFaccion(faccion);
    }

    public void crearArquero() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        Arquero arquero = constructor.crearArquero(posicion.obtenerPosicionDeDespliegue());
        arquero.asignarFaccion(faccion);
    }
}
