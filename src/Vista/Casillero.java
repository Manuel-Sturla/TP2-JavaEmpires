package Vista;

import Modelo.Mapa.Celda;
import Modelo.Ubicables.Ubicable;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class Casillero extends Rectangle implements Observer {


    public Casillero(Celda celda) {
        super(15, 15);
        rellenar(celda.getElemento());
        setStroke(Color.BLACK);
        setStrokeWidth(0.25);
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    setStroke(Color.WHITE);
                    setStrokeWidth(1);
                    Main.actualizar();
                }

        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setStroke(Color.BLACK);
                setStrokeWidth(0.25);
                Main.actualizar();
            }
        });
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PantallaDelJuego.actualizarAccionesUbicable(celda.getElemento());
                PantallaDelJuego.actualizarPantallaSuperior();
            }
        });
    }

    private void rellenar(Ubicable ubicable) {
       if (ubicable == null){
            setFill(Color.BURLYWOOD);
            return;
        }


        String nombre = ubicable.getClass().toString();
        String cadena = "Recursos/" + nombre + ".png";
        Image imagen = new Image(cadena);
        setFill(new ImagePattern(imagen));


    }

    @Override
    public void update(Observable o, Object contenido) {
        rellenar((Ubicable) contenido);
    }


}