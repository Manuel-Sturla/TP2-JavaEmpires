package Vista;

import Controladores.Comandos.Comando;
import Controladores.Comandos.ComandoConObjetivo;
import Modelo.Exceptions.*;
import Modelo.Mapa.Celda;
import Modelo.Ubicables.Ubicable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroObjetivo extends Rectangle {

    Ubicable ubicable;
    public CasilleroObjetivo(Celda celda){
        super(15, 15);
        setFill(Color.TRANSPARENT);
        setStroke(Color.TRANSPARENT);
        setStrokeWidth(0.25);
        ubicable = celda.getElemento();


        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ComandoConObjetivo comando = (ComandoConObjetivo) Recordador.obtener();
                try{
                    comando.agregarObjetivo(ubicable);

                }catch (ClassCastException | NullPointerException e){
                    PantallaDelJuego.actualizarPantallaSuperior("El objetivo no es valido");
                    VistaMapa.moverAlFrenteCasilleros();

                    return;
                }


                try{
                    VistaMapa.moverAlFrenteCasilleros();
                    comando.execute();
                    PantallaDelJuego.actualizarPantallaSuperior();
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
                } catch (NullPointerException e){
                    PantallaDelJuego.actualizarPantallaSuperior("La posicion esta vacia");
                }

            }
        });

    }
}
