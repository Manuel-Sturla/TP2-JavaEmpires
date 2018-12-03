package Vista;

import Mapa.Celda;
import Ubicables.Ubicable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class Casillero extends Rectangle implements Observer {
    //LO COMENTADO ES DE OTRA VERSION. DESPUES LO SACO SI ES NECESARIO -Manu
    //Celda celdaRepresentada;

    public Casillero(Celda celda) {
        super(15, 15);
        //celdaRepresentada = celda;
        //rellenar();
        rellenar(celda.getElemento());
        setStroke(Color.BLACK);
        setStrokeWidth(0.25);

    }

    private void rellenar(Ubicable ubicable) {
        /*
        if(!celdaRepresentada.estaOcupada()){
            setFill(Color.BURLYWOOD);
            return;
        }*/
        if (ubicable == null){
            setFill(Color.BURLYWOOD);
            return;
        }
        //String nombre = celdaRepresentada.getElemento().getClass().toString();
        String nombre = ubicable.getClass().toString();
        String cadena = "Recursos/" + nombre + ".png";
        Image imagen = new Image(cadena);
        setFill(new ImagePattern(imagen));


        //Si es jugador1 --> contorno azul y sino violeta
    }

    @Override
    public void update(Observable o, Object contenido) {
        rellenar((Ubicable) contenido);
    }


}