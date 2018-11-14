public class Posicion {
    int coordenadaHorizontal;
    int coordenadaVertical;
    Mapa mapa;

    public Posicion(int valorHorizontal, int valorVertical){
        mapa
        if (mapa.esPosicionValida( valorHorizontal, valorVertical)) {
            coordenadaVertical = valorVertical;
            coordenadaHorizontal = valorHorizontal;
        }
    }
    public int obtenerCoordenadaVertical(){
        return coordenadaVertical;
    }
    public int obtenerCoordenadaHorizontal(){
        return coordenadaHorizontal;
    }
    public void actualizar(int valorHorizontal, int valorVertical){
        if (mapa.esPosicionValida(valorHorizontal, valorVertical)) {
            coordenadaVertical = valorVertical;
            coordenadaHorizontal = valorHorizontal;
        }
    }
    public void moverHaciaDerecha(Unidad unidad){
        if (mapa.esPosicionValida( coordenadaHorizontal+1, coordenadaVertical)) {
            mapa.actualizarPosicion(unidad)
            coordenadaHorizontal = coordenadaHorizontal + 1;
        }
    }
}
