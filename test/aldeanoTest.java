import junit.framework.Assert;
import org.junit.Test;

public class aldeanoTest {
    @Test
    private void obtenerVidaAldeanoRecienCreado(){
        Aldeano aldeano = new Aldeano();
        int vida = aldeano.getVida();
        Assert.assertEquals(vida, 50);
    }
}
