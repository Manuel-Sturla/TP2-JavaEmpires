package Controladores.Comandos;

import Modelo.Ubicables.Ubicable;

public interface ComandoConObjetivo extends Comando {

    void agregarObjetivo(Ubicable objetivo);
}
