import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Aldeano;
import Ubicables.Ubicable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTests {

    Mapa mapa = new Mapa(10,10);
    Posicion posicion = new Posicion(mapa,0,0);
    Ubicable ubicable = new Aldeano(posicion);

    public MapaTests() throws PosicionFueraDeRangoException {
    }

    @Test
    void elMapaRecienCreadoEstaVacio() throws PosicionFueraDeRangoException {
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
    void ocuparPosicionOcupaLaCelda() throws PosicionFueraDeRangoException {
        mapa.ocuparCelda(ubicable,posicion);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void desocuparPosicionDesocupaLaPosicion() throws PosicionFueraDeRangoException {
        mapa.ocuparCelda(ubicable,posicion);
        mapa.desocuparCelda(posicion);
        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaOcupaLaCeldaDeLlegada() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.moverElemento(posicion, posicionLlegada);

        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaDesocupaLaInicial() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.moverElemento(posicion, posicionLlegada);

        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoACeldaOcupadaLevantaExcepcion() throws PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa, 1, 0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.ocuparCelda(ubicable, posicionLlegada);

        assertThrows(PosicionNoDisponibleException.class, () -> {
            mapa.moverElemento(posicion, posicionLlegada);
        });
    }
//AGREGAR PRUEBA: ACCEDER A POSICION LIMITE DADO QUE LAS POSICIONES VAN DE 0 A N-1
    @Test<mapa,ubicable>
    void posicionarElementoEnPosicionNegativaLevantaException(){
        Posicion posicion = new Posicion(mapa,-1,0);

        assertThrows(PosicionFueraDeRangoException.class, () -> {
            mapa.ocuparCelda(ubicable, posicion);
        });


    }
/*
    @Test<mapa,ubicable,posicion>
    void ocuparUnaCeldaOcupadaLevantaExcepcion(){
        mapa.ocuparCelda(ubicable,posicion);
        assertThrows(PosicionNoDisponibleException.class, ()-> {
            mapa.ocuparCelda(ubicable,posicion);
        });
    }

    @Test
    void ocuparUnaPosicionEnPosicionNegativaLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        assertThrows(PosicionFueraDeRangoException.class, ()-> {
            mapa.ocuparCelda(-1,0);
        });
    }

    @Test
    void ocuparUnaPosicionFueraDeRangoLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        assertThrows(PosicionFueraDeRangoException.class, ()-> {
            mapa.ocuparPosicion(11,11);
        });
    }
*/

}
