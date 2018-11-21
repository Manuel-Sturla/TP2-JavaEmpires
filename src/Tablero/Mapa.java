package Tablero;

import Exceptions.PosicionFueraDeRangoException;
import Exceptions.PosicionNoDisponibleException;
import Ubicables.Ubicable;

import java.util.ArrayList;
import java.util.Collection;

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

    public boolean celdaEstaOcupada(Posicion posicion) throws PosicionFueraDeRangoException {
        return (this.obtenerCelda(posicion).estaOcupada());
    }

    public void ocuparCelda(Ubicable elementoMapa, Posicion posicion) throws PosicionFueraDeRangoException {
      /*  if(this.celdaEstaOcupada(posicion)){
            throw new PosicionNoDisponibleException();
        }TE HACE QUE TODO TIENE QUE TENER DECLARADO UNA EXCEPCION NUEVA*/
        this.obtenerCelda(posicion).ocuparCelda(elementoMapa);
    }

    public void desocuparCelda(Posicion posicion) throws PosicionFueraDeRangoException {
        this.obtenerCelda(posicion).desocuparCelda();
    }

    private Celda obtenerCelda(Posicion posicion) throws PosicionFueraDeRangoException {
        int coordenadaHorizontal = posicion.getCoordenadaHorizontal();
        int coordenadaVertical = posicion.getCoordenadaVertical();
        try{
            return mapa[coordenadaHorizontal][coordenadaVertical];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new PosicionFueraDeRangoException();
        }
    }

    public void moverElemento(Posicion posicion, Posicion posicion_llegada) throws PosicionNoDisponibleException, PosicionFueraDeRangoException {
        Ubicable elemento = this.obtenerCelda(posicion).getElemento();
        if (this.celdaEstaOcupada(posicion_llegada)){
            throw new PosicionNoDisponibleException();
        }
        this.obtenerCelda(posicion_llegada).ocuparCelda(elemento);
        this.obtenerCelda(posicion).desocuparCelda();
    }

    public boolean estaEnMapa(Posicion posicion) {
        try{
            this.obtenerCelda(posicion);
            return true;
        }catch (PosicionFueraDeRangoException e){
            return false;
        }
    }


    public boolean esAdyacente(Posicion posicion, Posicion posicion2) throws PosicionFueraDeRangoException {
        return this.obtenerCelda(posicion).esAdyacente(obtenerCelda(posicion2));
    }
}

