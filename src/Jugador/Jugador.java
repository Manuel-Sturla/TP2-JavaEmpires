package Jugador;

import Exceptions.OroInsuficienteException;
import Exceptions.PosicionInvalidaException;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Edificios.Castillo;
import Ubicables.Unidades.Aldeano;
import Ubicables.Edificios.PlazaCentral;

import java.util.ArrayList;
import java.util.Observable;

public class Jugador extends Observable {

    Banco banco;
    Faccion faccion;
    ConstructorDeUbicables constructor;
    Poblacion poblacion;
    Mapa mapa;

    public Jugador(Mapa mapaRecibido){
        mapa = mapaRecibido;
    }

    public void inicializarJugador(int numeroJugador) throws PosicionInvalidaException, OroInsuficienteException {
        banco = new Banco(215); //Crear 3 aldeanos y 1 plaza consume 175 de oro
        faccion = new Faccion();
        poblacion = new Poblacion();
        constructor = new ConstructorDeUbicables(banco, poblacion);
        if (numeroJugador == 1) { crearUbicablesIniciales(1, 1);}
        else {crearUbicablesIniciales(45, -1);}

    }

    private void crearUbicablesIniciales(int posicionInicial, int direccion) throws PosicionInvalidaException, OroInsuficienteException {
        Posicion posicionCastillo = new Posicion(mapa, posicionInicial ,posicionInicial);
        Posicion posicionPlaza = new Posicion(mapa, posicionInicial+6*direccion,posicionInicial);
        Posicion posicionAldeano1 = new Posicion(mapa, posicionInicial+1*direccion,posicionInicial+5*direccion);
        Posicion posicionAldeano2 = new Posicion(mapa, posicionInicial+2*direccion,posicionInicial+5*direccion);
        Posicion posicionAldeano3 = new Posicion(mapa, posicionInicial+3*direccion,posicionInicial+5*direccion);

        Castillo castillo = new Castillo(posicionCastillo, constructor);
        PlazaCentral plaza = constructor.crearPlazaCentral(posicionPlaza);
        Aldeano aldeano1 = constructor.crearAldeano(posicionAldeano1);
        Aldeano aldeano2 = constructor.crearAldeano(posicionAldeano2);
        Aldeano aldeano3 = constructor.crearAldeano(posicionAldeano3);

        castillo.asignarFaccion(faccion);
        plaza.asignarFaccion(faccion);
        aldeano1.asignarFaccion(faccion);
        aldeano2.asignarFaccion(faccion);
        aldeano3.asignarFaccion(faccion);
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

    public void iniciarTurno() throws PosicionInvalidaException {
        faccion.desocuparUnTurnoTodosLosElementos();
        banco.agregarOro(faccion.obtenerCantidadDeAldeanosDesocupados()*20);
        Castillo castillo = faccion.obtenerCastillo();
        castillo.atacar();

    }

    public ArrayList obtenerUbicablesDesocupados() {
        ArrayList desocupados = faccion.getDesocupados();
        return desocupados;
    }

    public void terminarTurno() {
        faccion.ocuparUnTurnoTodosLosElementosDesocupados();
        notifyObservers();
    }
}
