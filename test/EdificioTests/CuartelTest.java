package EdificioTests;

import Exceptions.PosicionFueraDeRangoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Cuartel;
import org.junit.jupiter.api.Test;

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

}
