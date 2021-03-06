package PruebasUbicables;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Jugador.Banco;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Jugador.Faccion;
import Modelo.Jugador.Poblacion;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Unidades.Aldeano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoTest {

    Mapa mapa = new Mapa(5, 5);
    Banco banco = new Banco(100);
    Poblacion poblacion = new Poblacion();
    ConstructorDeUbicables constructor = new ConstructorDeUbicables(banco, poblacion);
    Posicion posicion = new Posicion(mapa, 0, 0);
    Aldeano aldeano = new Aldeano(posicion, constructor);

    public EstadoTest() throws PosicionInvalidaException {
    }

    @Test
    void estadoInicialEsDesocupado() {
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeMoverPosicion() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        aldeano.moverDerecha();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void realizarDosAccionesEnElMismoTurnoLevantaExcepcion() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        aldeano.moverDerecha();
        assertThrows(UbicableEstaOcupadoException.class,() -> {
            aldeano.moverDerecha();
        });
    }

    @Test
    void estaDesocupadoLuegoDeMoverPosicionDesocuparUnTurno() throws UbicableEstaOcupadoException, PosicionInvalidaException {
        aldeano.moverDerecha();
        aldeano.desocuparUnTurno();
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeCrearEdificio() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Faccion faccion = new Faccion();
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void estaOcupadoLuegoDeConstruirEdificioDesocuparUnTurno() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Faccion faccion = new Faccion();
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();
        aldeano.desocuparUnTurno();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void estaDesocupadoLuegoDeConstruirEdificioDesocuparUnTurno3Veces() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException {
        Faccion faccion = new Faccion();
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();
        aldeano.desocuparUnTurno();
        aldeano.desocuparUnTurno();
        aldeano.desocuparUnTurno();
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void realizarUnaAccionUnTurnoDespuesDeConstruirEdificioLevantaExcepcion() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException {
        Faccion faccion = new Faccion();
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();
        aldeano.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, aldeano::moverIzquierda);
    }
}
