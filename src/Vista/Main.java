package Vista;

import Controladores.ManejadorDeCasilleros;
import Juego.Juego;
import Mapa.Celda;
import Mapa.Mapa;
import Posiciones.Posicion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application implements Observer {
    ArrayList<Casillero> casilleros;
    public static void main(String[] args){ launch(args); }


    @Override
    public void start(Stage ventana) throws Exception {
        /*
        Escena inicial y boton para iniciar juego desencadena lo siguiente (de alguna manera)
         */
        //Seteos iniciales de la escena
        //Iniciamos el juego con juego.iniciar() --> hace que se actualicen las cosas
        Juego juego = new Juego();
        juego.inicializarJuego();

        Mapa mapa = juego.getMapa();

        Scene escenaJuego = crearEscenaJuego(mapa);
        ventana.setScene(escenaJuego);
        ventana.setTitle("#AlgoOfEmpires");

        ventana.show();
    }


    private Scene crearEscenaJuego(Mapa mapaRecibido ){

        //Hacemos el contorno
        BorderPane distribucion = new BorderPane();

        //Creo HBox para arriba y abajo; y GridPane para el centro
        HBox informacionJugadores = new HBox();
        HBox accionesUbicable = new HBox();
        GridPane mapa = new GridPane();
        distribucion.setTop(informacionJugadores);
        distribucion.setBottom(accionesUbicable);
        distribucion.setCenter(mapa);

        //Seteo el Hbox de la informacion de los jugadores

        Label nombreJugador1 = new Label("Jugador1");
        Label nombreJugador2 = new Label("Jugador2");

        informacionJugadores.setSpacing(10);
        informacionJugadores.setAlignment(Pos.CENTER);
        informacionJugadores.getChildren().addAll(nombreJugador1,nombreJugador2);

        //Seteo el GridPane del mapa .----
        mapa.setPadding(new Insets(20, 20, 20, 20));
        mapa.setGridLinesVisible(true);

        Celda celdas[][]=mapaRecibido.obtenerCeldas();
        casilleros = new ArrayList<>();
        for (int i = 0; i < mapaRecibido.getLargo(); i++) {
            for (int j = 0; j < mapaRecibido.getAncho(); j++) {
                Celda celdaActual = celdas[i][j];
                Casillero casillero = new Casillero(celdaActual);
                celdaActual.addObserver(casillero);

                mapa.setConstraints(casillero,i,j);
                mapa.getChildren().addAll(casillero);
                casilleros.add(casillero);
            }
        }

        //Seteo el Hbox de las acciones de los ubicables
            //Tengo que hacer algo?


        Scene escena = new Scene(distribucion,1024,920);

        return escena;
    }




}
