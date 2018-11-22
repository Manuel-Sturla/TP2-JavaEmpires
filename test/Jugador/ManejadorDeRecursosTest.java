/*package Jugador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManejadorDeRecursosTest {

        @Test
        public void testCrearElControladorDeRecursosTiene3UnidadesY100DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,100);
            assertTrue(manejador.NumeroDeUnidades() == 3 && manejador.CantidadDeOro() == 100);

        }

        @Test
        public void testElControladorDeRecursosNoDejaTenerMasDe50Unidades(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(50,100);
            assertFalse(manejador.CrearAldeano() && manejador.CrearEspadachin() && manejador.CrearArquero() && manejador.CrearArmaDeAsedio());
        }

        @Test
        public void testElControladorDeRecursosNoDejaCrearAldeanoConMenosDe25DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,24);
            assertFalse(manejador.CrearAldeano());
        }

        @Test
        public void testElControladorDeRecursosNoDejaCrearArqueroConMenosDe75DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,74);
            assertFalse(manejador.CrearArquero());

        }

        @Test
        public void testElControladorDeRecursosNoDejaCrearEspadachinConMenosDe50DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,49);
            assertFalse(manejador.CrearArquero());
        }

        @Test
        public void testElControladorDeRecursosNoDejaCrearArmaDeAsedioConMenosDe150DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,149);
            assertFalse(manejador.CrearArmaDeAsedio());
        }

        @Test
        public void testElControladorDeRecursosNoDejaCrearCuartelConMenosDe50DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,49);
            assertFalse(manejador.CrearCuartel());

        }

        @Test
        public void testElControladorDeRecursosNoDejaPlazaCentralConMenosDe100DeOro(){
            ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,99);
            assertFalse(manejador.CrearPlazaCentral());

        }



}*/
package Jugador;

import Exceptions.NoSePudoConstruirException;
import Exceptions.OroInsuficienteException;
import Exceptions.PosicionFueraDeRangoException;
import Exceptions.UbicableEstaOcupadoException;
import Tablero.Mapa;
import Tablero.Posicion;
import Ubicables.Edificios.Cuartel;
import Ubicables.Edificios.PlazaCentral;
import Ubicables.Unidades.Aldeano;
import Ubicables.Unidades.Espadachin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManejadorDeRecursosTest {
/*
    @Test
    public void testCrearElControladorDeRecursosTiene3Aldeanos3Trabajando3libresY100DeOro(){
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        assertTrue(manejador.NumeroDeUnidades() == 3 && manejador.CantidadDeOro() == 100);

    }

    @Test
    public void testVeoQueCobrarCon2AldeanosLibresY1TrabajandoSuma40DeOro() {
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        manejador.AgregarAldeanosTrabajando(1);
        manejador.Cobrar();
        assertTrue(manejador.CantidadDeOro() == 140);
    }

    @Test
    public void testElControladorDeRecursosDejaCrearPlazaCentralConDe100DeOro() throws PosicionFueraDeRangoException, OroInsuficienteException {
        Mapa mapa  = new Mapa(8,8);
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        Jugador jugador = new Jugador(manejador);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion,jugador);
        assertTrue(manejador.CrearPlazaCentral());
        assertTrue(manejador.CantidadDeOro() == 0);
        assertTrue(manejador.NumeroDeAldeanosNoTrabajando() == 2);
        assertTrue(manejador.NumeroDeAldeanosTrabajando() == 1);

    }
    @Test
    public void testElControladorDeRecursosDejaCrearCuartelConDe100DeOro() throws PosicionFueraDeRangoException, OroInsuficienteException {
        Mapa mapa  = new Mapa(8,8);
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        Jugador jugador = new Jugador(manejador);
        Posicion posicion = new Posicion(mapa, 1,1);
        Aldeano aldeano = new Aldeano(posicion,jugador);
        assertTrue(manejador.CrearCuartel());
        assertTrue(manejador.CantidadDeOro() == 50);
        assertTrue(manejador.NumeroDeAldeanosNoTrabajando() == 2);
        assertTrue(manejador.NumeroDeAldeanosTrabajando() == 1);

    }
    @Test
    public void testElControladorDeRecursosDejaCrearAldeanoConDe100DeOro() throws PosicionFueraDeRangoException, OroInsuficienteException, NoSePudoConstruirException, UbicableEstaOcupadoException {
        Mapa mapa  = new Mapa(8,8);
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        Jugador jugador = new Jugador(manejador);
        Posicion posicion = new Posicion(mapa, 1,1);
        PlazaCentral plaza = new PlazaCentral(posicion,jugador);
        plaza.desocupado();
        Aldeano aldeano = plaza.crearAldeano();
        assertTrue(manejador.CantidadDeOro() == 75);
        assertTrue(manejador.NumeroDeAldeanosNoTrabajando() == 4);
        assertTrue(manejador.NumeroDeAldeanosTrabajando() == 0);

    }
    @Test
    public void testElControladorDeRecursosDejaCrearEspadachinConDe100DeOro() throws PosicionFueraDeRangoException, OroInsuficienteException, NoSePudoConstruirException, UbicableEstaOcupadoException {
        Mapa mapa  = new Mapa(8,8);
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        Jugador jugador = new Jugador(manejador);
        Posicion posicion = new Posicion(mapa, 1,1);
        Cuartel cuartel = new Cuartel(posicion,jugador);
        cuartel.desocupado();
        Espadachin espadachin = cuartel.crearEspadachin();
        assertTrue(manejador.CantidadDeOro() == 50);
        assertTrue(manejador.NumeroDeUnidades() == 4);

    }
    @Test
    public void testElControladorDeRecursosNoDejaTenerMasDe50Unidades(){
       // Mapa mapa  = new Mapa(8,8);
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        Jugador jugador = new Jugador(manejador);
        manejador.AgregarUnidades(47);
        assertThrows(UnidadesMaximasException.class , ()-> {
            manejador.CrearAldeano();
        });

    }

    @Test
    public void testElControladorDeRecursosNoDejaCrearAldeanoConMenosDe25DeOro(){
        //Mapa mapa  = new Mapa(8,8);
        ManejadorDeRecursos manejador = new ManejadorDeRecursos();
        Jugador jugador = new Jugador(manejador);
        manejador.AsignarOro(24);
        assertThrows(OroInsuficienteException.class , ()-> {
            manejador.CrearAldeano();
        });

    }

    @Test
    public void testElControladorDeRecursosNoDejaCrearArqueroConMenosDe75DeOro(){
        ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,74);
        assertFalse(manejador.CrearArquero());

    }

    @Test
    public void testElControladorDeRecursosNoDejaCrearEspadachinConMenosDe50DeOro(){
        ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,49);
        assertFalse(manejador.CrearArquero());

    }

    @Test
    public void testElControladorDeRecursosNoDejaCrearArmaDeAsedioConMenosDe200DeOro(){
        ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,199);
        assertFalse(manejador.CrearArmaDeAsedio());

    }

    @Test
    public void testElControladorDeRecursosNoDejaCrearCuartelConMenosDe50DeOro(){
        ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,49);
        assertFalse(manejador.CrearCuartel());

    }

    @Test
    public void testElControladorDeRecursosNoDejaPlazaCentralConMenosDe100DeOro(){
        ManejadorDeRecursos manejador = new ManejadorDeRecursos(3,99);
        assertFalse(manejador.CrearPlazaCentral());

    }*/

}

