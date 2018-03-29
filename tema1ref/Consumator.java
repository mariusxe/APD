public class Consumator {

    private final ReentrantLock lock = new ReentrantLock();
    Queue <Integer> lista = new Queue <Integer> ();
	int size = 10;

    public Consumator(ReentrantLock lock, Queue <Integer> lista, int size) {
        this.lock = lock;
        this.lista = lista;
		this.size = size;
    }

    public void run() {
        lock.lock();
        while (lista.size() > 0) {
            lista.remove();
        }
        lock.unlock();
    }

}