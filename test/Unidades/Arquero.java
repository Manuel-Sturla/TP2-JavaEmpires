package Unidades;

import Exceptions.PosicionFueraDeRangoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;
import Ubicables.Unidades.Unidad;

public class Arquero extends Unidad {
    Faccion faccion;

    public Arquero(Posicion posicionRecibida, Faccion faccionRecibida) {
        super(100, posicionRecibida);
        faccion = faccionRecibida;
        faccion.agregarMiembro(this);
    }

    public void atacarUnidad(Unidad objetivo) throws PosicionFueraDeRangoException {
        posicion.estaEnRango(objetivo.getPosicion(), 3);
        if(!faccion.perteneceFaccion(objetivo)) {
            objetivo.recibirDanio(25);
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }


    public boolean estaMuerto() {
        return false;
    }

    @Override
    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }
}
