package Controladores;

import Controladores.Comandos.Comando;
import Modelo.Posiciones.Posicion;
import Vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {
    Comando comando;
    Posicion posicionUbicable;

    public BotonAtacar(Comando comandoRecibido, Posicion posicion){
        comando = comandoRecibido;
        posicionUbicable = posicion;
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VistaMapa.moverAlFrenteCasillerosObjetivo();


            }
        });
    }

}
