package Modelo.Ubicables.Unidades;

import Controladores.Comandos.Atacar;
import Controladores.Comandos.Comando;
import Modelo.Exceptions.PosicionInvalidaException;
import Modelo.Exceptions.UbicableDeMismaFaccionException;
import Modelo.Exceptions.UbicableFueraDeRangoException;
import Modelo.Posiciones.Posicion;
import Modelo.Ubicables.Edificios.Edificio;

import java.util.ArrayList;

public class Arquero extends Unidad implements Ejercito{

    public Arquero(Posicion posicionRecibida) throws PosicionInvalidaException {
        super(75, posicionRecibida);
        posicionRecibida.getMapa().ocuparCelda(this, posicionRecibida);
    }


    public void atacar(Unidad objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        super.atacar(objetivo, 3);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }
    public void atacar(Edificio objetivo) throws PosicionInvalidaException, UbicableFueraDeRangoException, UbicableDeMismaFaccionException {
        super.atacar(objetivo, 3);
        objetivo.recibirDanio(this);
        ocuparUnTurno();
    }

    public ArrayList<Comando> getAcciones(){
        ArrayList<Comando> acciones = new ArrayList<>();
        acciones.add(new Atacar(this));
        return acciones;
    }
}
