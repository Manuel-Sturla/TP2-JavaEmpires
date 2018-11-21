import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Jugador.Jugador;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Ubicable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTests {

    Mapa mapa = new Mapa(10,10);
    Posicion posicion = new Posicion(mapa,0,0);
    Jugador jugador = new Jugador();
    Ubicable ubicable = new Aldeano(posicion, null);

    public MapaTests() throws PosicionFueraDeRangoException {
    }
    @Test
    void elMapaRecienCreadoEstaVacio() throws PosicionFueraDeRangoException {
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
    void ocuparPosicionOcupaLaCelda() throws PosicionFueraDeRangoException {
        mapa.ocuparCelda(ubicable,posicion);
        assertTrue(mapa.celdaEstaOcupada(posicion));
    }
    @Test<mapa,ubicable,posicion>
    void desocuparPosicionDesocupaLaPosicion() throws PosicionFueraDeRangoException {
        mapa.ocuparCelda(ubicable,posicion);
        mapa.desocuparCelda(posicion);
        assertFalse(mapa.celdaEstaOcupada(posicion));
    }
    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaOcupaLaCeldaDeLlegada() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.moverElemento(posicion, posicionLlegada);

        assertTrue(mapa.celdaEstaOcupada(posicionLlegada));
    }
    @Test<mapa,ubicable,posicion>
    void moverElementoDeCeldaDesocupaLaInicial() throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa,1,0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.moverElemento(posicion, posicionLlegada);

        assertFalse(mapa.celdaEstaOcupada(posicion));
    }
    @Test<mapa,ubicable,posicion>
    void moverElementoACeldaOcupadaLevantaExcepcion() throws PosicionFueraDeRangoException {
        Posicion posicionLlegada = new Posicion(mapa, 1, 0);
        mapa.ocuparCelda(ubicable, posicion);
        mapa.ocuparCelda(ubicable, posicionLlegada);

        assertThrows(PosicionNoDisponibleException.class, () -> {
            mapa.moverElemento(posicion, posicionLlegada);
        });
    }
    @Test<mapa,ubicable>
    void posicionarElementoEnPosicionNegativaLevantaException() {
        Posicion posicion = new Posicion(mapa, -1, 0);

        assertThrows(PosicionFueraDeRangoException.class, () -> {
            mapa.ocuparCelda(ubicable, posicion);
        });
    }
    @Test<mapa,ubicable>
    void posicionarElementoEnPosicionFueraDeRangoLevantaExcepcion(){
        Posicion posicion = new Posicion(mapa, 15, 0);
        assertThrows(PosicionFueraDeRangoException.class, () -> {
            mapa.ocuparCelda(ubicable, posicion);
        });
     }
    @Test <mapa,ubicable,posicion>
    void posicionValidaEstaEnMapaDevuelveVerdadero(){
        assertTrue(mapa.estaEnMapa(posicion));
    }
    @Test<mapa,ubicable>
    void posicionInvalidaEstaEnMapaDevuelveFalso(){
        Posicion posicion = new Posicion(mapa, 15, 0);
        assertFalse(mapa.estaEnMapa(posicion));
    }
/*
    //ESTA NO CORRE PORQUE HAY QUE DESCOMENTAR QUE LEVANTE ESA EXCEPCION Y ESO IMPLICA CAMBIAR
    //TODAS LAS DECLARACIONES DE MUCHOS METODOS, O VER QUE HACER CON ESAS EXCEPCIONES PARA EVITARLO
    @Test<mapa,ubicable,posicion>
    void ocuparUnaCeldaOcupadaLevantaExcepcion() throws PosicionFueraDeRangoException {
        mapa.ocuparCelda(ubicable,posicion);
        assertThrows(PosicionNoDisponibleException.class, ()-> {
            mapa.ocuparCelda(ubicable,posicion);
        });
    }
*/
    @Test<posicion>
    void enMapaDe1x2LaPrimeraCeldaEsAdyacenteALaSegunda() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(2,1);
        Posicion posicion2 = new Posicion(mapa, 1,0);
        assertTrue(mapa.esAdyacente(posicion,posicion2));
    }

    //FALTAN PRUEBAS DDE ADYACENCIA CON MAPAS MAS GRANDES (#PONELE)


}
