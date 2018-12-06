package Modelo.Ubicables.Edificios;

import Controladores.Comandos.Atacar;
import Controladores.Comandos.Comando;
import Controladores.Comandos.CrearArmaDeAsedio;
import Modelo.Estados.Desocupado;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Jugador.Faccion;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.ArmaDeAsedio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Castillo extends Edificio {
    public Castillo(Posicion posicionRecibida, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionRecibida, 10, 4, constructorRecibido, 15);
        estado = new Desocupado();
    }

    public void crearArmaDeAsedio() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if (estado.estaOcupado()) {
            throw new UbicableEstaOcupadoException();
        }
        ArmaDeAsedio armaDeAsedio = null;
        armaDeAsedio = constructor.crearArmaDeAsedio(posicion.obtenerPosicionDeDespliegue());
        ocuparUnTurno();
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

    public ArrayList<Comando> getAcciones(){
        ArrayList<Comando> acciones = new ArrayList<>();
        acciones.add(new CrearArmaDeAsedio(this));
        return acciones;
    }
}
