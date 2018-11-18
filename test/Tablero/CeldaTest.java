package Tablero;

import Ubicables.Aldeano;
import Ubicables.Ubicable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CeldaTest {

    @Test
    void prueboCosntructorDeCelda(){
        Celda c = new Celda();
        assertTrue(c != null);
    }
    @Test
    void creoLaCeldaEstaDesocupada(){
        Celda c = new Celda();
        assertTrue(!c.estaOcupada());
    }
    @Test
    void ocupoUnaCelda() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,0,0);
        Ubicable elementoMapa = new Aldeano(posicion);
        Celda c = new Celda();
        c.ocuparCelda(elementoMapa);
        assertTrue(c.estaOcupada());
    }
    @Test
    void desocupoUnaCelda() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,0,0);
        Ubicable elementoMapa = new Aldeano(posicion);
        Celda celda = new Celda();
        celda.ocuparCelda(elementoMapa);
        celda.desocuparCelda();
        assertTrue(!celda.estaOcupada());
    }


}
