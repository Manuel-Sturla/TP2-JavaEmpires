package Ubicables.Unidades;

import Exceptions.ArmaNoDesmontadaException;
import Exceptions.MovimientoNoPermitidoException;
import Exceptions.UbicableEstaOcupadoException;
import Jugador.Faccion;
import Tablero.Posicion;
import Turnos.Ocupado;

public class ArmaDeAsedio extends Unidad {
        boolean montada = false;
        Faccion faccion;

    public ArmaDeAsedio(Posicion posicion, Faccion faccionRecibida){
            super(150,posicion);
            faccion = faccionRecibida;
        }


    public void montarArma() {
            montada = true;
        }

        public void desmontarArma(){ montada = false;}

        public boolean getEstaMontada() {
            return montada;
        }


    @Override
    public boolean estaMuerto() {
        return vida<1;
    }

    public void recibirDanio(int danioRecibido) {
        vida -= danioRecibido;
        if(vida < 1){
            estado = new Ocupado(100); //estado = new Muerto(); EL ESTADO MUERTO NO ESTA POR AHORA NO PARECE SER NECESARIO
        }
    }

    public int getVida(){return vida;}
    @Override
    public void moverDerecha() throws MovimientoNoPermitidoException, UbicableEstaOcupadoException {
        if (this.getEstaMontada()) {
            //throw new ArmaNoDesmontadaException();
            return;
        }
        super.moverDerecha();

    }
}
