package EdificioTests;

import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Aldeano;
import Ubicables.PlazaCentral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlazaCentralTests {

    @Test
    void laPlazaCentralOcupa4PosicionesEnElMapa() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        aldeano.crearPlazaCentral();
        boolean check = true;
        for (int i = 11; i <= 12; i++) {
            for (int j = 10; j <= 11; j++) {
                Posicion posEdificio = new Posicion(mapa, i, j);
                if(!mapa.celdaEstaOcupada(posEdificio)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void laPlazaCentralEstaOcupadaEnElTurnoQueFueConstruida() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral();
        assertTrue(plaza.estaOcupada());
    }

    @Test
    void laPlazaCentralSeDesocupaLuegoDe3Turnos() throws UbicableEstaOcupadoException{
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        assertFalse(plaza.estaOcupada());
    }
}
