package PruebasIntegracion;

import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Juego.Juego;
import Modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
