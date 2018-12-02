package Vista;

import Mapa.Celda;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {

    Celda celdaRepresentada;

    public Casillero(Celda celda) {
        super(15, 15);
        celdaRepresentada = celda;
        rellenar();
        setStroke(Color.BLACK);
        setStrokeWidth(0.25);

    }

    private void rellenar() {

        if(!celdaRepresentada.estaOcupada()){
            setFill(Color.BURLYWOOD);
            return;
        }
        String nombre = celdaRepresentada.getElemento().getClass().toString();
        String cadena = "Recursos/" + nombre + ".png";
        Image imagen = new Image(cadena);
        setFill(new ImagePattern(imagen));

        //Si es jugador1 --> contorno azul y sino violeta
    }

}