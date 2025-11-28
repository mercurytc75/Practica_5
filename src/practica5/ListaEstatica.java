package practica5;

import java.util.Arrays;

/**
 * Implementación estática de una lista genérica con arreglo interno.
 */
public class ListaEstatica<E> implements Lista<E> {
    private E[] datos;
    private int tamanio;

    @SuppressWarnings("unchecked")
    public ListaEstatica(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("capacidad invalida");
        }
        datos = (E[]) new Object[capacidad];
        tamanio = 0;
    }

    private void asegurarCapacidad() {
        if (tamanio == datos.length) {
            datos = Arrays.copyOf(datos, Math.max(1, datos.length * 2));
        }
    }

    @Override
    public void addFirst(E elemento) {
        asegurarCapacidad();
        for (int i = tamanio; i > 0; i--) {
            datos[i] = datos[i - 1];
        }
        datos[0] = elemento;
        tamanio++;
    }

    @Override
    public void addLast(E elemento) {
        asegurarCapacidad();
        datos[tamanio] = elemento;
        tamanio++;
    }

    @Override
    public void addEnesima(int indice, E elemento) {
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        asegurarCapacidad();
        for (int i = tamanio; i > indice; i--) {
            datos[i] = datos[i - 1];
        }
        datos[indice] = elemento;
        tamanio++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vacia");
        }
        E eliminado = datos[0];
        for (int i = 0; i < tamanio - 1; i++)
            datos[i] = datos[i + 1];
        datos[tamanio - 1] = null;
        tamanio--;
        return eliminado;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("lista vacia");
        }
        E eliminado = datos[tamanio - 1];
        datos[tamanio - 1] = null;
        tamanio--;
        return eliminado;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("lista vacia");
        }
        return datos[0];
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("lista vacia");
        }
        return datos[tamanio - 1];
    }

    @Override
    public E getEnesima(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        return datos[indice];
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
        for (int i = 0; i < tamanio; i++) {
            datos[i] = null;
        }
        tamanio = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanio; i++) {
            sb.append(datos[i]);
            if (i < tamanio - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void addOrd(E elemento) {
        // Implementación vacía por ahora; depende del criterio de orden
        throw new UnsupportedOperationException("addOrd no implementado");
    }
 
    @Override
    public E removeEnesima(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        E eliminado = datos[indice];
        for (int i = indice; i < tamanio - 1; i++) {
            datos[i] = datos[i + 1];
        }
        datos[tamanio - 1] = null;
        tamanio--;
        return eliminado;
    }
}
