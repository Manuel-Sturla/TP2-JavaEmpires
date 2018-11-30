package Ubicables.Edificios;

import Estados.Desocupado;
import Estados.Ocupado;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.ConstructorDeUbicables;
import Posiciones.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Unidades.ArmaDeAsedio;

public class Castillo extends Edificio{
    public Castillo(Posicion posicionRecibida, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionRecibida,1000,4, constructorRecibido,15);
        estado = new Desocupado();
    }

    public void crearArmaDeAsedio() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        ArmaDeAsedio armaDeAsedio = constructor.crearArmaDeAsedio(posicion.obtenerPosicionDeDespliegue());
        armaDeAsedio.asignarFaccion(faccion);
    }

}

