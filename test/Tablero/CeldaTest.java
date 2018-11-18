package Tablero;

import Unidades.Aldeano;
import Unidades.Ubicable;
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
    void ocupoUnaCelda(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,0,0);
        Ubicable elementoMapa = new Aldeano(posicion);
        Celda c = new Celda();
        c.ocuparCelda(elementoMapa);
        assertTrue(c.estaOcupada());
    }
    @Test
    void desocupoUnaCelda(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicion = new Posicion(mapa,0,0);
        Ubicable elementoMapa = new Aldeano(posicion);
        Celda celda = new Celda();
        celda.ocuparCelda(elementoMapa);
        celda.desocuparCelda();
        assertTrue(!celda.estaOcupada());
    }


}
