package Tablero;

import Unidades.Aldeano;
import Unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {


    @Test
    void agregarElementoDeMapaEnCasilleroVacio() {
        Mapa mapaAOE = new Mapa();
        Aldeano elemento = new Aldeano(mapaAOE, 0, 0);
        assertTrue(mapaAOE.agregarElementoDeMapa(elemento,0, 0));
    }

    @Test
    void agregarElementoDeMapaEnCasilleroOcupado() {
        Mapa mapaAOE = new Mapa();
        Unidad elemento1 = new Aldeano(mapaAOE,0,0);
        Unidad elemento2 = new Aldeano(mapaAOE);
        mapaAOE.agregarElementoDeMapa(elemento1,p,0, 0);
        assertFalse(mapaAOE.agregarElementoDeMapa(elemento2,p,0, 0));
    }
    @Test
    void agregarElementoDeMapaAfueraDelMapa() {
        Mapa mapaAOE = new Mapa();
        Posicion p = new Posicion(mapaAOE,0,0);
        Unidad elemento = new Aldeano(p);
        assertFalse(mapaAOE.agregarElementoDeMapa(elemento,p, -1, 0));
    }

    @Test
    void agregarElementoDeMapaOcupaElCasillero(){
        Mapa mapaAOE = new Mapa();
        Posicion p = new Posicion(mapaAOE,0,0);
        Unidad elemento = new Aldeano(p);
        mapaAOE.agregarElementoDeMapa(elemento,p,0,0);
        assertTrue(mapaAOE.estaOcupadoElCasillero(0, 0));
    }

}