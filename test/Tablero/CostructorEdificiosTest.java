package Tablero;

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
/*
    @Test
    public void TratoDeCrearUnEdificio() throws PosicionFueraDeRangoException {
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,1,1);
        Posicion posicionCostruccion = new Posicion(mapa,2,2);
        PosicionEdificio posicionEdificio = new PosicionEdificio(posicionCostruccion,2);
        CostructorEdificios costructorEdificios = new CostructorEdificios(jugador1);
        costructorEdificios.consturirPlazaCentral(posicionAldeano,posicionCostruccion);
        boolean ok = true;
        for(int i = 2; i<4;i++){
            for (int j=2; j<4;j++){
                Posicion posicion = new Posicion(mapa,i,j);
                ok = mapa.celdaEstaOcupada(posicion);
            }
        }
        assertTrue(ok);
    }

    @Test
    public void TratoDecrearEdificioFueraDeMapa(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicionAldeano = new Posicion(mapa,8,8);
        Posicion posicionCostruccion = new Posicion()
    }
*/
}
