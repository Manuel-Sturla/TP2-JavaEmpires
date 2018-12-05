package Vista;

import Modelo.Exceptions.PosicionInvalidaException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PantallaInicio {
    PantallaDelJuego pantallaDelJuego;

    public PantallaInicio(){
        pantallaDelJuego = new PantallaDelJuego();
    }

    public Scene crearEscenaInicio(Stage ventana){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(20);
        grid.setHgap(20);

        Label nombreJuego = new Label("JAVA EMPIRES");
        nombreJuego.setTextFill(Color.rgb(255,255,0));
        nombreJuego.setFont(new Font(27));
        GridPane.setConstraints(nombreJuego, 2,1);

        Label jugador1 = new Label("Jugador 1");
        jugador1.setTextFill(Color.rgb(255,255,255));
        GridPane.setConstraints(jugador1, 0, 4);

        Label jugador2 = new Label("Jugador 2");
        jugador2.setTextFill(Color.rgb(255,255,255));
        GridPane.setConstraints(jugador2, 3, 4);

        TextField nombreJugador1 = new TextField("Hector");
        GridPane.setConstraints(nombreJugador1, 0, 5);

        TextField nombreJugador2 = new TextField("Aquiles");
        GridPane.setConstraints(nombreJugador2, 3, 5);

        Button iniciarJuego = new Button("Empezar Juego");
        iniciarJuego.setMinSize(200,65);
        iniciarJuego.setStyle("-fx-background-color:yellow");
        iniciarJuego.setOnAction(event -> {
            try {
                String jugador1Nombre = String.valueOf(nombreJugador1.getText());
                String jugador2Nombre = String.valueOf(nombreJugador2.getText());
                ventana.setScene(pantallaDelJuego.crearEscenaJuego(jugador1Nombre, jugador2Nombre));
            } catch (PosicionInvalidaException e) {
                e.printStackTrace();
            }
        });
        GridPane.setConstraints(iniciarJuego, 2, 10);

        Image imagenFondo = new Image("file:/home/diego/algo/TP2-Algo3/pruebInicioJuego/Inicio.jpg",800,620,false, false);
        BackgroundImage bc = new BackgroundImage(imagenFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        grid.setBackground(new Background(bc));
        grid.getChildren().addAll(nombreJuego, jugador1, jugador2, nombreJugador1, nombreJugador2, iniciarJuego);

        Scene scene = new Scene(grid, 600, 600);
        return scene;
    }
}
