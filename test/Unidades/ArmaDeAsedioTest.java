package Unidades;

import Exceptions.*;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Unidades.ArmaDeAsedio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmaDeAsedioTest {
    Mapa mapa = new Mapa(10,10);
    Posicion posicion = new Posicion(mapa, 3,3);
    Faccion faccion = new Faccion();

    @Test
    void moverArmaALaDerechaCuandoNoEstaMontadaALaMueve() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion, faccion);
        armaDeAsedio.moverDerecha();
        Posicion posicionLlegada = new Posicion(mapa, 4,3);
        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }

    @Test
    void moverArmaCuandoEstaMontadaNoSeMueve() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion, faccion);
        armaDeAsedio.montarArma();
        Posicion posicionLlegada = new Posicion(mapa, 4,3);
        assertTrue(!mapa.celdaEstaOcupada(posicionLlegada));
        assertTrue(mapa.celdaEstaOcupada(posicion));

    }

    @Test
    void crearArmaDeAsedioSeCreaCorrectamente() throws PosicionFueraDeRangoException, PosicionNoDisponibleException {
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion, faccion);
        assertTrue(mapa.celdaEstaOcupada(posicion));
        assertTrue(faccion.perteneceFaccion(armaDeAsedio));


    }
}
