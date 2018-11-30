package Ubicables.Edificios;

import Exceptions.PosicionInvalidaException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;

public class Castillo extends Edificio{
    public Castillo(Posicion posicionRecibida, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionRecibida,1000,4, constructorRecibido,15);
    }
}
