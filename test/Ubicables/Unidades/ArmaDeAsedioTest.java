package Ubicables.Unidades;

import Exceptions.MovimientoNoPermitidoException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Mapa;
import Tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmaDeAsedioTest {

    @Test
    public void creoUnArmaDeAsedio() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,2,2);
        Faccion faccion = new Faccion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion,faccion);
        assertTrue(armaDeAsedio != null);
    }

    @Test
    public void creoUnArmaDeAsedioIniciaDesmontada() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException, PosicionFueraDeRangoException, PosicionNoDisponibleException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,2,2);
        Posicion posicion1 = new Posicion(mapa, 3,2);
        Faccion faccion = new Faccion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion,faccion);
        armaDeAsedio.moverDerecha();
        assertTrue(mapa.celdaEstaOcupada(posicion1));
    }

    @Test
    public void creoUnArmaDeAsedioSeMonta() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,2,2);
        Faccion faccion = new Faccion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion,faccion);
        armaDeAsedio.montarArma();
        assertThrows(MovimientoNoPermitidoException.class ,()-> armaDeAsedio.moverDerecha());
    }

}
