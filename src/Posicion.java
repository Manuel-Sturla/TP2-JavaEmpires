public class Posicion {
    int coordenadaHorizontal;
    int coordenadaVertical;
    Mapa mapa;

    public void moverHaciaDerecha(Unidad unidad){
        if (mapa.esPosicionValida( coordenadaHorizontal+1, coordenadaVertical)) {
            mapa.actualizarPosicion(unidad)
            coordenadaHorizontal = coordenadaHorizontal + 1;
        }
    }
}
