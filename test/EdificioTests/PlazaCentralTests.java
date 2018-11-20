package EdificioTests;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Aldeano;
import Ubicables.PlazaCentral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlazaCentralTests {

    @Test
    void laPlazaCentralOcupa4PosicionesEnElMapa() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Posicion posicionCostruccion = new Posicion(mapa,11,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        aldeano.crearPlazaCentral(posicionCostruccion);
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
    void laPlazaCentralEstaOcupadaEnElTurnoQueFueConstruida() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Posicion posicionCostruccion = new Posicion(mapa,11,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral(posicionCostruccion);
        assertTrue(plaza.estaOcupada());
    }

    @Test
    void laPlazaCentralSeDesocupaLuegoDe3Turnos() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Posicion posicionCostruccion = new Posicion(mapa,11,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral(posicionCostruccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        assertFalse(plaza.estaOcupada());
    }

    @Test
    void laPlazaCentralNoPuedeCrearUnAldeanoUnTurnoDespuesDeSerConstruida() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Posicion posicionCostruccion = new Posicion(mapa,11,11);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral(posicionCostruccion);
        plaza.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, plaza::crearAldeano);
    }

    @Test
    void laPlazaCentralPuedeCrearUnAldeano3TurnosDespuesDeSerConstruida() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Posicion posicionCostruccion = new Posicion(mapa,11,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral(posicionCostruccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        assertTrue(plaza.crearAldeano() != null);
    }

    @Test
    void elAldeanoCreadoPorLaPlazaOcupaUnaPosicionEnElMapa() throws UbicableEstaOcupadoException, PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 10,10);
        Posicion posicionCostruccion = new Posicion(mapa,11,10);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral(posicionCostruccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        Aldeano aldeanoCreado = plaza.crearAldeano();
        Posicion posDeploy = new Posicion(mapa, 10, 11);
        assertTrue(mapa.celdaEstaOcupada(posDeploy));
    }
    //ESTO LE TOCA A DIEGUIN!!!!
    @Test
    void siElAldeanoNoTieneEspacioParaConstruirElEdificioLoContruyeEnElSentidoOpuesto() throws PosicionFueraDeRangoException, UbicableEstaOcupadoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(20,20);
        Posicion posicionAldeano = new Posicion(mapa, 19,0);
        Posicion posicionCostruccion = new Posicion(mapa,20,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        PlazaCentral plaza = aldeano.crearPlazaCentral(posicionCostruccion);
        boolean check = true;
        for (int i = 17; i < 19; i++) {
            for (int j = 0; j < 2; j++) {
                Posicion posMapa = new Posicion(mapa, i, j);
                if(mapa.celdaEstaOcupada(posMapa)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }
}
