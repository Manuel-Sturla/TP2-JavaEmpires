package Jugador;

public class ManejadorDeRecursos {
    int poblacion;
    int oro_actual;

    public ManejadorDeRecursos(int unidades,int oro){
        poblacion = unidades;
        oro_actual = oro;
    }

    public int CantidadDeOro() {
        return this.oro_actual;
    }

    public int NumeroDeUnidades() {
        return this.poblacion;
    }

    public boolean CrearAldeano() {
        return this.poblacion < 50 && this.oro_actual >= 25;
    }

    public boolean CrearEspadachin() {
        return this.poblacion < 50 && this.oro_actual >= 50;
    }

    public boolean CrearArquero() {
        return this.poblacion < 50 && this.oro_actual >= 75;
    }

    public boolean CrearArmaDeAsedio() {
        return this.poblacion < 50 && this.oro_actual >= 200;
    }

    public boolean CrearCuartel() {
        return this.oro_actual >= 50;
    }

    public boolean CrearPlazaCentral() {
        return this.oro_actual >= 100;
    }
}
