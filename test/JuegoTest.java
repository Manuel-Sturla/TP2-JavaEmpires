import Exceptions.MapaMuyPequeñoException;
import Jugador.Jugador;
import Ubicables.Edificios.Castillo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JuegoTest {

    @Test
    void iniciarJuegoIniciaALosJugadoresCon5Elementos() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        assertTrue(jugador1.getElementos().size()==5);

    }
/*
    @Test
    void iniciarJuegoIniciaALosJugadoresCon3Aldeanos() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        assertTrue(jugador1.obtenerAldeanos().size()==3);
    }

    @Test
    void iniciarJuegoIniciaALosJugadoresCon2Edificios() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        assertTrue(jugador1.obtenerEdificios().size()==2);
    }

    @Test
    void iniciarJuegoIniciaAlJugador1Con100DeOro() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        assertTrue(jugador1.obtenerOro()==100);
    }

    @Test
    void iniciarJuegoIniciaAlJugador2Con100DeOro() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        jugador1.finalizarTurno();
        Jugador jugador2 = juego.obtenerJugadorActual();
        assertTrue(jugador2.obtenerOro()==100);
    }

    @Test
    void iniciarJuegoIniciaLosCastillosEnemigosAlejadosEnElMapa() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Castillo castilloJugador1 = (Castillo) jugador1.getElementos().get(0);
        castilloJugador1.obtenerPosicion(); // NO SE COMO PROBARLO
    }

    @Test
    void iniciarJuegoConTamañoDeMapaPequeñoLevantaError(){
        Juego juego = new Juego();

        assertThrows(MapaMuyPequeñoException.class, ()->{
            juego.iniciar(1,1);
        });
    }

    @Test
    void iniciarJuegoCrea2JugadoresDistintos() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        jugador1.finalizarTurno();
        assertTrue(juego.obtenerJugadorActual()!= jugador1);
    }

    @Test
    void iniciarJuegoCreaSolamente2Jugadores() throws MapaMuyPequeñoException {
        Juego juego = new Juego();

        juego.iniciar(10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        jugador1.finalizarTurno();
        Jugador jugador2 = juego.obtenerJugadorActual();
        jugador2.finalizarTurno();
        assertTrue(juego.obtenerJugadorActual() == jugador1);



    }*/
}
