package Vista;

import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Juego.ControladorDeTurnos;
import Modelo.Juego.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.Celda;
import Modelo.Mapa.Mapa;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class PantallaDelJuego {
    ArrayList<Casillero> casilleros;
    static BorderPane distribucion;
    Jugador jugador1;
    Jugador jugador2;
    static String nombreJugador1;
    static String nombreJugador2;
    static ControladorDeTurnos controladorDeTurnos;
    static Juego juego;

    public static void actualizarPanelInferior(DetallePieza detallePieza) {
        distribucion.setBottom(detallePieza);
    }



    Scene crearEscenaJuego(String nombreJugador1Recibido, String nombreJugador2Recibido) throws PosicionInvalidaException {
        juego = new Juego();
        juego.inicializarJuego();
        juego.iniciarPrimerTurno();
        controladorDeTurnos = juego.getControladorDeTurnos();
        Mapa mapaJuego = juego.getMapa();
        jugador1 = juego.getJugador1();
        jugador2 = juego.getJugador2();
        nombreJugador1 = nombreJugador1Recibido;
        nombreJugador2 = nombreJugador2Recibido;

        //Hacemos el contorno
        distribucion = new BorderPane();

        //Creo HBox para arriba y abajo; y GridPane para el centro
        PanelSuperior informacionJugadores = new PanelSuperior(juego, nombreJugador1, nombreJugador2);

        GridPane mapa = new GridPane();
        distribucion.setTop(informacionJugadores);

        //distribucion.setBottom(accionesUbicable);
        distribucion.setCenter(mapa);


        //Seteo el GridPane del mapa .
        mapa.setPadding(new Insets(20, 20, 20, 20));
        mapa.setGridLinesVisible(true);
        mapa.setAlignment(Pos.TOP_CENTER);

        Celda celdas[][] = mapaJuego.obtenerCeldas();
        casilleros = new ArrayList<>();
        for (int i = 0; i < mapaJuego.getLargo(); i++) {
            for (int j = 0; j < mapaJuego.getAncho(); j++) {
                Celda celdaActual = celdas[i][j];
                Casillero casillero = new Casillero(celdaActual);
                celdaActual.addObserver(casillero);

                mapa.setConstraints(casillero, i, j);
                mapa.getChildren().addAll(casillero);
                casilleros.add(casillero);
            }
        }

        //Seteo el Hbox de las acciones de los ubicables
        //Tengo que hacer algo?


        Scene escena = new Scene(distribucion, 800, 700);

        return escena;
    }

    public static void actualizarPanelSuperior(PanelSuperior panelSuperiorRecibido){
        distribucion.setTop(panelSuperiorRecibido);
    }



    public static void actualizarPantallaSuperior() {
        PanelSuperior panelSuperior = new PanelSuperior(juego, nombreJugador1, nombreJugador2);
        distribucion.setTop(panelSuperior);
    }

    public static void actualizarPantallaSuperior(String advertencia) {
        PanelSuperior panelSuperior = new PanelSuperior(juego, advertencia, nombreJugador1, nombreJugador2);
        distribucion.setTop(panelSuperior);
    }


    public static void actualizarAccionesUbicable(Ubicable ubicable) {

        actualizarPanelInferior(new DetallePieza(ubicable));
    }

}