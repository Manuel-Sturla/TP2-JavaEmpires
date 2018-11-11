import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class aldeanoTest {
    /**
     *
     */
    @Test
    void obtenerVidaAldeanoRecienCreado(){
        Aldeano aldeano = new Aldeano();
        int vida = aldeano.getVida();
        Assertions.assertEquals(vida, 50);
    }
}
