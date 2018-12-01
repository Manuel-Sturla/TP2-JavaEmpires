package Jugador;

import Exceptions.PosicionInvalidaException;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Edificios.PlazaCentral;

import java.util.ArrayList;

public class Jugador {
    Banco banco;
    Faccion faccion;
    ConstructorDeUbicables constructor;
    Poblacion poblacion;
    Mapa mapa;

    public Jugador(Mapa mapaRecibido){
        mapa = mapaRecibido;
    }

    public void inicializarJugador() throws PosicionInvalidaException {
        banco = new Banco(215); //Crear 3 aldeanos y 1 plaza consume 175 de oro
        faccion = new Faccion();
        poblacion = new Poblacion();
        constructor = new ConstructorDeUbicables(banco, poblacion);
        crearAldeanos(3);
        crearPlazaCentral();
    }

    private void crearPlazaCentral() throws PosicionInvalidaException {
        Posicion posicion = new Posicion(mapa, 1,1);
        PlazaCentral plaza = constructor.crearPlazaCentral(posicion);
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
    }

    private void crearAldeanos(int cantidadDeAldeanos) throws PosicionInvalidaException {
        for (int i = 0; i < cantidadDeAldeanos; i++) {
            Posicion posicion = new Posicion(mapa, i, 3);
            Aldeano aldeano = constructor.crearAldeano(posicion);
            aldeano.asignarFaccion(faccion);
        }
    }

    public ArrayList obtenerAldeanos() {
        return faccion.obtenerAldeanos();
    }

    public int getOro() {
        return banco.getCantidadDeOro();
    }

    public int getPoblacion() {
        return poblacion.getPoblacion();
    }

    public void iniciarTurno() {
        faccion.desocuparUnTurnoTodosLosElementos();
        banco.agregarOro(faccion.obtenerCantidadDeAldeanosDesocupados()*20);
        //Castillo ataca
    }

    public ArrayList obtenerUbicablesDesocupados() {
        ArrayList desocupados = faccion.getDesocupados();
        return desocupados;
    }

    public void terminarTurno() {
        faccion.ocuparUnTurnoTodosLosElementosDesocupados();
        //Aca viene lo del controlador de turnos
    }
}
