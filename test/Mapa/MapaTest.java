package Mapa;

import ElementosDeMapa.ElementoDeMapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {

    @Test
    void agregarElementoDeMapaEnCasilleroVacio() {
        Mapa mapaAOE = new Mapa();
        ElementoDeMapa elemento = new ElementoDeMapa();
        assertTrue(mapaAOE.agregarElementoDeMapa(elemento, 0, 0));
    }

    @Test
    void agregarElementoDeMapaEnCasilleroOcupado() {
        Mapa mapaAOE = new Mapa();
        ElementoDeMapa elemento1 = new ElementoDeMapa();
        ElementoDeMapa elemento2 = new ElementoDeMapa();
        mapaAOE.agregarElementoDeMapa(elemento1, 0, 0);
        assertFalse(mapaAOE.agregarElementoDeMapa(elemento2, 0, 0));
    }

    @Test
    void agregarElementoDeMapaAfueraDelMapa() {
        Mapa mapaAOE = new Mapa();
        ElementoDeMapa elemento = new ElementoDeMapa();
        assertFalse(mapaAOE.agregarElementoDeMapa(elemento, -1, 0));
    }
}