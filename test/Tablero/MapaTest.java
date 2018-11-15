package Tablero;

import Unidades.Aldeano;
import Unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {


    @Test
    void agregarElementoDeMapaEnCasilleroVacio() {
        Mapa mapaAOE = new Mapa();
        Posicion p = new Posicion(mapaAOE,1,1);
        System.out.print("jajja");
        ElementoDeMapa elemento = new Aldeano(p);
        System.out.print("jajja");
        assertTrue(mapaAOE.agregarElementoDeMapa(elemento,p,0, 0));
    }
    @Test
    void agregarElementoDeMapaEnCasilleroOcupado() {
        Mapa mapaAOE = new Mapa();
        Posicion p = new Posicion(mapaAOE,0,0);
        Unidad elemento1 = new Aldeano(p);
        Unidad elemento2 = new Aldeano(p);
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