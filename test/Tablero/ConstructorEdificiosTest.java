package Tablero;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Jugador.Jugador;
import Ubicables.ConstructorEdificios;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorEdificiosTest {


    ArrayList aldeanos = new ArrayList();
    Jugador jugador1 = new Jugador(aldeanos);

    @Test
    public void CostructorEdificiosTest(){
        ConstructorEdificios constructorEdificios = new ConstructorEdificios(jugador1);
        assertTrue(constructorEdificios != null);
    }

    @Test
    public void TratoDeCrearUnEdificio() throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,5,5);
        Posicion posicionCostruccion = new Posicion(mapa,3,3);
        ConstructorEdificios constructorEdificios = new ConstructorEdificios(jugador1);
        constructorEdificios.consturirPlazaCentral(posicionAldeano,posicionCostruccion);
        boolean ok = true;
        for(int i = 3; i<4;i++){
            for (int j=3; j<4;j++){
                Posicion posicion = new Posicion(mapa,i,j);
                ok = mapa.celdaEstaOcupada(posicion);
            }
        }
        assertTrue(ok);
    }

    @Test
    public void TratoDeCrearEdificioFueraDeMapa(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,8,8);
        Posicion posicionConstruccion = new Posicion(mapa,9,8);
        ConstructorEdificios constructorEdificios = new ConstructorEdificios(jugador1);
        assertThrows(PosicionFueraDeRangoException.class , ()->{
            constructorEdificios.consturirPlazaCentral(posicionAldeano,posicionConstruccion);
        });
    }

    @Test
    public void TratoDeCrearEdificioFueraDeRangoDelAldeano(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,5,5);
        Posicion posicionConstruccion = new Posicion(mapa,2,2);
        ConstructorEdificios constructorEdificios = new ConstructorEdificios(jugador1);
        assertThrows(PosicionFueraDeRangoException.class , ()->{
            constructorEdificios.consturirPlazaCentral(posicionAldeano,posicionConstruccion);
        });
    }
}
