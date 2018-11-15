package Unidades;

import Tablero.Mapa;
import Tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnidadTest {

    @Test
    void moverUnidadUnaPosicionDerechaTest() {
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,0,0);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p, 0,0);
        unidad.moverHaciaDerecha(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(1,0));
    }
    @Test
    void moverUnidadPosicionIzqTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,1,0);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,1,0);
        unidad.moverHaciaIzquierda(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,0));
    }
    @Test
    void moverUnidadPosicionArribaTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,0,0);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,0,0);
        unidad.moverHaciaArriba(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,1));
    }
    @Test
    void moverUnidadPosicionAbajoTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,0,0);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,0,0);
        assertTrue(mapa.estaOcupadoElCasillero(0,0));
        assertFalse(mapa.estaOcupadoElCasillero(0,1));
    }
    @Test
    void moverUnidadPosicionArribaDerTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,0,0);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,0,0);
        assertTrue(mapa.estaOcupadoElCasillero(1,1));
        assertFalse(mapa.estaOcupadoElCasillero(0,0));
    }
    @Test
    void moverUnidadPosicionAbajoDerTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,1,1);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,1,1);
        unidad.moverHaciaAbajoDer(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(2,0));
        assertFalse(mapa.estaOcupadoElCasillero(1,1));
    }
    @Test
    void moverUnidadPosicionArribaIzqTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,1,1);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,1,1);
        unidad.moverHaciaArribaIzq(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,2));
        assertFalse(mapa.estaOcupadoElCasillero(1,1));
    }
    @Test
    void moverUnidadPosicionAbajoIzqTest(){
        Mapa mapa = new Mapa();
        Posicion p = new Posicion(mapa,1,1);
        Unidad unidad = new Aldeano(p);
        mapa.agregarElementoDeMapa(unidad,p,1,1);
        unidad.moverHaciaAbajoIzq(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,0  ));
        assertFalse(mapa.estaOcupadoElCasillero(1,1));
    }


}
