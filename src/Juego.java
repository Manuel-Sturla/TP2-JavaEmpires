import Exceptions.PosicionInvalidaException;
import Jugador.Jugador;
import Mapa.Mapa;

public class Juego {
    Jugador jugador1;
    Jugador jugador2;
    Mapa mapa;


    public void inicializarJuego() throws PosicionInvalidaException {
        mapa = new Mapa(50,50);
        jugador1.inicializarJugador(1);
        jugador2.inicializarJugador(1);
    }

    public void iniciarPrimerTurno() throws PosicionInvalidaException {
        jugador1.iniciarTurno();
    }
}
