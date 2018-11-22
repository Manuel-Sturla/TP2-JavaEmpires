package Ubicables.Unidades;

import Jugador.Faccion;
import Tablero.*;
import Turnos.Ocupado;

public class Espadachin extends Unidad {
    Faccion faccion;

    public Espadachin(Posicion posicionRecibida, Faccion faccionRecibida) {
        super(100, posicionRecibida);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }

    public void atacarUnidad(Unidad objetivo){
        //posicion.estaEnRango(objetivo, 1
        if(!faccion.perteneceFaccion(objetivo)) {
            objetivo.recibirDanio(25);
        }
    }

    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }
    @Override
    public boolean estaMuerto() {
        return vida<1; //estado.estaMuerto();
    }
}
