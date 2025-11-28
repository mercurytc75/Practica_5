package practica5;

public class PruebaListas {
    public static void main(String[] args) {
        System.out.println("=== Prueba ListaEstatica ===");
        ListaEstatica<Integer> le = new ListaEstatica<>(5);
        le.addFirst(20);
        le.addLast(30);
        le.addEnesima(1, 25);
        System.out.println("Lista estatica: " + le);
        le.removeEnesima(1);
        System.out.println("Despues de eliminar enesimo: " + le);
        System.out.println("Primero: " + le.getFirst());
        System.out.println("Ultimo: " + le.getLast());
        System.out.println("Tamanio: " + le.size());

        System.out.println("\n=== Prueba ListaDinamica ===");
        ListaDinamica<String> ld = new ListaDinamica<>();
        ld.addFirst("C");
        ld.addLast("D");
        ld.addFirst("B");
        ld.addEnesima(0, "A");
        System.out.println("Lista dinamica: " + ld);
        ld.removeFirst();
        ld.removeLast();
        System.out.println("Despues de eliminar primero y ultimo: " + ld);
        System.out.println("Enesimo (0): " + ld.getEnesima(0));
        System.out.println("Tamanio: " + ld.size());

        System.out.println("\n=== Prueba ListaOrdenada ===");
        ListaOrdenada<Integer> lo = new ListaOrdenada<>();
        lo.addOrd(50);
        lo.addOrd(20);
        lo.addOrd(40);
        lo.addOrd(10);
        lo.addOrd(30);
        System.out.println("Lista ordenada (addOrd): " + lo);
        System.out.println("Primero: " + lo.getFirst());
        System.out.println("Ultimo: " + lo.getLast());
    }
}
