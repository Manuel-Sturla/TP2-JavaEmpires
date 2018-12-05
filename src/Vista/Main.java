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
        /*
        Escena inicial y boton para iniciar juego desencadena lo siguiente (de alguna manera)
         */
        //Seteos iniciales de la escena
        //Iniciamos el juego con juego.iniciar() --> hace que se actualicen las cosas
        ventana = stage;

        PantallaDelJuego pantallaDelJuego = new PantallaDelJuego();
        Scene escenaJuego = (Scene) pantallaDelJuego.crearEscenaJuego();
        ventana.setScene(escenaJuego);
        ventana.setTitle("#AlgoOfEmpires");

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