package Vista;

import Modelo.Exceptions.FinDelJuego;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Juego.ControladorDeTurnos;
import Modelo.Juego.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.Mapa;
import Modelo.Ubicables.Ubicable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class PantallaDelJuego {
    PantallaFinJuego pantallaFinJuego;
    ArrayList<Casillero> casilleros;
    static BorderPane distribucion;
    Jugador jugador1;
    Jugador jugador2;
    static String nombreJugador1;
    static String nombreJugador2;
    static ControladorDeTurnos controladorDeTurnos;
    static Juego juego;
    static ArrayList<MediaPlayer> sonido = new ArrayList();
    static MediaPlayer musicaDeFondo;
    static boolean mudo = false;

    public PantallaDelJuego(PantallaFinJuego pantallaFinJuegoRecibida) throws PosicionInvalidaException, FinDelJuego {
        juego = new Juego();
        juego.inicializarJuego();
        juego.iniciarPrimerTurno();
        controladorDeTurnos = juego.getControladorDeTurnos();
        jugador1 = juego.getJugador1();
        jugador2 = juego.getJugador2();
        pantallaFinJuego = pantallaFinJuegoRecibida;
        pantallaFinJuego.agregarControlador(controladorDeTurnos);

    }

    Scene crearEscenaJuego(String nombreJugador1Recibido, String nombreJugador2Recibido) {
        nombreJugador1 = nombreJugador1Recibido;
        nombreJugador2 = nombreJugador2Recibido;
        Mapa mapaJuego = juego.getMapa();


        //Hacemos el contorno
        distribucion = new BorderPane();

        //Creo HBox para arriba y abajo; y GridPane para el centro
        PanelSuperior informacionJugadores = new PanelSuperior(juego, nombreJugador1, nombreJugador2);

        GridPane mapa = new GridPane();
        distribucion.setTop(informacionJugadores);

        VistaMapa vistaMapa = new VistaMapa(mapaJuego, jugador1.getFaccion(), jugador2.getFaccion());
        distribucion.setCenter(vistaMapa);


        //Seteo el Hbox de las acciones de los ubicables
        //Tengo que hacer algo?


        Scene escena = new Scene(distribucion, 800, 700);

        return escena;
    }



    public static void actualizarPantallaSuperior() {
        PanelSuperior panelSuperior = new PanelSuperior(juego, nombreJugador1, nombreJugador2);
        distribucion.setTop(panelSuperior);
    }

    public static void actualizarPantallaSuperior(String advertencia) {
        PanelSuperior panelSuperior = new PanelSuperior(juego, advertencia, nombreJugador1, nombreJugador2);
        distribucion.setTop(panelSuperior);
    }

    public static void actualizarAccionesUbicable(Ubicable ubicable) {
        actualizarPanelInferior(new DetallePieza(ubicable));
    }

    public static void actualizarPanelInferior(DetallePieza detallePieza) {
        distribucion.setBottom(detallePieza);
        Main.actualizar();
    }
    public static void mutear(){
        if (mudo == true) mudo=false;
        else if (mudo == false) mudo=true;
    }
    public static void musicaFondo(Class c) {
        Media media = new Media(c.getResource("/Recursos/Sonido/MusicaDeFondoAOE.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        musicaDeFondo = mediaPlayer;
    }
    public static void frenarSonidos() {

        if(musicaDeFondo.getStatus().equals(MediaPlayer.Status.PLAYING)) musicaDeFondo.pause();
        else musicaDeFondo.play();
    }
}