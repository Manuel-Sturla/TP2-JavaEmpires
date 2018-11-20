package Jugador;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Aldeano;
import Ubicables.Castillo;
import Ubicables.PlazaCentral;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JugadorTests {

/* PRUEBA CREAR JUGADOR CON ALDEANOS Y CASTILLOS
    @Test
    void crearJugadorLoCreaCorrectamente() throws PosicionFueraDeRangoException, NoSePudoConstruirException {
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
        assertTrue(jugador1 != null);
    }
*/
    @Test
    void jugadorRecienCreadoTieneLosUbicablesIniciales() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList aldeanos = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1);
        aldeanos.add(aldeano);
        Jugador jugador = new Jugador(aldeanos);
        assertTrue(jugador.getElementos().contains(aldeano));
    }

    @Test
    void jugadorRecienCreadoSinUbicablesNoTieneNinguno(){
        ArrayList listaVacia = new ArrayList();
        Jugador jugador = new Jugador(listaVacia);

        assertTrue(jugador.getElementos().isEmpty());
    }

    @Test
    void jugadorCreadoCon1UbicableAlIniciarTurnoDevuelveEseUbicable() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList aldeanos = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1);
        aldeanos.add(aldeano);
        Jugador jugador = new Jugador(aldeanos);
        assertTrue(jugador.iniciarTurno() == aldeano);
    }

    @Test
    void jugadorCreadoCon2UbicablesPedirSiguienteDevuelveElSegundo() throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        Posicion posicion2 = new Posicion(mapa,2,1);
        ArrayList ubicables = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1);
        PlazaCentral plazaCentral = new PlazaCentral(posicion2);

        ubicables.add(aldeano);
        ubicables.add(plazaCentral);
        Jugador jugador = new Jugador(ubicables);

        jugador.iniciarTurno();
        assertTrue(jugador.siguiente()==plazaCentral);
    }

    @Test
    void jugadorCreadoSinUbicablesAlIniciarTurnoNoHaceNada() {
        ArrayList listaVacia = new ArrayList();
        Jugador jugador = new Jugador(listaVacia);

        assertTrue(jugador.iniciarTurno() == null);
    }

    @Test
    void matarAldeanoPertenecienteAlJugadorLoQuitaDeSusUbicables() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList ubicables = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1);
        ubicables.add(aldeano);
        Jugador jugador = new Jugador(ubicables);
        Aldeano aldeanoJugador = (Aldeano)jugador.iniciarTurno();

        aldeanoJugador.quitarVida(50); //Se pone en estado Muerto
        jugador.siguiente(); //Termino el turno del jugador porque no tiene mas Ubicables
        assertTrue(jugador.getElementos().isEmpty());
    }

    @Test
    void destuirEdificioPertenecienteAlJugadorLoQuitaDeSusUbicables() throws NoSePudoConstruirException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        ArrayList ubicables = new ArrayList();
        PlazaCentral plazaCentral = new PlazaCentral(posicion1);
        ubicables.add(plazaCentral);
        Jugador jugador = new Jugador(ubicables);
        PlazaCentral plazaJugador = (PlazaCentral) jugador.iniciarTurno();

        plazaJugador.quitarVida(500); //Se pone en estado Muerto
        jugador.siguiente(); //Termino el turno del jugador porque no tiene mas Ubicables
        assertTrue(jugador.getElementos().isEmpty());
    }


// PRUEBA CREAR EDIFICIOS Y UNIDADES
    @Test
    void crearPlazaCentralLaCreaYSeAgregaALosElementosUbicables() throws PosicionFueraDeRangoException, NoSePudoConstruirException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(50,50);
        Posicion posicion1 = new Posicion(mapa,1,1);
        Posicion posicionCostruccion = new Posicion(mapa,2,1);
        ArrayList ubicables = new ArrayList();
        Aldeano aldeano = new Aldeano(posicion1);
        ubicables.add(aldeano);
        Jugador jugador = new Jugador(ubicables);
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
