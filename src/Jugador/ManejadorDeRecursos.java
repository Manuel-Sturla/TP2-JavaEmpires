/*package Jugador;

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
}*/
package Jugador;

import Exceptions.OroInsuficienteException;
import Exceptions.UnidadesMaximasException;

public class ManejadorDeRecursos {
/*    int poblacion;
    int aldeanos_desocupados;
    int aldeanos_ocupados;
    int oro_actual;

    public ManejadorDeRecursos(){
        poblacion = 3;
        aldeanos_ocupados = 0;
        aldeanos_desocupados = 3;
        oro_actual = 100;
    }

    public int CantidadDeOro() {
        return this.oro_actual;
    }

    public int NumeroDeUnidades() {
        return this.poblacion;
    }

    public int NumeroDeAldeanosTrabajando() {
        return this.aldeanos_ocupados;
    }

    public int NumeroDeAldeanosNoTrabajando() {
        return this.aldeanos_desocupados;
    }
    public void AgregarUnidades(int cantidad) {poblacion += cantidad; }

    public void AgregarAldeanosTrabajando(int cantidad) {
        aldeanos_ocupados += cantidad;
        aldeanos_desocupados -= cantidad;
    }

    public void AgregarAldeanosDesocupados(int cantidad) {
        aldeanos_desocupados += cantidad;
        aldeanos_ocupados -= cantidad;
    }

    public void AgregarOro(int cantidad) {oro_actual = cantidad; }

    public void Cobrar() {
        oro_actual += (aldeanos_desocupados * 20);
    }

    public boolean CrearAldeano() throws OroInsuficienteException, UnidadesMaximasException {
        if (this.oro_actual < 25){
            throw new OroInsuficienteException();
        }
        if (this.poblacion == 50) {
            throw new UnidadesMaximasException();
        }
        oro_actual -= 25;
        poblacion++;
        aldeanos_desocupados++;
        return true;
    }

    public boolean CrearEspadachin() throws OroInsuficienteException, UnidadesMaximasException {
        if (this.oro_actual < 50){
            throw new OroInsuficienteException();
        }
        if (this.poblacion == 50) {
            throw new UnidadesMaximasException();
        }
        oro_actual -= 50;
        poblacion++;
        return true;
    }

    public boolean CrearArquero() {
        return this.poblacion < 50 && this.oro_actual >= 75;
    }

    public boolean CrearArmaDeAsedio() {
        return this.poblacion < 50 && this.oro_actual >= 200;
    }

    public boolean CrearCuartel() throws OroInsuficienteException {

        if (this.oro_actual < 50){
            throw new OroInsuficienteException();
        }
        oro_actual -= 50;
        aldeanos_desocupados--;
        aldeanos_ocupados++;
        return true;
    }

    public boolean CrearPlazaCentral() throws OroInsuficienteException {
        if(this.oro_actual < 100) {
            throw new OroInsuficienteException();
        }
        oro_actual -= 100;
        aldeanos_desocupados --;
        aldeanos_ocupados ++;
        return true;
    }

    /*public void nuevoAldeano() {
        poblacion++;
        aldeanos_desocupados++;
    }*/
}
