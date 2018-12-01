package PruebasIntegracion;

import Exceptions.OroInsuficienteException;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Banco;
import Jugador.ConstructorDeUbicables;
import Jugador.Faccion;
import Jugador.Poblacion;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Unidades.Aldeano;
import Ubicables.Edificios.PlazaCentral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebasCrearUbicables {

    Mapa mapa = new Mapa(10,10);
    Faccion faccion = new Faccion();
    Banco banco = new Banco(200);
    Poblacion poblacion = new Poblacion();
    ConstructorDeUbicables constructor = new ConstructorDeUbicables(banco, poblacion);
    Banco banco2 = new Banco(0);
    ConstructorDeUbicables constructor2 = new ConstructorDeUbicables(banco2,poblacion);
    //Pruebas crear aldeano:
    @Test
    void plazaCentralCreaUnAldeanoEsaPosicionEnElMapaSeOcupa() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posPlaza = new Posicion(mapa, 1,0);

        PlazaCentral plaza = new PlazaCentral(posPlaza, constructor);
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();

        plaza.crearAldeano();
        Posicion posAldeano = new Posicion(mapa, 0, 1);
        assertTrue(mapa.celdaEstaOcupada(posAldeano));
    }

    @Test
    void plazaCentralCreaUnAldeanoLaCantidadDeOroSeReduceEn25() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posPlaza = new Posicion(mapa, 1,0);

        PlazaCentral plaza = new PlazaCentral(posPlaza, constructor);
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();

        plaza.crearAldeano();
        assertTrue(banco.getCantidadDeOro() == 175);
    }

    @Test
    void plazaCentralIntentaCreaUnAldeanoSinOroTiraExcepcion() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posPlaza = new Posicion(mapa, 1,0);

        PlazaCentral plaza = new PlazaCentral(posPlaza, constructor2);
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();

        assertThrows(OroInsuficienteException.class , ()-> {
            plaza.crearAldeano();
        });
    }

    @Test
    void plazaCentralCreaUnAldeanoLaPoblacionAumentaEn1() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posPlaza = new Posicion(mapa, 1,0);

        PlazaCentral plaza = new PlazaCentral(posPlaza, constructor);
        plaza.asignarFaccion(faccion);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();

        plaza.crearAldeano();
        assertTrue(poblacion.getPoblacion() == 1);
    }

    //Pruebas crear plaza central:
    @Test
    void aldeanoCreaUnaPlazaCentralEsaPosicionEnElMapaSeOcupa() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posAldeano = new Posicion(mapa, 0, 0);
        Aldeano aldeano = new Aldeano(posAldeano, constructor);
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();

        boolean check = true;
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                Posicion posPlaza = new Posicion(mapa, i, j);
                if(!mapa.celdaEstaOcupada(posPlaza)){
                    check = false;
                }
            }
        }
        assertTrue(check);
    }

    @Test
    void aldeanoCreaUnaPlazaCentralLaCantidadDeOroSeReduceEn100() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posAldeano = new Posicion(mapa, 0, 0);
        Aldeano aldeano = new Aldeano(posAldeano, constructor);
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();
        assertTrue(banco.getCantidadDeOro() == 100);
    }

    @Test
    void aldeanoIntentaCreaUnaPlazaCentralSinOroTiraException() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posAldeano = new Posicion(mapa, 0, 0);
        Aldeano aldeano = new Aldeano(posAldeano, constructor2);
        aldeano.asignarFaccion(faccion);
        assertThrows(OroInsuficienteException.class , ()-> {
            aldeano.crearPlazaCentral();
        });

    }

    //Pruebas crear combinaciones
    @Test
    void unaPlazaCentralCreadaPorUnAldeanoPuedeCrearOtroAldeanoEseAldeanoOcupaUnaPosicionEnELMapa() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posAldeano = new Posicion(mapa, 0, 0);
        Aldeano aldeano = new Aldeano(posAldeano, constructor);
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();

        PlazaCentral plaza = (PlazaCentral)faccion.obtenerUbicable(1);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.crearAldeano();

        Posicion posAldeano2 = new Posicion(mapa, 0, 1);
        assertTrue(mapa.celdaEstaOcupada(posAldeano2));
    }

    @Test
    void unaPlazaCentralCreadaPorUnAldeanoCreaOtroAldeanoSeConsumeElOroCorrecto() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posAldeano = new Posicion(mapa, 0, 0);
        Aldeano aldeano = new Aldeano(posAldeano, constructor);
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();

        PlazaCentral plaza = (PlazaCentral)faccion.obtenerUbicable(1);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.crearAldeano();

        assertTrue(banco.getCantidadDeOro() == 75);
    }

    @Test
    void unaPlazaCentralCreadaPorUnAldeanoCreaOtroAldeanoEseAldeanoAumentaLaCantidadDeHabitantes() throws PosicionInvalidaException, UbicableEstaOcupadoException, OroInsuficienteException {
        Posicion posAldeano = new Posicion(mapa, 0, 0);
        Aldeano aldeano = new Aldeano(posAldeano, constructor);
        poblacion.agregarHabitante();
        aldeano.asignarFaccion(faccion);
        aldeano.crearPlazaCentral();

        PlazaCentral plaza = (PlazaCentral)faccion.obtenerUbicable(1);
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.desocuparUnTurno();
        plaza.crearAldeano();

        assertTrue(poblacion.getPoblacion() == 2);
    }


}
