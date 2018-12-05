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
        if (!banco.hayOroSuficiente(25)){
            throw new OroInsuficienteException();
        }
        if (poblacion.esMaxima()) {
            throw new UnidadesMaximasException();
        }
        Aldeano aldeano =  new Aldeano(posicionDespliegue, this);
        banco.gastarOro(25);
        poblacion.agregarHabitante();
        return aldeano;
    }

    public PlazaCentral crearPlazaCentral(Posicion posicionConstruccion) throws PosicionInvalidaException, OroInsuficienteException {
        if (!banco.hayOroSuficiente(100)){
            throw new OroInsuficienteException();
        }
        PlazaCentral plazaCentral = new PlazaCentral(posicionConstruccion, this);
        banco.gastarOro(100);
        return plazaCentral;
    }

    public Cuartel crearCuartel(Posicion posicionConstruccion) throws PosicionInvalidaException, OroInsuficienteException {
        if (!banco.hayOroSuficiente(50)){
            throw new OroInsuficienteException();
        }
        Cuartel cuartel = new Cuartel(posicionConstruccion, this);
        banco.gastarOro(50);
        return cuartel;
    }

    public Espadachin crearEspadachin(Posicion posicionDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if (!banco.hayOroSuficiente(50)){
            throw new OroInsuficienteException();
        }
        if (poblacion.esMaxima()) {
            throw new UnidadesMaximasException();
        }
        Espadachin espadachin = new Espadachin(posicionDespliegue);
        banco.gastarOro(50);
        poblacion.agregarHabitante();
        return espadachin;
    }

    public Arquero crearArquero(Posicion posicionDeDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if (!banco.hayOroSuficiente(75)){
            throw new OroInsuficienteException();

        }
        if (poblacion.esMaxima()) {
            throw new UnidadesMaximasException();
        }
        Arquero arquero =  new Arquero(posicionDeDespliegue);
        banco.gastarOro(75);
        poblacion.agregarHabitante();
        return arquero;
    }

    public ArmaDeAsedio crearArmaDeAsedio(Posicion posicionDeDespliegue) throws PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if (!banco.hayOroSuficiente(200)){
            throw new OroInsuficienteException();
        }
        if (poblacion.esMaxima()) {
            throw new UnidadesMaximasException();
        }
        ArmaDeAsedio arma = new ArmaDeAsedio(posicionDeDespliegue);
        banco.gastarOro(200);
        poblacion.agregarHabitante();
        return arma;
    }


}

