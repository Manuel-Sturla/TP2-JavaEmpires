package Turnos;

import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoAldeanoTests {

    @Test
    void estadoInicialEsDesocupado() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeMoverPosicion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void realizarDosAccionesEnElMismoTurnoLevantaExcepcion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException {
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        assertThrows(UbicableEstaOcupadoException.class,() -> {
            aldeano.moverDerecha();
        });
    }

    @Test
    void estaDesocupadoLuegoDeMoverPosicionDesocuparUnTurno() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        aldeano.desocuparUnTurno();
        assertFalse(aldeano.estaOcupado());
    }

    @Test
<<<<<<< Updated upstream
    void estaOcupadoLuegoDeCrearEdificio() throws UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10, 10);
=======
    void estaOcupadoLuegoDeCrearEdificio() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(5, 5);
>>>>>>> Stashed changes
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.crearPlazaCentral();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
<<<<<<< Updated upstream
    void estaOcupadoLuegoDeConstruirEdificioDesocuparUnTurno() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(10, 10);
=======
    void estaOcupadoLuegoDeConstruirEdificioDesocuparUnTurno() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(5, 5);
>>>>>>> Stashed changes
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.crearPlazaCentral();
        aldeano.desocuparUnTurno();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
<<<<<<< Updated upstream
    void estaDesocupadoLuegoDeConstruirEdificioDesocuparUnTurno3Veces() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10, 10);
=======
    void estaDesocupadoLuegoDeConstruirEdificioDesocuparUnTurno3Veces() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, MovimientoNoPermitidoException {
        Mapa mapa = new Mapa(5, 5);
>>>>>>> Stashed changes
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        aldeano.desocuparUnTurno();
        aldeano.desocuparUnTurno();
        aldeano.desocuparUnTurno();
        assertFalse(aldeano.estaOcupado());
    }

    @Test
<<<<<<< Updated upstream
    void realizarUnaAccionUnTurnoDespuesDeConstruirEdificioLevantaExcepcion() throws UbicableEstaOcupadoException, PosicionNoDisponibleException{
        Mapa mapa = new Mapa(10, 10);
=======
    void realizarUnaAccionUnTurnoDespuesDeConstruirEdificioLevantaExcepcion() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(5, 5);
>>>>>>> Stashed changes
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.crearPlazaCentral();
        aldeano.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, aldeano::moverIzquierda);
    }


}
