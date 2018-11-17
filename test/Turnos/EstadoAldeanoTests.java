package Turnos;

import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoAldeanoTests {

    @Test
    void estadoInicialEsDesocupado(){
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        assertFalse(aldeano.estaOcupado());
    }

    @Test
    void estadoLuegoDeRealizarAccionEsOcupado() throws UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        assertTrue(aldeano.estaOcupado());
    }

    @Test
    void realizarDosAccionesEnElMismoTurnoLevantaExcepcion() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(5, 5);
        Posicion posicion = new Posicion(mapa, 3, 3);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.moverDerecha();
        assertThrows(UbicableEstaOcupadoException.class, aldeano::moverDerecha);
    }
    
}
