
public class ListaDinamica<E> implements Lista<E> {

    protected Nodo<E> cabeza;
    protected Nodo<E> cola;
    protected int tamanio;

    public ListaDinamica(){
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    @Override
    public void addFirst(E elemento){
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if(isEmpty()){
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
        tamanio++;
    }
}