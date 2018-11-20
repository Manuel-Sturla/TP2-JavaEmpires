package Tablero;

import Exceptions.NoSePudoConstruirException;
import Exceptions.PosicionFueraDeRangoException;
import Jugador.Jugador;
import Ubicables.CostructorEdificios;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CostructorEdificiosTest {

    /*
    public void crearPlazaCentral(Posicion posicionInicial){
        PosicionEdificio zonaCostruccion = new PosicionEdificio()
    }
    */

    ArrayList aldeanos = new ArrayList();
    Jugador jugador1 = new Jugador(aldeanos);

    @Test
    public void CostructorEdificiosTest(){
        CostructorEdificios costructorEdificios = new CostructorEdificios(jugador1);
        assertTrue(costructorEdificios != null);
    }

    @Test
    public void TratoDeCrearUnEdificio() throws PosicionFueraDeRangoException, NoSePudoConstruirException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,5,5);
        Posicion posicionCostruccion = new Posicion(mapa,3,3);
        CostructorEdificios costructorEdificios = new CostructorEdificios(jugador1);
        costructorEdificios.consturirPlazaCentral(posicionAldeano,posicionCostruccion);
        boolean ok = true;
        for(int i = 3; i<4;i++){
            for (int j=3; j<4;j++){
                Posicion posicion = new Posicion(mapa,i,j);
                ok = mapa.celdaEstaOcupada(posicion);
            }
        }
        assertTrue(ok);
    }
/*
    @Test
    public void TratoDecrearEdificioFueraDeMapa(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,8,8);
        Posicion posicionCostruccion = new Posicion()
    }
*/
}
