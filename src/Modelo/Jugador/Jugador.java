package Modelo.Jugador;

import Modelo.Exceptions.FinDelJuego;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Castillo;
import Modelo.Ubicables.Unidades.Aldeano;
import Modelo.Ubicables.Edificios.PlazaCentral;

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

    public void inicializarJugador(int numeroJugador) throws PosicionInvalidaException {
        banco = new Banco(215); //Crear 3 aldeanos y 1 plaza consume 175 de oro
        faccion = new Faccion();
        poblacion = new Poblacion();
        constructor = new ConstructorDeUbicables(banco, poblacion);
        if (numeroJugador == 1) { crearUbicablesIniciales(mapa.getLargo()/6,mapa.getAncho()/6, 1);}
        else {crearUbicablesIniciales(mapa.getLargo()-2*mapa.getLargo()/6,mapa.getAncho()-2*mapa.getAncho()/6, 1);}

    }

    private void crearUbicablesIniciales(int coorHorizontal,int coorVertical, int direccion) throws PosicionInvalidaException {
        Posicion posicionCastillo = new Posicion(mapa, coorHorizontal, coorVertical);
        Posicion posicionPlaza = new Posicion(mapa, coorHorizontal + 6 * direccion, coorVertical);
        Posicion posicionAldeano1 = new Posicion(mapa, coorHorizontal + 1 * direccion, coorVertical + 5 * direccion);
        Posicion posicionAldeano2 = new Posicion(mapa, coorHorizontal + 2 * direccion, coorVertical + 5 * direccion);
        Posicion posicionAldeano3 = new Posicion(mapa, coorHorizontal + 3 * direccion, coorVertical + 5 * direccion);

        Castillo castillo = new Castillo(posicionCastillo, constructor);

        try {
            PlazaCentral plaza = constructor.crearPlazaCentral(posicionPlaza);
            plaza.desocuparUnTurno();
            plaza.desocuparUnTurno();
            plaza.desocuparUnTurno();
            Aldeano aldeano1 = constructor.crearAldeano(posicionAldeano1);
            Aldeano aldeano2 = constructor.crearAldeano(posicionAldeano2);
            Aldeano aldeano3 = constructor.crearAldeano(posicionAldeano3);
            castillo.asignarFaccion(faccion);
            plaza.asignarFaccion(faccion);
            aldeano1.asignarFaccion(faccion);
            aldeano2.asignarFaccion(faccion);
            aldeano3.asignarFaccion(faccion);
        } catch (OroInsuficienteException e){
        } catch (UnidadesMaximasException e){}



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

    public void iniciarTurno() throws PosicionInvalidaException, FinDelJuego {
        if(faccion.castilloFueDestruido()){
            throw new FinDelJuego();
        }
        poblacion.actualizarPoblacion(faccion);
        faccion.desocuparUnTurnoTodosLosElementos();
        banco.agregarOro(faccion.obtenerCantidadDeAldeanosDesocupados()*20);
        Castillo castillo = faccion.obtenerCastillo();
        castillo.atacar();
        setChanged();

    }

    public ArrayList obtenerUbicablesDesocupados() {
        ArrayList desocupados = faccion.getDesocupados();
        return desocupados;
    }

    public void terminarTurno() {
        faccion.ocuparUnTurnoTodosLosElementosDesocupados();
        notifyObservers();
    }

    public Castillo obtenerCastillo(){
        return faccion.obtenerCastillo();
    }

    public Faccion getFaccion() {
        return faccion;
    }
}
