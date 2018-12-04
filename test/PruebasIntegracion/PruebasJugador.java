package PruebasIntegracion;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.Mapa;
import Modelo.Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebasJugador {

    Mapa mapa = new Mapa(30,30);
    Jugador jugador = new Jugador(mapa);

    //Pruebas inicializa Modelo.Juego.Modelo.Juego:
    @Test
    void unJugadorRecienInicializadoTiene3Aldeanos() throws PosicionInvalidaException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        ArrayList aldeanos = jugador.obtenerAldeanos();
        assertTrue(aldeanos.size() == 3);
    }

    @Test
    void unJugadorRecienInicializadoTiene100DeOroEnSuPrimerTurno() throws PosicionInvalidaException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        jugador.iniciarTurno();
        assertEquals(jugador.getOro() , 100);
    }

    @Test
    void unJugadorRecienInicializadoTiene3DePoblacion() throws PosicionInvalidaException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        assertTrue(jugador.getPoblacion() == 3);
    }

    //Pruebas iniciar turno:
    @Test
    void unJugadorCuandoComienzaElPrimerTurnoTieneTodosSusUbicablesDesocupado() throws PosicionInvalidaException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        jugador.iniciarTurno();
        assertTrue(jugador.obtenerUbicablesDesocupados().size() == 4);
    }

    //Pruebas terminar turno:
    @Test
    void unJugadorCuandoTerminaSuTurnoTieneTodosSusUbicablesOcupados() throws PosicionInvalidaException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        jugador.iniciarTurno();
        jugador.terminarTurno();
        assertTrue(jugador.obtenerUbicablesDesocupados().size() == 0);
    }

    @Test
    void siNigunoDeLosAldeanosTrabajoElTurnoAnteriorElJugadorRecibe60DeOroEnELSegundoTurno() throws PosicionInvalidaException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        jugador.iniciarTurno();
        jugador.terminarTurno();
        jugador.iniciarTurno();
        assertTrue(jugador.getOro() == 160);
    }

    @Test
    void siNingunoDeLosAldeanosEstaConstruyendoUnEdificioElJugadorRecibe60DeOroEnELSegundoTurno() throws PosicionInvalidaException, UbicableEstaOcupadoException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        jugador.iniciarTurno();
        ArrayList ubicables = jugador.obtenerAldeanos();
        for (int i = 0; i < 3; i++) {
            Aldeano aldeano = (Aldeano)ubicables.get(i);
            aldeano.moverArriba();
        }
        jugador.terminarTurno();
        jugador.iniciarTurno();
        assertTrue(jugador.getOro() == 160);
    }

    @Test
    void siUnoDeLosAldeanosEstaConstruyendoUnEdificioElJugadorRecibe40DeOroEnELSegundoTurno() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UnidadesMaximasException {
        jugador.inicializarJugador(1);
        jugador.iniciarTurno();
        ArrayList aldeanos = jugador.obtenerAldeanos();
        for (int i = 0; i < 2; i++) {
            Aldeano aldeano = (Aldeano)aldeanos.get(i);
            aldeano.moverArriba();
        }
        Aldeano aldeano = (Aldeano)aldeanos.get(2);
        aldeano.crearPlazaCentral();
        jugador.terminarTurno();
        jugador.iniciarTurno();
        assertEquals(40, jugador.getOro());//Gasto 100 en construir la plazaCentral
    }


}
