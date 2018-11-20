package Jugador;

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



}
