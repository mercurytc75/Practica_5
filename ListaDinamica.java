
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
    @Override
    public void addLast(E elemento){
        Nodo<E> nuevo = new Nodo<>(elemento);
        if(isEmpty()){
            cabeza = cola = nuevo;
        }else{
            cola.siguiente = nuevo,
            cola = nuevo;
        }
        tamanio++;
    }
    @Override
    public void addEnesima(int indice, E elemento){
        if(indice < 0 || indice > tamanio){
            throw new IndexOutOfBoundsException("indice fuera de rango");
        }
        if(indice == 0){
            addFirst(elemento);
        }else if(indice == tamanio){
            addLast(elemento);
        }else{
            Nodo<E> actual = cabeza;
            for(int i = 0; i < indice - 1; i++){
                actual = actual.siguiente;
            }
            Nodo<E> nuevo = new Nodo<>(elemento);
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            tamanio++;

        }
    }
    @Override
    public E removeFirst(){
        
    }
}