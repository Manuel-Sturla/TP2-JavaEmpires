package EdificioTests;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.Espadachin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuartelTest {

    @Test
    void creoUnCuartel() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion);
        assertTrue(cuartel != null);
    }

    @Test
    void creoElCuartelEstaOcupado() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion);
        assertTrue(cuartel.estaOcupada());
    }
    @Test
    void creoUnEspadachin() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException {
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
    void creoUnEspadachinCuandoElCuartelEstaOcupado() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion, faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, cuartel::crearEspadachin);
    }

}
