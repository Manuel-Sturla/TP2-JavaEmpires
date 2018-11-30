package Ubicables.Edificios;

import Exceptions.PosicionInvalidaException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Posiciones.PosicionEdificio;
import Ubicables.Ubicable;

public abstract class Edificio extends Ubicable {

    protected PosicionEdificio posicion;
    protected ConstructorDeUbicables constructor;

    public Edificio(Posicion posicionCostruccion, int vidaRecibida, int largo, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        posicion = new PosicionEdificio(posicionCostruccion, largo);
        constructor = constructorRecibido;
        if(!posicion.estanDisponible()) throw new PosicionInvalidaException();
        posicion.ocuparPosiciones(this);
        vida = vidaRecibida;
    }
}
