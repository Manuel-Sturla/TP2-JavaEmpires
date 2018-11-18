import Exceptions.PosicionNoDisponibleException;
import Tablero.Mapa;
import Tablero.Posicion;
import Unidades.Aldeano;
import Unidades.Ubicable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTests {

    Mapa mapa = new Mapa(10,10);
    Ubicable ubicable = new Aldeano();
    Posicion posicion = new Posicion(mapa,0,0);

    @Test
    void elMapaRecienCreadoEstaVacio(){
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
    void ocuparPosicionOcupaLaCelda(){
        mapa.ocuparCelda(ubicable,posicion);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void desocuparPosicionDesocupaLaPosicion(){
        mapa.ocuparCelda(ubicable,posicion);
        mapa.desocuparCelda(posicion);
        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaOcupaLaCeldaDeLlegada() throws PosicionNoDisponibleException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.moverElemento(posicion, posicionLlegada);

        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaDesocupaLaInicial() throws PosicionNoDisponibleException{
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.moverElemento(posicion, posicionLlegada);

        assertFalse(mapa.celdaEstaOcupada(posicion));
    }

    @Test<mapa,ubicable,posicion>
    void moverElementoACeldaOcupadaLevantaExcepcion(){
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.ocuparCelda(ubicable, posicionLlegada);

        assertThrows(PosicionNoDisponibleException.class, ()-> {
            mapa.moverElemento(posicion, posicionLlegada);
        });
    }

/*
    @Test
    void ocuparUnaCeldaOcupadaLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        mapa.ocuparCelda(0,0);
        assertThrows(PosicionYaOcupadaException.class, ()-> {
            mapa.ocuparCelda(0,0);
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
