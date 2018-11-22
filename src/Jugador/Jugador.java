package Jugador;

import Ubicables.Ubicable;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

    ArrayList elementos = new ArrayList();
    Iterator<Ubicable> iterador;
    Faccion faccion;
    String nombre;

    /* obsoleto?
    public Jugador(Aldeano aldeanos[], Castillo castillo){
        //Crea al jugador con sus 3 aldeanos iniciales y su castillo
        elementos[0] = castillo;
        for (int i =1; i<3; i++){
            elementos[i]=aldeanos[i-1];
        }
    }
*/
    //Constructor que recibe coleccion! de ubicab+les generica y los agrega
    public Jugador(ArrayList <Ubicable> elementosRecibidos, Faccion faccionRecibida){
        elementos = new ArrayList(elementosRecibidos);
        faccion = faccionRecibida;

    }

    public void inicializarJuego(){
    }

    public ArrayList <Ubicable> getElementos() {
        return new ArrayList<Ubicable>(elementos);
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
    }

    public void agregar(Ubicable elemento) {
        elementos.add(elementos.size(),elemento);
    }

}
