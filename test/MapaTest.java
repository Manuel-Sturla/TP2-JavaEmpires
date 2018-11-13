import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {


    @Test
    void agregarElementoDeMapaEnCasilleroVacio() {
        Mapa mapaAOE = new Mapa();
        Unidad elemento = new Unidad();
        assertTrue(mapaAOE.agregarElementoDeMapa(elemento, 0, 0));
    }
    @Test
    void agregarElementoDeMapaEnCasilleroOcupado() {
        Mapa mapaAOE = new Mapa();
        Unidad elemento1 = new Unidad();
        Unidad elemento2 = new Unidad();
        mapaAOE.agregarElementoDeMapa(elemento1, 0, 0);
        assertFalse(mapaAOE.agregarElementoDeMapa(elemento2, 0, 0));
    }
    @Test
    void agregarElementoDeMapaAfueraDelMapa() {
        Mapa mapaAOE = new Mapa();
        Unidad elemento = new Unidad();
        assertFalse(mapaAOE.agregarElementoDeMapa(elemento, -1, 0));
    }
    @Test
    void agregarElementoDeMapaOcupaElCasillero(){
        Mapa mapaAOE = new Mapa();
        Unidad elemento = new Unidad();
        mapaAOE.agregarElementoDeMapa(elemento,0,0);
        assertTrue(mapaAOE.estaOcupadoElCasillero(0, 0));
    }

}