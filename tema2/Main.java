public class Main {
    public static void main(String[] args) {
		Semaphore consumator = new Semaphore(0);
		Semaphore producator = new Semaphore(1);
        new Producator(lista, size).start();
        new Consumator(lista, size).start();
        }
    }


