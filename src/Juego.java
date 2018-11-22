import Exceptions.MapaMuyPequeñoException;
import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Jugador.Jugador;
import Tablero.Mapa;
import Tablero.Posicion;
import Turnos.ControladorTurnos;
import Ubicables.Edificios.Castillo;
import Ubicables.Edificios.PlazaCentral;
import Ubicables.Ubicable;
import Ubicables.Unidades.Aldeano;
import Jugador.Faccion;

import java.util.ArrayList;

public class Juego {
    Mapa mapa;
    ControladorTurnos controladorTurnos;

    public void iniciar(int largo, int ancho) throws MapaMuyPequeñoException {
        mapa = new Mapa(largo, ancho);
        ArrayList <Ubicable> ubicablesJugador1;
        ArrayList <Ubicable> ubicablesJugador2;
        Faccion faccionJugador1 = new Faccion();
        Faccion faccionJugador2 = new Faccion();
        try{
            ubicablesJugador1 = this.crearUbicablesIniciales(largo/6, ancho/6, 1,faccionJugador1 );
            ubicablesJugador2 = this.crearUbicablesIniciales(largo/6, ancho/6, 1, faccionJugador2);

        }catch (NoSePudoConstruirException e) {
            throw new MapaMuyPequeñoException();
        } catch (PosicionFueraDeRangoException e) {
            throw new MapaMuyPequeñoException();
        }

        Jugador jugador1 = new Jugador(ubicablesJugador1, faccionJugador1);
        Jugador jugador2 = new Jugador(ubicablesJugador2, faccionJugador2);
        ArrayList <Jugador> jugadores = new ArrayList<Jugador>();

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        controladorTurnos = new ControladorTurnos(jugadores);
        jugador1.setControlador(controladorTurnos);
        jugador2.setControlador(controladorTurnos);

    }

    private ArrayList <Ubicable> crearUbicablesIniciales(int coordenadaHorizontalInicial, int coordenadaVerticalInicial,int direccion, Faccion faccion) throws NoSePudoConstruirException, PosicionFueraDeRangoException {

        Posicion posicionCastillo = new Posicion(mapa, coordenadaHorizontalInicial ,coordenadaVerticalInicial);
        Posicion posicionPlaza = new Posicion(mapa, coordenadaHorizontalInicial,coordenadaVerticalInicial+6*direccion);
        Posicion posicionAleano1 = new Posicion(mapa, coordenadaHorizontalInicial+1*direccion,coordenadaVerticalInicial+5*direccion);
        Posicion posicionAleano2 = new Posicion(mapa, coordenadaHorizontalInicial+2*direccion,coordenadaVerticalInicial+5*direccion);
        Posicion posicionAleano3 = new Posicion(mapa, coordenadaHorizontalInicial+3*direccion,coordenadaVerticalInicial+5*direccion);


        Castillo castillo = new Castillo(posicionCastillo,faccion);
        PlazaCentral plazaCentral = new PlazaCentral(posicionPlaza,faccion);
        Aldeano aldeano1 = new Aldeano(posicionAleano1,faccion);
        Aldeano aldeano2 = new Aldeano(posicionAleano2,faccion);
        Aldeano aldeano3 = new Aldeano(posicionAleano3,faccion);

        ArrayList <Ubicable> elementosIniciales = new ArrayList <Ubicable>();
        elementosIniciales.add(castillo);
        elementosIniciales.add(plazaCentral);
        elementosIniciales.add(aldeano1);
        elementosIniciales.add(aldeano2);
        elementosIniciales.add(aldeano3);
        return elementosIniciales;

    }


    public Jugador obtenerJugadorActual() {
        return controladorTurnos.obtenerJugadorActual();
    }
}
