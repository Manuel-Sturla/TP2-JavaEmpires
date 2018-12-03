package Vista;

import Controladores.ManejadorDeCasilleros;
import Exceptions.OroInsuficienteException;
import Exceptions.PosicionInvalidaException;
import Exceptions.UbicableEstaOcupadoException;
import Juego.Juego;
import Mapa.Celda;
import Mapa.Mapa;
import Posiciones.Posicion;
import Ubicables.Ubicable;
import Ubicables.Unidades.Aldeano;
import Ubicables.Unidades.Unidad;
import javafx.application.Application;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application {
    ArrayList<Casillero> casilleros;
    static BorderPane distribucion;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage ventana) throws Exception {
        /*
        Escena inicial y boton para iniciar juego desencadena lo siguiente (de alguna manera)
         */
        //Seteos iniciales de la escena
        //Iniciamos el juego con juego.iniciar() --> hace que se actualicen las cosas
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.iniciarPrimerTurno();
        juego.getControladorDeTurnos();
        Mapa mapa = juego.getMapa();

        Scene escenaJuego = crearEscenaJuego(mapa);
        ventana.setScene(escenaJuego);
        ventana.setTitle("#AlgoOfEmpires");

        ventana.show();
    }
/*
    private void hashearMetodos(){
        metodos= new Hashtable();
        metodos.put("Ubicables.Unidades.Aldeano", actualizarAccionesAldeano() );
        metodos.put("Ubicables.Unidades.Espadachin", actualizarAccionesEjercito() );
        metodos.put("Ubicables.Unidades.Arquero", actualizarAccionesEjercito() );
        metodos.put("Ubicables.Unidades.ArmaDeAsedio", actualizarAccionesEjercitoArmaDeAsedio() );
        metodos.put("Ubicables.Edificios.Castillo", actualizarAccionesCastillo());
        metodos.put("Ubicables.Edificios.PlazaCentral", actualizarAccionesPlazaCentral() );
        metodos.put("Ubicables.Edificios.Cuartel", actualizarAccionesCuartel() );
    }
*/
    private Scene crearEscenaJuego(Mapa mapaRecibido) {

        //Hacemos el contorno
        distribucion = new BorderPane();

        //Creo HBox para arriba y abajo; y GridPane para el centro
        HBox informacionJugadores = new HBox();

        GridPane mapa = new GridPane();
        distribucion.setTop(informacionJugadores);
        //distribucion.setBottom(accionesUbicable);
        distribucion.setCenter(mapa);

        //Seteo el Hbox de la informacion de los jugadores

        Label nombreJugador1 = new Label("Jugador1");
        Label nombreJugador2 = new Label("Jugador2");

        informacionJugadores.setSpacing(10);
        informacionJugadores.setAlignment(Pos.CENTER);
        informacionJugadores.getChildren().addAll(nombreJugador1, nombreJugador2);

        //Seteo el GridPane del mapa .
        mapa.setPadding(new Insets(20, 20, 20, 20));
        mapa.setGridLinesVisible(true);

        Celda celdas[][] = mapaRecibido.obtenerCeldas();
        casilleros = new ArrayList<>();
        for (int i = 0; i < mapaRecibido.getLargo(); i++) {
            for (int j = 0; j < mapaRecibido.getAncho(); j++) {
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
        if(ubicable == null) return;
        GridPane acciones = new GridPane();
        acciones.setHgap(8);
        acciones.setVgap(5);
        String nombre = ubicable.getClass().getName();
        if (nombre == "Ubicables.Unidades.Aldeano"){
            actualizarAccionesAldeano((Aldeano) ubicable);
        }


    }
    public static void actualizarAccionesAldeano(Aldeano aldeano){
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


        Button construir = new Button("Contruir");
        ChoiceBox <String> opcionesConstruir= new ChoiceBox<>();
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
}
