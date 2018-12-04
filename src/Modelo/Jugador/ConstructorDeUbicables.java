package Modelo.Jugador;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Cuartel;
import Modelo.Ubicables.Unidades.Aldeano;
import Modelo.Ubicables.Edificios.PlazaCentral;
import Modelo.Ubicables.Unidades.ArmaDeAsedio;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Espadachin;

public class ConstructorDeUbicables {
    Banco banco;
    Poblacion poblacion;

    public ConstructorDeUbicables(Banco bancoRecibido, Poblacion poblacionRecibida){
        banco = bancoRecibido;
        poblacion = poblacionRecibida;
    }


    public Aldeano crearAldeano(Posicion posicionDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        try {
            banco.gastarOro(25);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        try {
            poblacion.agregarHabitante();
        } catch (UnidadesMaximasException e) {
            banco.agregarOro(25);
            throw new UnidadesMaximasException();
        }
        return new Aldeano(posicionDespliegue, this);
    }

    public PlazaCentral crearPlazaCentral(Posicion posicionConstruccion) throws PosicionInvalidaException, OroInsuficienteException {
        try {
            banco.gastarOro(100);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        return new PlazaCentral(posicionConstruccion, this);
    }

    public Cuartel crearCuartel(Posicion posicionConstruccion) throws PosicionInvalidaException, OroInsuficienteException {
        try {
            banco.gastarOro(50);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        return new Cuartel(posicionConstruccion, this);
    }

    public Espadachin crearEspadachin(Posicion posicionDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        try {
            banco.gastarOro(50);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        try {
            poblacion.agregarHabitante();
        } catch (UnidadesMaximasException e) {
            banco.agregarOro(50);
            throw new UnidadesMaximasException();
        }
        return new Espadachin(posicionDespliegue);
    }

    public Arquero crearArquero(Posicion posicionDeDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        try {
            banco.gastarOro(75);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        try {
            poblacion.agregarHabitante();
        } catch (UnidadesMaximasException e) {
            banco.agregarOro(75);
            throw new UnidadesMaximasException();
        }
        return new Arquero(posicionDeDespliegue);
    }

    public ArmaDeAsedio crearArmaDeAsedio(Posicion posicionDeDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        try {
            banco.gastarOro(200);
        } catch (OroInsuficienteException e) {
            throw new OroInsuficienteException();
        }
        try {
            poblacion.agregarHabitante();
        } catch (UnidadesMaximasException e) {
            banco.agregarOro(200);
            throw new UnidadesMaximasException();
        }
        return new ArmaDeAsedio(posicionDeDespliegue);
    }


}

