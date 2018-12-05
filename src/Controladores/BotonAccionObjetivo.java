package Controladores;

import Controladores.Comandos.Comando;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Ubicable;
import Vista.Recordador;
import Vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BotonAccionObjetivo extends Button {
    Comando comando;

    public BotonAccionObjetivo(Comando recibido){
        super();
        comando = recibido;
        setText(comando.getNombre());


        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Recordador.guardar(comando);
                VistaMapa.moverAlFrenteCasillerosObjetivo();

            }
        });

    }
}
