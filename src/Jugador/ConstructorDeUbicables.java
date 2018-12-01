package Jugador;

import Exceptions.PosicionInvalidaException;
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


    public Aldeano crearAldeano(Posicion posicionDespliegue) throws PosicionInvalidaException {
        banco.gastarOro(25);
        poblacion.agregarHabitante();
        return new Aldeano(posicionDespliegue, this);
    }

    public PlazaCentral crearPlazaCentral(Posicion posicionConstruccion) throws PosicionInvalidaException {
        banco.gastarOro(100);
        return new PlazaCentral(posicionConstruccion, this);
    }

    public Cuartel crearCuartel(Posicion posicionConstruccion) throws PosicionInvalidaException {
        banco.gastarOro(50);
        return new Cuartel(posicionConstruccion, this);
    }

    public Espadachin crearEspadachin(Posicion posicionDespliegue) throws PosicionInvalidaException {
        banco.gastarOro(50);
        poblacion.agregarHabitante();
        return new Espadachin(posicionDespliegue);
    }

    public Arquero crearArquero(Posicion posicionDeDespliegue) throws PosicionInvalidaException {
        banco.gastarOro(75);
        poblacion.agregarHabitante();
        return new Arquero(posicionDeDespliegue);
    }

    public ArmaDeAsedio crearArmaDeAsedio(Posicion posicionDeDespliegue) throws PosicionInvalidaException {
        banco.gastarOro(200);
        poblacion.agregarHabitante();
        return new ArmaDeAsedio(posicionDeDespliegue);
    }


}
