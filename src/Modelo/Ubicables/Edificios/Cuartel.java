package Modelo.Ubicables.Edificios;

import Controladores.Comandos.Atacar;
import Controladores.Comandos.Comando;
import Controladores.Comandos.CrearArquero;
import Controladores.Comandos.CrearEspadachin;
import Modelo.Estados.Ocupado;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Unidades.Arquero;
import Modelo.Ubicables.Unidades.Espadachin;

import java.util.ArrayList;

public class Cuartel extends Edificio {

    public Cuartel(Posicion posicionCostruccion, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionCostruccion, 250, 2, constructorRecibido, 50);
        estado = new Ocupado(3);
    }

    public void crearEspadachin() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        Espadachin espadachin = constructor.crearEspadachin(posicion.obtenerPosicionDeDespliegue());
        ocuparUnTurno();
        espadachin.asignarFaccion(faccion);
    }

    public void crearArquero() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        Arquero arquero = constructor.crearArquero(posicion.obtenerPosicionDeDespliegue());
        ocuparUnTurno();
        arquero.asignarFaccion(faccion);
    }

    public ArrayList<Comando> getAcciones(){
        ArrayList<Comando> acciones = new ArrayList<>();
        acciones.add(new CrearArquero(this));
        acciones.add(new CrearEspadachin(this));
        return acciones;
    }
}
