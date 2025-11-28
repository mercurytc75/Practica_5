package practica5;

/**
 * Implementación dinámica (enlazada) de la interfaz Lista.
 */
public class ListaDinamica<E> implements Lista<E> {

    protected Nodo<E> cabeza;
    protected Nodo<E> cola;
    protected int tamanio;

    public ListaDinamica() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    @Override
    public void addFirst(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (isEmpty()) {
            cabeza = cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
        tamanio++;
    }

    @Override
    public void addLast(E elemento) {
        Nodo<E> nuevo = new Nodo<>(elemento);
        if (isEmpty()) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamanio++;
    }

    @Override
    public void addEnesima(int indice, E elemento) {
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        if (indice == 0) {
            addFirst(elemento);
        } else if (indice == tamanio) {
            addLast(elemento);
        } else {
            Nodo<E> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.siguiente;
            }
            Nodo<E> nuevo = new Nodo<>(elemento);
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            tamanio++;

        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vacia");
        }
        E dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        if (cabeza == null) {
            cola = null;
        }
        tamanio--;
        return dato;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vacia");
        }
        if (tamanio == 1) {
            E dato = cabeza.dato;
            cabeza = cola = null;
            tamanio = 0;
            return dato;
        }
        Nodo<E> actual = cabeza;
        while (actual.siguiente != cola) {
            actual = actual.siguiente;
        }
        E dato = cola.dato;
        cola = actual;
        cola.siguiente = null;
        tamanio--;
        return dato;
    }

    @Override
    public E removeEnesima(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        if (indice == 0) {
            return removeFirst();
        }
        Nodo<E> actual = cabeza;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.siguiente;
        }
        Nodo<E> eliminado = actual.siguiente;
        actual.siguiente = eliminado.siguiente;
        if (eliminado == cola) {
            cola = actual;
        }
        tamanio--;
        return eliminado.dato;
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vacia");
        }
        return cola.dato;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vacia");
        }
        return cabeza.dato;
    }

    @Override
    public E getEnesima(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Nodo<E> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    @Override
    public int size() {
        return tamanio;
    }

    @Override
    public boolean isEmpty() {
        return tamanio == 0;
    }

    @Override
    public void clear() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    @Override
    public void addOrd(E elemento) {
        // Metodo vacio como indica la practica (no implementado aqui)
        throw new UnsupportedOperationException("addOrd no implementado");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<E> actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
