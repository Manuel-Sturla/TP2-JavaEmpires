public class IDEAS {
    /*
    QUE EL MapA TENGA
    las unidades tienen un rango de accion (el aldeano es de 3x3 alrededor de el) que es una subclase de posicion
    que la maneja posicion. Solo puede construir y reparar edificios que se encuentren en su rango de accion
    luego, para crear un aldeano por ejemplo, el edificio crea la clase y le pasa al mapa.agregarElementoDeMapa(unidad,
    x, y) y este se fija si la posicion esta ocupada, y si no lo esta actualiza la posicion de esa unidad (la cual al
    actualizarse delega la responsabilidad en la clase posicion, que setea su posicion y a su vez el rango de accion a su
    alrededor)
     */
}
