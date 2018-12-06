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
import sun.plugin2.util.ColorUtil;

import java.util.Observable;
import java.util.Observer;

public class Casillero extends Rectangle implements Observer {
    Faccion faccion1;
    Faccion faccion2;

    public Casillero(Celda celda, Faccion faccion1Recibida, Faccion faccion2Recibida) {
        super(15, 15);
        faccion1 = faccion1Recibida;
        faccion2 = faccion2Recibida;
        setStroke(Color.BLACK);
        setStrokeWidth(0.25);
        rellenar(celda.getElemento());
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
            setStroke(Color.BLACK);
            setStrokeWidth(0.25);
            return;
        }

        String nombre = ubicable.getClass().toString();
        String cadena = "Recursos/" + nombre + ".png";
        Image imagen = new Image(cadena);
        ImagePattern pattern = new ImagePattern(imagen);
        setFill(pattern);
        if(ubicable.getFaccion() == faccion1) {
            setStroke(Color.rgb(0, 0, 255));
        }
        if(ubicable.getFaccion() == faccion2) {
            setStroke(Color.rgb(255, 0, 0));
        }
        setStrokeWidth(1);
    }

    @Override
    public void update(Observable o, Object contenido) {
        rellenar((Ubicable)contenido);
    }


}