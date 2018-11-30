package PruebasUbicables.PruebasEdificios;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Banco;
import Jugador.ConstructorDeUbicables;
import Jugador.Faccion;
import Jugador.Poblacion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;
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
    void creoUnEspadachinOcupaSuPosicion() throws PosicionInvalidaException, UbicableEstaOcupadoException {
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