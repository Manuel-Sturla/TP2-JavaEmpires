package Turnos;

import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoAldeanoTests {

    @Test
    void estadoInicialEsDesocupado(){
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeMoverPosicion() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void realizarDosAccionesEnElMismoTurnoLevantaExcepcion() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10, 10);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        assertThrows(UbicableEstaOcupadoException.class,() -> {
            aldeano.moverDerecha();
        });
    }

    @Test
    void estaDesocupadoLuegoDeMoverPosicionDesocuparUnTurno() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        aldeano.desocuparUnTurno();
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeCrearEdificio() throws UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.crearEdificio();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeConstruirEdificioDesocuparUnTurno() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.crearEdificio();
        aldeano.desocuparUnTurno();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void estaDesocupadoLuegoDeConstruirEdificioDesocuparUnTurno3Veces() throws UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        aldeano.desocuparUnTurno();
        aldeano.desocuparUnTurno();
        aldeano.desocuparUnTurno();
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void realizarUnaAccionUnTurnoDespuesDeConstruirEdificioLevantaExcepcion() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.crearEdificio();
        aldeano.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, aldeano::moverDerecha);
    }


}
