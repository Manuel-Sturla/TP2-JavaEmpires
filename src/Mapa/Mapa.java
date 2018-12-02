package Mapa;

import Exceptions.PosicionInvalidaException;
import Posiciones.Posicion;
import Ubicables.Ubicable;

import java.util.ArrayList;

public class Mapa {
    Celda mapa[][];
    private int largo;
    private int ancho;

    public Mapa(int largoRecibido, int anchoRecibido){
        largo = largoRecibido;
        ancho = anchoRecibido;
        mapa = new Celda[largo][ancho];
        for(int i = 0;i < largo; i++){
            for(int j = 0; j < ancho;j++){
                mapa[i][j] = new Celda();
            }
        }
        //Creo celdas adyacentes para cada celda
        for(int i = 0;i < largo; i++){
            for(int j = 0; j < ancho;j++){
                ArrayList celdasAdyacentes = this.verCeldasAdyacentes(i,j);
                mapa[i][j].setCeldasAdyacentes(celdasAdyacentes);
            }
        }
    }

    private ArrayList verCeldasAdyacentes(int coordenadaHorizontalInicial, int coordenadaVerticalInicial) {
        ArrayList celdasAdyacentes = new ArrayList();
        for(int i= coordenadaHorizontalInicial-1; i < coordenadaHorizontalInicial+2; i++ ){
            for (int j= coordenadaVerticalInicial-1; j < coordenadaVerticalInicial+2; j++){
                if ((i==coordenadaHorizontalInicial) && (j==coordenadaVerticalInicial)){
                    continue;
                }
                try{
                    celdasAdyacentes.add(mapa[i][j]);

                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        return celdasAdyacentes;
    }

    public boolean celdaEstaOcupada(Posicion posicion) throws PosicionInvalidaException {
        return (this.obtenerCelda(posicion).estaOcupada());
    }

    public void ocuparCelda(Ubicable elementoMapa, Posicion posicion) throws PosicionInvalidaException {
        if(this.celdaEstaOcupada(posicion)){
            throw new PosicionInvalidaException();
        }
        this.obtenerCelda(posicion).ocuparCelda(elementoMapa);
    }

    public void desocuparCelda(Posicion posicion) throws PosicionInvalidaException {
        this.obtenerCelda(posicion).desocuparCelda();
    }

    private Celda obtenerCelda(Posicion posicion) throws PosicionInvalidaException {
        int coordenadaHorizontal = posicion.getCoordenadaHorizontal();
        int coordenadaVertical = posicion.getCoordenadaVertical();
        try{
            return mapa[coordenadaHorizontal][coordenadaVertical];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new PosicionInvalidaException();
        }
    }

    public void moverElemento(Posicion posicion, Posicion posicion_llegada) throws PosicionInvalidaException {
        Ubicable elemento = this.obtenerCelda(posicion).getElemento();
        if (this.celdaEstaOcupada(posicion_llegada)){
            throw new PosicionInvalidaException();
        }
        this.obtenerCelda(posicion_llegada).ocuparCelda(elemento);
        this.obtenerCelda(posicion).desocuparCelda();
    }

    public boolean estaEnMapa(Posicion posicion) throws PosicionInvalidaException {
        try{
            this.obtenerCelda(posicion);
            return true;
        }catch (PosicionInvalidaException e){
            return false;
        }
    }


    public boolean esAdyacente(Posicion posicion, Posicion posicion2) throws PosicionInvalidaException {
        return this.obtenerCelda(posicion).esAdyacente(obtenerCelda(posicion2));

    }

    public boolean estaEnRango(Posicion posicion, Posicion posicion2, int rango) throws PosicionInvalidaException {
        Celda celdaBuscada = this.obtenerCelda(posicion2);
        Celda celdaActual = this.obtenerCelda(posicion);
        if(!celdaActual.obtenerCeldasAdyacentesEnRango(rango).contains(celdaBuscada)){
            return false;
        }
        return true;
    }

    public ArrayList<Celda> obtenerCeldasAdyacentesEnRango(Posicion posicion, int rango) throws PosicionInvalidaException {
        Celda celda = obtenerCelda(posicion);
        return celda.obtenerCeldasAdyacentesEnRango(rango);

    }

    public ArrayList<Ubicable> obtenerUnidadesEnRango(Posicion posicion, int rango) throws PosicionInvalidaException {
        ArrayList <Celda> celdasAdyacentes= obtenerCeldasAdyacentesEnRango(posicion, rango);
        ArrayList <Ubicable> unidades = new ArrayList<>();
        for (int i= 0; i< celdasAdyacentes.size(); i++){
            unidades.add(celdasAdyacentes.get(i).getElemento());
        }
        return unidades;
    }

    public Celda[][] obtenerCeldas() {
        return mapa.clone();

    }
}
