package Vista;

public class Recordador {

    static Object guardado=null;

    public static void guardar(Object objeto){
        guardado = objeto;

    }
    public boolean hayGuardado(){
        return guardado!=null;
    }

    public static Object obtener(){
        return guardado;
    }
}
