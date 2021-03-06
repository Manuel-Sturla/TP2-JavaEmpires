package PruebasUbicables.PruebasEdificios;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Exceptions.UnidadesMaximasException;
import Modelo.Jugador.Banco;
import Modelo.Jugador.ConstructorDeUbicables;
import Modelo.Jugador.Faccion;
import Modelo.Jugador.Poblacion;
import Modelo.Mapa.Mapa;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.PlazaCentral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlazaCentralTest {
    Banco banco = new Banco(300);
    Poblacion poblacion = new Poblacion();
    ConstructorDeUbicables constructor = new ConstructorDeUbicables(banco, poblacion);
    Mapa mapa = new Mapa(20,20);
    Posicion posicionPlaza = new Posicion(mapa, 10,10);

    @Test
    void laPlazaCentralOcupa4PosicionesEnElMapa() throws PosicionInvalidaException, OroInsuficienteException {
        constructor.crearPlazaCentral(posicionPlaza);
        boolean check = true;
        for (int i = 10; i < 12; i++) {
            for (int j = 10; j < 12; j++) {
                Posicion posEdificio = new Posicion(mapa, i, j);
                if(!mapa.celdaEstaOcupada(posEdificio)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void laPlazaCentralEstaOcupadaEnElTurnoQueFueConstruida() throws PosicionInvalidaException, OroInsuficienteException {
        PlazaCentral plaza = constructor.crearPlazaCentral(posicionPlaza);
        assertTrue(plaza.estaOcupado());
    }

    @Test
    void laPlazaCentralSeDesocupaLuegoDe3Turnos() throws PosicionInvalidaException, OroInsuficienteException {
        PlazaCentral plaza = constructor.crearPlazaCentral(posicionPlaza);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        assertFalse(plaza.estaOcupado());
    }

    @Test
    void laPlazaCentralNoPuedeCrearUnAldeanoUnTurnoDespuesDeSerConstruida() throws PosicionInvalidaException, OroInsuficienteException {
        PlazaCentral plaza = constructor.crearPlazaCentral(posicionPlaza);
        Faccion faccion = new Faccion();
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        assertThrows(UbicableEstaOcupadoException.class, plaza::crearAldeano);
    }

    @Test
    void elAldeanoCreadoPorLaPlazaOcupaUnaPosicionEnElMapa() throws UbicableEstaOcupadoException, PosicionInvalidaException, OroInsuficienteException, UnidadesMaximasException {
        PlazaCentral plaza = constructor.crearPlazaCentral(posicionPlaza);
        Faccion faccion = new Faccion();
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.crearAldeano();
        Posicion posDeploy = new Posicion(mapa, 10, 11);
        assertTrue(mapa.celdaEstaOcupada(posDeploy));
    }
}
