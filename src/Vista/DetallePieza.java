package Vista;

import Controladores.BotonAccionObjetivo;
import Controladores.Comandos.Comando;
import Modelo.Exceptions.*;
import Modelo.Exceptions.OroInsuficienteException;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableEstaOcupadoException;
import Modelo.Ubicables.Ubicable;
import Modelo.Ubicables.Unidades.Aldeano;
import Modelo.Ubicables.Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

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

        ArrayList<Comando>comandos = ubicable.getAcciones();

        for (int i = 0; i < comandos.size(); i++) {

                Comando comandoActual = comandos.get(i);
                if (comandoActual.getNombre()=="Atacar" || comandoActual.getNombre()=="Reparar"){
                    BotonAccionObjetivo botonObjetivo = new BotonAccionObjetivo(comandoActual);
                    acciones.setConstraints(botonObjetivo, 0,i);
                    acciones.getChildren().add(botonObjetivo);
                    continue;
                }
                Button boton = new Button(comandoActual.getNombre());
                boton.setMinSize(150,10);
                boton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            comandoActual.execute();
                            PantallaDelJuego.actualizarPantallaSuperior();
                            Media media = new Media(this.getClass().getResource("/Recursos/Sonido/Button-click.mp3").toExternalForm());
                            MediaPlayer mediaPlayer = new MediaPlayer(media);

                            mediaPlayer.play();
                        } catch (PosicionInvalidaException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("La posicion es invalida");

                        } catch (UbicableEstaOcupadoException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("El ubicable esta ocupado");
                        } catch (OroInsuficienteException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("El oro es insuficiente");
                        } catch (UbicableFueraDeRangoException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("El ubicable seleccionado esta fuera de rango");
                        } catch (UbicableDeMismaFaccionException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("El ubicable seleccionado es del mismo equipo");
                        } catch (UbicableDeOtraFaccionException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("El ubicable seleccionado es de enemigo");
                        } catch (UnidadesMaximasException e) {
                            PantallaDelJuego.actualizarPantallaSuperior("Se alcanzo el limite de poblacion");
                        }
                    }
                });
                acciones.setConstraints(boton, 0,i);
                acciones.getChildren().add(boton);

            }


        ArrayList <Node> botones = new ArrayList<>();
        try {
            GridPane botonesMovimiento = botonesDeMovimiento((Unidad) ubicable);
            botones.add(botonesMovimiento);
        }catch (ClassCastException e){};

        botones.add(acciones);
        getChildren().addAll(botones);
        setSpacing(10);

    }


    private GridPane botonesDeMovimiento(Unidad unidad) {
        GridPane direccionesMover = new GridPane();
        direccionesMover.setHgap(7);
        direccionesMover.setVgap(5);
        ArrayList<Comando> comandosMovimiento = unidad.getAccionesMovimiento();
        Iterator iterador = comandosMovimiento.iterator();
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==1 && j==1) continue;
                Button mover = new Button();

                Comando comando = (Comando) iterador.next();
                Image imagen = new Image("Recursos/" + comando.getNombre() + ".png");
                ImageView imageView = new ImageView(imagen);
                imageView.setFitHeight(10);
                imageView.setFitWidth(10);
                mover.setGraphic(imageView);
                direccionesMover.setConstraints(mover, i,j);
                direccionesMover.getChildren().add(mover);
                mover.setOnAction(e ->{
                    try {
                        comando.execute();
                        PantallaDelJuego.actualizarPantallaSuperior();
                    } catch (PosicionInvalidaException k) {
                        PantallaDelJuego.actualizarPantallaSuperior("La posicion es invalida");

                    } catch (UbicableEstaOcupadoException k) {
                        PantallaDelJuego.actualizarPantallaSuperior("El ubicable esta ocupado");
                    } catch (OroInsuficienteException k) {
                        PantallaDelJuego.actualizarPantallaSuperior("El oro es insuficiente");
                    } catch (UbicableFueraDeRangoException k) {
                        PantallaDelJuego.actualizarPantallaSuperior("El ubicable seleccionado esta fuera de rango");
                    } catch (UbicableDeMismaFaccionException k) {
                        PantallaDelJuego.actualizarPantallaSuperior("El ubicable seleccionado es del mismo equipo");
                    } catch (UbicableDeOtraFaccionException k) {
                        PantallaDelJuego.actualizarPantallaSuperior("El ubicable seleccionado es de enemigo");
                    } catch (UnidadesMaximasException e1) {
                        PantallaDelJuego.actualizarPantallaSuperior("Se alcanzo el limite de poblacion");
                    }
                });
            }

        }
        return direccionesMover;
    }
}
