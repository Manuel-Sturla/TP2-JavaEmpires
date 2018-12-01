package Ubicables.Edificios;

import Estados.Desocupado;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.ConstructorDeUbicables;
import Jugador.Faccion;
import Posiciones.Posicion;
import Ubicables.Ubicable;
import Ubicables.Unidades.ArmaDeAsedio;

import java.util.HashSet;
import java.util.Iterator;

public class Castillo extends Edificio {
    public Castillo(Posicion posicionRecibida, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionRecibida, 1000, 4, constructorRecibido, 15);
        estado = new Desocupado();
    }

    public void crearArmaDeAsedio() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        if (estado.estaOcupado()) {
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        ArmaDeAsedio armaDeAsedio = constructor.crearArmaDeAsedio(posicion.obtenerPosicionDeDespliegue());
        armaDeAsedio.asignarFaccion(faccion);
    }

    public void atacar() throws PosicionInvalidaException {
        HashSet<Ubicable> unidadesEnRango = this.obtenerUnidadesEnRango();
        Iterator iterador = unidadesEnRango.iterator();
        while (iterador.hasNext()) {
            Ubicable ubicableActual = (Ubicable) iterador.next();
            if (faccion.perteneceFaccion(ubicableActual) || ubicableActual == null) continue;
            ubicableActual.recibirDanio(this);
        }

    }

    public HashSet<Ubicable> obtenerUnidadesEnRango() throws PosicionInvalidaException {
        return posicion.obtenerUnidadesEnRango(3);

    }

    @Override
    public void asignarFaccion(Faccion faccionRecibida) {
        faccion = faccionRecibida;
        faccion.agregarCastillo(this);
    }
}

