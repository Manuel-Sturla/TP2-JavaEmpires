package Vista;

import Modelo.Jugador.Faccion;
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
    Faccion faccion1;

    public Casillero(Celda celda, Faccion faccion1Recibida) {
        super(15, 15);
        faccion1 = faccion1Recibida;
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

        if(ubicable.getFaccion() == faccion1){
            setStroke(Color.rgb(0,0,255));
        }
        else{
            setStroke(Color.rgb(255,0,0));
        }
        setStrokeWidth(100);

        String nombre = ubicable.getClass().toString();
        String cadena = "Recursos/" + nombre + ".png";
        Image imagen = new Image(cadena);
        setFill(new ImagePattern(imagen));



    }

    @Override
    public void update(Observable o, Object contenido) {
        rellenar((Ubicable)contenido);
    }


}