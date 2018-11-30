package PruebasUbicables;

import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Banco;
import Jugador.Faccion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Unidades.Arquero;
import Ubicables.Unidades.Espadachin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorDeUbicablesTest {
/* Todas las pruebas de crear hay que hacerlas aca y no es los edificios o en el aldeano.
    @Test
    void creoUnEspadachin() throws PosicionInvalidaException, UbicableEstaOcupadoException {
        Mapa mapa = new Mapa(10,10);
        Faccion faccion = new Faccion();
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        Cuartel cuartel = new Cuartel(posicionCostruccion);
        cuartel.asignarFaccion(faccion);
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        cuartel.desocuparUnTurno();
        Espadachin espadachin = cuartel.crearEspadachin();
        assertTrue(espadachin != null);
    }


    @Test
    void creoUnArquero() throws PosicionInvalidaException, UbicableEstaOcupadoException {
        Arquero arquero = cuartel.crearArquero();
        assertTrue(arquero != null);
    }*/
}
