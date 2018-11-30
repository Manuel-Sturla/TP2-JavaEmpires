package PruebasMapa;

import Exceptions.PosicionInvalidaException;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Ubicable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {

    Mapa mapa = new Mapa(10,10);
    Posicion posicion = new Posicion(mapa,0,0);
    Ubicable ubicable = new Aldeano(posicion, null);

    public MapaTest() throws PosicionInvalidaException {
    }

    @Test
    void elMapaRecienCreadoEstaVacio() throws PosicionInvalidaException {
        boolean check = true;
        Mapa mapa = new Mapa(10,10);
        Posicion posicion;
        for (int i = 0; i < 10; i++ ){
            for (int j = 0; j < 10; j++) {
                posicion = new Posicion(mapa,i,j);
                if(mapa.celdaEstaOcupada(posicion)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test<mapa,ubicable,posicion>
    void ocuparPosicionOcupaLaCelda() throws PosicionInvalidaException {

        assertTrue(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void desocuparPosicionDesocupaLaPosicion() throws PosicionInvalidaException {
        mapa.desocuparCelda(posicion);
        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaOcupaLaCeldaDeLlegada() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.moverElemento(posicion, posicionLlegada);

        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaDesocupaLaInicial() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.moverElemento(posicion, posicionLlegada);

        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoACeldaOcupadaLevantaExcepcion() throws PosicionInvalidaException {
        Posicion posicionLlegada = new Posicion(mapa, 1, 0);
        mapa.ocuparCelda(ubicable, posicionLlegada);

        assertThrows(PosicionInvalidaException.class, () -> {
            mapa.moverElemento(posicion, posicionLlegada);
        });
    }

    @Test<mapa,ubicable>
    void posicionarElementoEnPosicionNegativaLevantaException() {
        Posicion posicion = new Posicion(mapa, -1, 0);

        assertThrows(PosicionInvalidaException.class, () -> {
            mapa.ocuparCelda(ubicable, posicion);
        });
    }

    @Test<mapa,ubicable>
    void posicionarElementoEnPosicionFueraDeRangoLevantaExcepcion(){
        Posicion posicion = new Posicion(mapa, 15, 0);
        assertThrows(PosicionInvalidaException.class, () -> {
            mapa.ocuparCelda(ubicable, posicion);
        });
    }

    @Test <mapa,ubicable,posicion>
    void posicionValidaEstaEnMapaDevuelveVerdadero() throws PosicionInvalidaException {
        assertTrue(mapa.estaEnMapa(posicion));
    }

    @Test<mapa,ubicable>
    void posicionInvalidaEstaEnMapaDevuelveFalso() throws PosicionInvalidaException {
        Posicion posicion = new Posicion(mapa, 15, 0);
        assertFalse(mapa.estaEnMapa(posicion));
    }

    @Test<posicion>
    void enMapaDe1x2LaPrimeraCeldaEsAdyacenteALaSegunda() throws PosicionInvalidaException {
        Mapa mapa = new Mapa(2,1);
        Posicion posicion2 = new Posicion(mapa, 1,0);
        assertTrue(mapa.esAdyacente(posicion,posicion2));
    }
}
