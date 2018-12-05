package Vista;

import Controladores.BotonAtacar;
import Controladores.Comandos.Comando;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DetallePieza extends HBox {

    public void actualizarAcciones(Ubicable ubicable){

    }

    public DetallePieza(Ubicable ubicable) {
        setAlignment(Pos.CENTER);

        if (ubicable == null){
            Label vacio = new Label("Posicion vacia");
            getChildren().add(vacio);
            PantallaDelJuego.actualizarPanelInferior(this);
            return;
        }
        String vida = "Vida: " + ubicable.getvida();
        Label etiquetaVida = new Label(vida);
        getChildren().add(etiquetaVida);

        GridPane acciones = new GridPane();
        acciones.setHgap(8);
        acciones.setVgap(5);
        acciones.setPadding(new Insets(5,8,5,8));
        String nombre = ubicable.getClass().getName();
        if (nombre == "Modelo.Ubicables.Unidades.Aldeano"){
            actualizarAccionesAldeano((Aldeano) ubicable, acciones);
        }

        //setPadding(new Insets(10,25,10,10));
        setSpacing(10);

    }

    public void actualizarAccionesAldeano(Aldeano aldeano,GridPane acciones){

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
                    PantallaDelJuego.actualizarPantallaSuperior("El ubicable esta ocupado");
                    return;
                } catch (PosicionInvalidaException e) {
                    System.out.println("La posicion de destino no es valida");
                    PantallaDelJuego.actualizarPantallaSuperior("La posicion de destino no es valida");
                    return;
                } catch (OroInsuficienteException e) {
                    System.out.println("Oro insuficiente");
                    PantallaDelJuego.actualizarPantallaSuperior("Oro insuficiente");
                    return;
                }
                PantallaDelJuego.actualizarPantallaSuperior();
            }
        });



        acciones.setConstraints(opcionesConstruir,0,0);
        acciones.setConstraints(construir,1,0);
        acciones.getChildren().addAll(construir, opcionesConstruir);
        getChildren().addAll(direccionesMover, acciones);



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
                        PantallaDelJuego.actualizarPantallaSuperior("El ubicable esta ocupado");
                        return;

                    } catch (PosicionInvalidaException e1) {
                        PantallaDelJuego.actualizarPantallaSuperior("La Posicion es invalida");
                        return;

                    }
                    PantallaDelJuego.actualizarPantallaSuperior();
                });
            }

        }
        return direccionesMover;
    }
}
