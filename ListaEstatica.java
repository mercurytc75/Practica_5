
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListaEstatica<E> implements List<E> {
    private E[] datos;
    private int tamanio;

    @SuppressWarnings("unchecked")
    public ListaEstatica(int capacidad){
        if(capacidad <= 0){
            throw  new IllegalArgumentException("capacidad invalida");
        }
        datos = (E[]) new Object[capacidad];
        tamanio = 0;
    }
    private void asegurarCapacidad(){
        if(tamanio == datos.length){
            datos = Arrays.copyOf(datos, datos.length * 2);
        }
    }
    
    @Override
    public void addFirst(E elemento){
        asegurarCapacidad();
        for (int i = tamanio; i > 0; i--) {
            datos[i] = datos[i - 1];
        }
        datos[0] = elemento;
        tamanio++;
    }
    
    @Override
    public void addLast(E elemento){
        asegurarCapacidad();
        datos[tamanio] = elemento;
        tamanio++;
    }
    public void addEnesima(int indice, E elemento){
        if(indice < 0 || indice > tamanio){
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        asegurarCapacidad();
        for(int i = tamanio; i > indice; i++)
            datos[i] = datos[i - 1];

        datos[indice] = elemento;
        tamanio++;
    }

    @Override 
    public E removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Lista vacia");
        }
        E eliminado = datos[0];
        for(int i = 0; i < tamanio - 1; i++)
            datos[i] = datos[i + 1];
        datos[tamanio - 1] = null;
        tamanio--;
        return  eliminado;
    } 
    @Override
    public E removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("lista vacia");
        }
        E eliminado = datos[tamanio - 1];
        datos[tamanio - 1] = null;
        tamanio--;
        return eliminado;
    }
    
    public E getFist(){
        if(isEmpty()){
            throw new IllegalStateException("lista vacia");
        }
        return datos[tamanio - 1];
    }
    
    public E getEnesima(int indice){
        if(indice<0 || indice>= tamanio){
            throw new IndexOutOfBoundsException("indice fuera de rango ");
        }
        return  datos[indice];
    }
    @Override
    public int size(){
        return tamanio;
    }
    @Override
    public boolean  isEmpty(){
        return tamanio == 0;
    }
    @Override
    public void clear(){
        for(int i = 0; i< tamanio; i++){
            datos[i] = null;
        }
        tamanio = 0;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i<tamanio; i++){
            sb.append(datos[i]);
            if(i < tamanio - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return  sb.toString();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
