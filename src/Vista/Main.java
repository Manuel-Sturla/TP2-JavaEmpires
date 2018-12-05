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

        PantallaInicio pantallaInicio = new PantallaInicio();
        ventana.setScene(pantallaInicio.crearEscenaInicio(ventana));

        ventana.show();
    }

/*
    private void hashearMetodos(){
        metodos= new Hashtable();
        metodos.put("Modelo.Ubicables.Unidades.Aldeano", actualizarAccionesAldeano() );
        metodos.put("Modelo.Ubicables.Unidades.Espadachin", actualizarAccionesEjercito() );
        metodos.put("Modelo.Ubicables.Unidades.Arquero", actualizarAccionesEjercito() );
        metodos.put("Modelo.Ubicables.Unidades.ArmaDeAsedio", actualizarAccionesEjercitoArmaDeAsedio() );
        metodos.put("Modelo.Ubicables.Edificios.Castillo", actualizarAccionesCastillo());
        metodos.put("Modelo.Ubicables.Edificios.PlazaCentral", actualizarAccionesPlazaCentral() );
        metodos.put("Modelo.Ubicables.Edificios.Cuartel", actualizarAccionesCuartel() );
    }
*/
}