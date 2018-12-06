package Modelo.Ubicables.Edificios;

import Controladores.Comandos.Atacar;
import Controladores.Comandos.Comando;
import Controladores.Comandos.CrearAldeano;
import Modelo.Estados.Ocupado;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Unidades.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    public PlazaCentral(Posicion posicionConstruccion, ConstructorDeUbicables constructorRecibido) throws PosicionInvalidaException {
        super(posicionConstruccion, 450, 2, constructorRecibido, 25);
        estado = new Ocupado(3);
    }

    public void crearAldeano() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UnidadesMaximasException {
        if(estado.estaOcupado()){
            throw new UbicableEstaOcupadoException();
        }
        ocuparUnTurno();
        Aldeano aldeano = null;
        aldeano = constructor.crearAldeano(posicion.obtenerPosicionDeDespliegue());

        aldeano.asignarFaccion(faccion);
    }

    public ArrayList<Comando> getAcciones(){
        ArrayList<Comando> acciones = new ArrayList<>();
        acciones.add(new CrearAldeano(this));
        return acciones;
    }

}
