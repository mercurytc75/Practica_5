public interface Lista<E>{
    void addFirst(E elemento);
    void addLast(E elemento);
    void addEnesima(int indice, E elemento);

    E removeFirst();
    E removeLast();
    E removeEnesima(int indice);

    E getFirst();
    E getLast();
    E getEnecima();

    int size();

    boolean isEmpty();
    void clear();

    void addOrd(E elemento);
}