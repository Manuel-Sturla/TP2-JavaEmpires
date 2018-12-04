package PruebasUbicables.PruebasEdificios;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.Banco;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Jugador.Faccion;
import Modelo.Jugador.Poblacion;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Cuartel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuartelTest {
    Mapa mapa = new Mapa(20,20);
    Posicion posicionCostruccion = new Posicion(mapa,2,2);
    Banco banco = new Banco(300);
    Poblacion poblacion = new Poblacion();
    ConstructorDeUbicables constructor = new ConstructorDeUbicables(banco, poblacion);

    @Test
    void creoUnCuartel() throws PosicionInvalidaException {
        Cuartel cuartel = new Cuartel(posicionCostruccion, constructor);
        assertTrue(cuartel != null);
    }

    @Test
    void creoElCuartelEstaOcupado() throws PosicionInvalidaException {
        Cuartel cuartel = new Cuartel(posicionCostruccion, constructor);
        assertTrue(cuartel.estaOcupado());
    }

    @Test
    void creoUnEspadachinCuandoElCuartelEstaOcupadoLevantaExcepcion() throws PosicionInvalidaException {
        Cuartel cuartel = new Cuartel(posicionCostruccion, constructor);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, cuartel::crearEspadachin);
    }

    @Test
    void creoUnEspadachinOcupaSuPosicion() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException, UnidadesMaximasException {
        Faccion faccion = new Faccion();
        Cuartel cuartel = new Cuartel(posicionCostruccion, constructor);
        cuartel.asignarFaccion(faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.crearEspadachin();
        Posicion posicionEspadachin = new Posicion(mapa,1,3);
        assertTrue(mapa.celdaEstaOcupada(posicionEspadachin));
    }
}
