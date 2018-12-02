package Ubicables.Edificios;

import Estados.Ocupado;
import Exceptions.OroInsuficienteException;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Exceptions.UnidadesMaximasException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;

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
