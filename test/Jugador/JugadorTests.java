package Jugador;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Castillo;
import Ubicables.Unidades.Aldeano;
import Ubicables.Edificios.PlazaCentral;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JugadorTests {

   @Test
    void crearJugadorLoCreaCorrectamente() throws PosicionFueraDeRangoException, NoSePudoConstruirException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(50,50);
        Faccion faccion = new Faccion();
        Posicion posicion1 = new Posicion(mapa,1,1);
        Posicion posicion2 = new Posicion(mapa,2,2);
        Posicion posicion3 = new Posicion(mapa,3,3);
        Posicion posicion4 = new Posicion(mapa,10,10);
        ArrayList aldeanos = new ArrayList();

        aldeanos.add(new Aldeano(posicion1,faccion));
        aldeanos.add(new Aldeano(posicion2,faccion));
        aldeanos.add(new Aldeano(posicion3,faccion));
        aldeanos.add(new Castillo(posicion4,faccion));

        Jugador jugador1 = new Jugador(aldeanos, faccion);
        assertTrue(jugador1 != null);
    }

    @Test
    void jugadorRecienCreadoTieneLosUbicablesIniciales() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(50,50);
        Faccion faccion = new Faccion();
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList aldeanos = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1,faccion);
        aldeanos.add(aldeano);
        Jugador jugador = new Jugador(aldeanos,faccion);
        assertTrue(jugador.getElementos().contains(aldeano));
    }

    @Test
    void jugadorRecienCreadoSinUbicablesNoTieneNinguno(){
        ArrayList aldeanos = new ArrayList();
        Faccion faccion = new Faccion();
        Jugador jugador = new Jugador(aldeanos,faccion);

        assertTrue(jugador.getElementos().isEmpty());
    }

    @Test
    void jugadorCreadoCon1UbicableAlIniciarTurnoDevuelveEseUbicable() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList aldeanos = new ArrayList();
        Faccion faccion = new Faccion();
        Aldeano aldeano = new Aldeano(posicion1,faccion);
        aldeanos.add(aldeano);
        Jugador jugador = new Jugador(aldeanos,faccion);
        assertTrue(jugador.iniciarTurno() == aldeano);
    }

    @Test
    void jugadorCreadoCon2UbicablesPedirSiguienteDevuelveElSegundo() throws PosicionFueraDeRangoException, NoSePudoConstruirException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        Posicion posicion2 = new Posicion(mapa,2,1);
        ArrayList ubicables = new ArrayList();
        Faccion faccion = new Faccion();
        Aldeano aldeano = new Aldeano(posicion1,faccion);
        PlazaCentral plazaCentral = new PlazaCentral(posicion2,faccion);

        ubicables.add(aldeano);
        ubicables.add(plazaCentral);
        Jugador jugador = new Jugador(ubicables,faccion);

        jugador.iniciarTurno();
        assertTrue(jugador.siguiente()==plazaCentral);
    }
/*
    @Test
    void jugadorCreadoSinUbicablesAlIniciarTurnoNoHaceNada() {
        ArrayList listaVacia = new ArrayList();
        Faccion faccion = new Faccion();
        Jugador jugador = new Jugador(listaVacia,faccion);

        assertTrue(jugador.iniciarTurno() == null);
    }

    @Test
    void matarAldeanoPertenecienteAlJugadorLoQuitaDeSusUbicables() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        Faccion faccion = new Faccion();
        ArrayList ubicables = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1, faccion);
        ubicables.add(aldeano);
        Jugador jugador = new Jugador(ubicables,faccion);
        Aldeano aldeanoJugador = (Aldeano)jugador.iniciarTurno();

        aldeanoJugador.recibirDanio(50); //Se pone en estado Muerto
        jugador.siguiente(); //Termino el turno del jugador porque no tiene mas Ubicables
        assertTrue(jugador.getElementos().isEmpty());
    }

    @Test
    void destuirEdificioPertenecienteAlJugadorLoQuitaDeSusUbicables() throws NoSePudoConstruirException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList ubicables = new ArrayList();
        Faccion faccion = new Faccion();
        PlazaCentral plazaCentral = new PlazaCentral(posicion1,faccion);
        ubicables.add(plazaCentral);
        Jugador jugador = new Jugador(ubicables,faccion);
        PlazaCentral plazaJugador = (PlazaCentral) jugador.iniciarTurno();

        plazaJugador.recibirDanio(500); //Se pone en estado Muerto
        jugador.siguiente(); //Termino el turno del jugador porque no tiene mas Ubicables
        assertTrue(jugador.getElementos().isEmpty());
    }
*/

// PRUEBA CREAR EDIFICIOS Y UNIDADES
    @Test
    void crearPlazaCentralLaCreaYSeAgregaALosElementosUbicables() throws PosicionFueraDeRangoException, NoSePudoConstruirException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        Posicion posicionCostruccion = new Posicion(mapa,2,1);
        ArrayList ubicables = new ArrayList();
        Faccion faccion = new Faccion();
        Aldeano aldeano = new Aldeano(posicion1, faccion);
        ubicables.add(aldeano);
        Jugador jugador = new Jugador(ubicables,faccion);
        Aldeano aldeanoJugador = (Aldeano)jugador.iniciarTurno();

        PlazaCentral plazaCentralNueva = aldeanoJugador.crearPlazaCentral(posicionCostruccion);
        jugador.agregar(plazaCentralNueva); //ACA ES UN METODO QUE SE TIENE QUE EJECUTAR MANUALMENTE POSIBLEMENTE SEA MEJOR AUTOMATICAMENTE
        assertTrue(jugador.getElementos().contains(plazaCentralNueva));
    }
/*
    @Test
    void crearAldeanoLoCreaYSeAgregaALosElementosUbicables() throws NoSePudoConstruirException, PosicionFueraDeRangoException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList ubicables = new ArrayList();
        PlazaCentral plazaCentral = new PlazaCentral(posicion1);
        ubicables.add(plazaCentral);
        Jugador jugador = new Jugador(ubicables);

        //Hago que pasen 3 turnos para que se termine de construir la plaza central
        for (int i= 0; i<3; i++){
            jugador.iniciarTurno();
            jugador.siguiente(); //Termina el turno porque no tiene mas elementos
        }
        //Inicio el 4to turno
        jugador.iniciarTurno();
        PlazaCentral plazaJugador = (PlazaCentral) jugador.iniciarTurno();


        Aldeano aldeanoNuevo = plazaJugador.crearAldeano();
        jugador.agregar(aldeanoNuevo);
        assertTrue(jugador.getElementos().contains(aldeanoNuevo));
    }
/*
    @Test
    void crearAldeanoLoAgregaAElementosUbicables(){
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        Posicion posicion2 = new Posicion(mapa,2,2);
        Posicion posicion3 = new Posicion(mapa,3,3);
        Posicion posicion4 = new Posicion(mapa,10,10);
        Aldeano aldeanos[];
        aldeanos = new Aldeano[3];
        aldeanos[0] = new Aldeano(posicion1);
        aldeanos[1] = new Aldeano(posicion2);
        aldeanos[2] = new Aldeano(posicion3);
        Castillo castillo = new Castillo(posicion4);
        Jugador jugador1 = new Jugador(aldeanos, castillo);
        jugador1.
    }
    */
}
