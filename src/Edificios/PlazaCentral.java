package Edificios;
import Tablero.Posicion;
import Unidades.Aldeano;


public class PlazaCentral extends Edificio {


    public PlazaCentral(Posicion pos){
        super(450,450,pos); //Usa constructor de edificio estan puestos de la sieguiente forma vida vidaTotal posicion
    }

/*
    public boolean crearAldeano(){
        Aldeano aldeano = new Aldeano(posicion);
        return posicion.ubicarElementoDeMapa(aldeano);
    }

*/
}
