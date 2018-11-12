public class Mapa {

    int TamMapa;
    ElementoDeMapa[][] mapaAOE;

    public Mapa() {
        TamMapa = 10;
        mapaAOE = new ElementoDeMapa[TamMapa][TamMapa];
    }

    public boolean agregarElementoDeMapa(ElementoDeMapa elemento, int coordenadaHorizontal, int coordenadaVertical) {
        if (esCoordenadaValida(coordenadaHorizontal) && esCoordenadaValida(coordenadaVertical)
                && mapaAOE[coordenadaHorizontal][coordenadaVertical] == null) {
            mapaAOE[coordenadaHorizontal][coordenadaVertical] = elemento;
            elemento.actualizarPosicion(coordenadaHorizontal, coordenadaVertical);
            return true;
        }
        return false;
    }

    private boolean esCoordenadaValida(int coordenada) {
        if (coordenada < TamMapa && coordenada >= 0) {
            return true;
        }
        return false;
    }

    public boolean estaOcupadoElCasillero(int coordenadaHorizontal, int coordenadaVertical) {
        return (mapaAOE[coordenadaHorizontal][coordenadaVertical] != null);
    }

    public void borrarElementoDeMapa(int coordenadaHorizontal, int coordenadaVertical) {
        mapaAOE[coordenadaHorizontal][coordenadaVertical] = null;
    }
}