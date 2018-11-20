package Ubicables.Unidades;

import Tablero.Posicion;
import Turnos.Ocupado;
import Ubicables.Ubicable;

public class Espadachin extends Unidad {

    public Espadachin(Posicion posicionRescibida) {
        super(100, posicionRescibida);
    }

    public void atacarUnidad(Ubicable objetivo){

    }

    public void quitarVida(int dañoRecibido) {
        vida -= dañoRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }
    @Override
    public boolean estaMuerto() {
        return vida<1; //estado.estaMuerto();
    }
}
