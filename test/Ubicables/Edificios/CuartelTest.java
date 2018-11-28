package Ubicables.Edificios;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuartelTest {

    @Test
    void creoUnCuartel() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion);
        assertTrue(cuartel != null);
    }

    @Test
    void creoElCuartelEstaOcupado() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion);
        assertTrue(cuartel.estaOcupado());
    }
    @Test
    void creoUnEspadachin() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion, faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        Espadachin espadachin = cuartel.crearEspadachin();
        assertTrue(espadachin != null);
    }

    @Test
    void creoUnArquero() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion, faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        Arquero arquero = cuartel.crearArquero();
        assertTrue(arquero != null);
    }

    @Test
    void creoUnEspadachinCuandoElCuartelEstaOcupado() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion, faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, cuartel::crearEspadachin);
    }

    @Test
    void creoUnEspadachinYocupasuEspacio() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion, faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.crearEspadachin();
        Posicion posicionEspadachin = new Posicion(mapa,1,3);
        assertTrue(mapa.celdaEstaOcupada(posicionEspadachin));
    }
}
