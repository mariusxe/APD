import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lista {
    private Queue<String> lista = new LinkedList<>();
    private int dim;

    Lista(int dim){
        this.dim = dim;
    }

    public synchronized void put(String element) throws InterruptedException {
        while(lista.size() == dim) {
            System.out.println("Lista este plina!");
            wait();
        }
        lista.add(element);
        System.out.println("Am adaugat in lista.");
        notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        while(lista.isEmpty()) {
            System.out.println("Lista este goala!");
            wait();
        }
        lista.remove();
        System.out.println("Am sters din lista.");
        notifyAll();
    }

}

