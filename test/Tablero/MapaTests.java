import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTests {
/*
    @Test
    void elMapaRecienCreadoEstaVacio(){
        boolean check = true;
        Mapa mapa = new Mapa(10,10);
        for (int i = 0; i < 10; i++ ){
            for (int j = 0; j < 10; j++) {
                if(mapa.estaOcupadoEn(i, j)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void ocuparPosicionOcupaLaPosicion(){
        Mapa mapa = new Mapa(10,10);
        mapa.ocuparPosicion(0,0);
        assertTrue(mapa.estaOcupado(0,0));
    }

    @Test
    void desocuparPosicionDesocupaLaPosicion(){
        Mapa mapa = new Mapa(10,10);
        mapa.ocuparPosicion(0,0);
        mapa.desocuparPosicion(0,0);
        assertFalse(mapa.estaOcupado(0,0));
    }

    @Test
    void ocuparUnaPosicionOcupadaLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        mapa.ocuparPosicion(0,0);
        assertThrows(PosicionYaOcupadaException.class, ()-> {
            mapa.ocuparPosicion(0,0);
        });
    }

    @Test
    void ocuparUnaPosicionEnPosicionNegativaLevantaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        assertThrows(PosicionFueraDeRangoException.class, ()-> {
            mapa.ocuparPosicion(-1,0);
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
