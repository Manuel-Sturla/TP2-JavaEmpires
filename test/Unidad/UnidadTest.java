package Unidad;

import Mapa.Mapa;
import Unidad.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnidadTest {

    @Test
    void moverUnidadUnaPosicionDerechaTest() {
        Unidad unidad = new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad, 0,0);
        unidad.moverHaciaDerecha(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(1,0));
    }
    @Test
    void moverUnidadPosicionIzqTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,1,0);
        unidad.moverHaciaIzquierda(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,0));
    }
    @Test
    void moverUnidadPosicionArribaTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,0,0);
        unidad.moverHaciaArriba(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,1));
    }
    @Test
    void moverUnidadPosicionAbajoTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,0,1);
        unidad.moverHaciaAbajo(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,0));
        assertFalse(mapa.estaOcupadoElCasillero(0,1));
    }
    @Test
    void moverUnidadPosicionArribaDerTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,0,0);
        unidad.moverHaciaArribaDer(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(1,1));
        assertFalse(mapa.estaOcupadoElCasillero(0,0));
    }
    @Test
    void moverUnidadPosicionAbajoDerTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,1,1);
        unidad.moverHaciaAbajoDer(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(2,0));
        assertFalse(mapa.estaOcupadoElCasillero(1,1));
    }
    @Test
    void moverUnidadPosicionArribaIzqTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,1,1);
        unidad.moverHaciaArribaIzq(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,2));
        assertFalse(mapa.estaOcupadoElCasillero(1,1));
    }
    @Test
    void moverUnidadPosicionAbajoIzqTest(){
        Unidad unidad =new Unidad();
        Mapa mapa = new Mapa();
        mapa.agregarElementoDeMapa(unidad,1,1);
        unidad.moverHaciaAbajoIzq(mapa);
        assertTrue(mapa.estaOcupadoElCasillero(0,0  ));
        assertFalse(mapa.estaOcupadoElCasillero(1,1));
    }


}
