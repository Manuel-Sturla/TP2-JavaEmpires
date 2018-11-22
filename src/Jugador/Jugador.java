package Jugador;

import Turnos.ControladorTurnos;
import Ubicables.Ubicable;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

    ArrayList elementos = new ArrayList();
    Iterator<Ubicable> iterador;
    Faccion faccion;
    String nombre;
    static ControladorTurnos controlador;

    //Constructor que recibe coleccion! de ubicab+les generica y los agrega
    public Jugador(ArrayList <Ubicable> elementosRecibidos, Faccion faccionRecibida){
        elementos = new ArrayList(elementosRecibidos);
        faccion = faccionRecibida;

    }



    public ArrayList <Ubicable> getElementos() {
        return new ArrayList<Ubicable>(elementos);
    }

    public void setControlador(ControladorTurnos controladorTurnos){
        controlador = controladorTurnos;
    }
    public Ubicable iniciarTurno() {
        iterador = elementos.iterator();
        return this.siguiente();
    }

    public Ubicable siguiente(){
        if (!iterador.hasNext()){
            this.finalizarTurno();
            return null;
        }
        return iterador.next();
    }

    public void finalizarTurno(){
        iterador = elementos.iterator();
        while (iterador.hasNext()){
            if(iterador.next().estaMuerto()){
                iterador.remove();
            }
        }
        //Le avisa al manejador de turnos que termino el turno
        controlador.siguienteTurno();
    }

    public void agregar(Ubicable elemento) {
        elementos.add(elementos.size(),elemento);
    }

}
