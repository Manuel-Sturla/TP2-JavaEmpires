package Vista;

import Modelo.Mapa.Celda;
import Modelo.Mapa.Mapa;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class VistaMapa extends StackPane {
    Mapa mapaJuego;
    static GridPane casillerosObjetivo;
    static GridPane mapa;

    public VistaMapa(Mapa mapaRecibido){
        mapaJuego = mapaRecibido;
        mapa = new GridPane();
        casillerosObjetivo = new GridPane();
        //Seteo el GridPane del mapa .
        mapa.setPadding(new Insets(20, 20, 20, 20));
        mapa.setGridLinesVisible(true);
        mapa.setAlignment(Pos.TOP_CENTER);
        casillerosObjetivo.setPadding(new Insets(20, 20, 20, 20));
        casillerosObjetivo.setGridLinesVisible(true);
        casillerosObjetivo.setAlignment(Pos.TOP_CENTER);

        Celda celdas[][] = mapaJuego.obtenerCeldas();

        for (int i = 0; i < mapaJuego.getLargo(); i++) {
            for (int j = 0; j < mapaJuego.getAncho(); j++) {
                Celda celdaActual = celdas[i][j];
                Casillero casillero = new Casillero(celdaActual);
                CasilleroObjetivo casilleroObjetivo = new CasilleroObjetivo(celdaActual);
                celdaActual.addObserver(casillero);

                casillerosObjetivo.setConstraints(casilleroObjetivo,i,j);
                casillerosObjetivo.getChildren().add(casilleroObjetivo);
                mapa.setConstraints(casillero, i, j);
                mapa.getChildren().addAll(casillero);

            }
        }
        getChildren().addAll( casillerosObjetivo, mapa);

    }

    public static void moverAlFrenteCasillerosObjetivo() {
        casillerosObjetivo.toFront();

    }

    public static void moverAlFrenteCasilleros() {
        mapa.toFront();
    }
}
