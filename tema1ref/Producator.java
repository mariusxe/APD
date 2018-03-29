class Producator {

    private final ReentrantLock lock = new ReentrantLock();
    Queue <Integer> lista = new Queue <Integer> ();
    int size = 10;
	Random rand = new Random();

    public Producator(ReentrantLock lock, Queue <Integer> lista, int size) {
        this.lock = lock;
        this.lista = lista;
        this.size = size;
    }

    public void run() {
        lock.lock();
        while (lista.size() != size) {
			element = rand.nextInt(10);
            lista.add(element);
		}
        lock.unlock();
        }
    }





