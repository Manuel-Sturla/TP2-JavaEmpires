package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    static Stage ventana;
    public static void main(String[] args) {
        launch(args);
    }

    public static void actualizar() {

        ventana.show();
    }


    @Override
    public void start(Stage stage) throws Exception {
        ventana = stage;
        PantallaInicio pantallaInicio = new PantallaInicio(new PantallaFinJuego(ventana));
        ventana.setScene(pantallaInicio.crearEscenaInicio(ventana));

        ventana.show();
    }


}