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
    Jugador jugado1;
    Jugador jugado2;
    static ControladorDeTurnos controladorDeTurnos;
    static Juego juego;

    Scene crearEscenaJuego() throws PosicionInvalidaException {
        juego = new Juego();
        juego.inicializarJuego();
        juego.iniciarPrimerTurno();
        controladorDeTurnos = juego.getControladorDeTurnos();
        Mapa mapaJuego = juego.getMapa();
        jugado1 = juego.getJugador1();
        jugado2 = juego.getJugador2();

        //Hacemos el contorno
        distribucion = new BorderPane();

        //Creo HBox para arriba y abajo; y GridPane para el centro
        PanelSuperior informacionJugadores = new PanelSuperior(juego);

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


        Scene escena = new Scene(distribucion, 1024, 920);

        return escena;
    }

    public static void actualizarAccionesUbicable(Ubicable ubicable) {
        if (ubicable == null){
        Label vacio = new Label("vacio");
        distribucion.setBottom(vacio);
        return;
        }
        GridPane acciones = new GridPane();
        acciones.setHgap(8);
        acciones.setVgap(5);
        String nombre = ubicable.getClass().getName();
        if (nombre == "Modelo.Ubicables.Unidades.Aldeano"){
            actualizarAccionesAldeano((Aldeano) ubicable);
        }

    }

    public static void actualizarPanelSuperior(PanelSuperior panelSuperiorRescivido){
        distribucion.setTop(panelSuperiorRescivido);
    }

    public static void actualizarAccionesAldeano(Aldeano aldeano){

        GridPane direccionesMover = botonesDeMovimiento(aldeano);

        Button construir = new Button("Contruir");
        ChoiceBox<String> opcionesConstruir= new ChoiceBox<>();
        opcionesConstruir.getItems().add("Plaza Central");
        opcionesConstruir.getItems().add("Cuartel");
        opcionesConstruir.setValue("Plaza Central");
        construir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    if(opcionesConstruir.getValue() == "Plaza Central"){
                        aldeano.crearPlazaCentral();
                    }else {
                        aldeano.crearCuartel();
                    }
                } catch (UbicableEstaOcupadoException e) {
                    System.out.println("El ubicable esta ocupado");
                } catch (PosicionInvalidaException e) {
                    System.out.println("La posicion de destino no es valida");
                } catch (OroInsuficienteException e) {
                    System.out.println("Oro insuficiente");
                }
            }
        });

        HBox accionesUbicable = new HBox();
        GridPane acciones = new GridPane();
        acciones.setVgap(5);
        acciones.setHgap(7);
        acciones.setConstraints(opcionesConstruir,0,0);
        acciones.setConstraints(construir,1,0);
        acciones.getChildren().addAll(construir, opcionesConstruir);
        accionesUbicable.getChildren().addAll(direccionesMover, acciones);


        distribucion.setBottom(accionesUbicable);
    }


    private static GridPane botonesDeMovimiento(Aldeano aldeano) {
        String imagenesDireccion[][] = new String[3][3];
        imagenesDireccion[0][0] =  "izq-arriba";
        imagenesDireccion[0][1]= "arriba-arriba";
        imagenesDireccion[0][2]= "der-arriba";
        imagenesDireccion[1][0]= "izq-izq";
        imagenesDireccion[1][2]= "der-der";
        imagenesDireccion[2][0]= "izq-abajo";
        imagenesDireccion[2][1]= "abajo-abajo";
        imagenesDireccion[2][2] = "der-abajo";

        GridPane direccionesMover = new GridPane();
        direccionesMover.setHgap(7);
        direccionesMover.setVgap(5);
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==1 && j==1) continue;
                Button mover = new Button();

                String nombre = imagenesDireccion[i][j];
                Image imagen = new Image("Recursos/" + nombre + ".png");
                ImageView imageView = new ImageView(imagen);
                imageView.setFitHeight(10);
                imageView.setFitWidth(10);
                mover.setGraphic(imageView);
                direccionesMover.setConstraints(mover, j,i);
                direccionesMover.getChildren().add(mover);
                mover.setOnAction(e ->
                {
                    try {
                        aldeano.moverAbajo(); //LO HARDCODEO PARA MAS PLACER - Manu
                    } catch (UbicableEstaOcupadoException e1) {
                        e1.printStackTrace();
                    } catch (PosicionInvalidaException e1) {
                        e1.printStackTrace();
                    }
                });
            }

        }
    return direccionesMover;
    }

    public static void actualizarPantallaSuperior() {
        PanelSuperior panelSuperior = new PanelSuperior(juego);
        distribucion.setTop(panelSuperior);
    }

}