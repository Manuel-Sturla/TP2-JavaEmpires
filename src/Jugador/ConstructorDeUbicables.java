package Jugador;

import Exceptions.OroInsuficienteException;
import Exceptions.PosicionInvalidaException;
import Exceptions.UnidadesMaximasException;
import Posiciones.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.Aldeano;
import Ubicables.Edificios.PlazaCentral;
import Ubicables.Unidades.ArmaDeAsedio;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;

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

