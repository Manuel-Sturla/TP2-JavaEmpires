package PruebasIntegracion;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Juego.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    void inicioJuegoOroOK() throws PosicionInvalidaException {
        Juego juego = new Juego();
        juego.inicializarJuego();

        Jugador jugador1 = juego.getJugador1();
        Jugador jugador2 = juego.getJugador2();
        assertEquals(40 , jugador1.getOro());
        assertEquals(40 , jugador2.getOro());
    }
    @Test
    void inicioJuegoPoblacionOK() throws PosicionInvalidaException {
        Juego juego = new Juego();
        juego.inicializarJuego();

        Jugador jugador1 = juego.getJugador1();
        Jugador jugador2 = juego.getJugador2();
        assertEquals(40 , jugador1.getOro());
        assertEquals(40 , jugador2.getOro());
    }

    @Test
    void inicioJuegoJugador2EstaOcupado() throws PosicionInvalidaException {
        Juego juego = new Juego();
        juego.inicializarJuego();

        Mapa mapa = juego.getMapa();
        Posicion posicion = new Posicion(mapa,29,25);
        Posicion posicionLlegada = new Posicion(mapa,24,29);



        assertTrue(mapa.celdaEstaOcupada(posicion));
        assertThrows(UbicableEstaOcupadoException.class , ()-> mapa.moverElemento(posicion,posicionLlegada));

    }

}
