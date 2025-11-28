package practica5;

public class ListaOrdenada<E extends Comparable<E>> extends ListaDinamica<E> {
    @Override
    public void addOrd(E elemento) {
        Nodo<E> nuevo = new Nodo<>(elemento);

        if (isEmpty()) {
            cabeza = cola = nuevo;
            tamanio = 1;
            return;
        }

        if (elemento.compareTo(cabeza.dato) <= 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            tamanio++;
            return;
        }

        Nodo<E> actual = cabeza;
        while (actual.siguiente != null && elemento.compareTo(actual.siguiente.dato) > 0) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        if (nuevo.siguiente == null) {
            cola = nuevo;
        }
        tamanio++;
    }

}
