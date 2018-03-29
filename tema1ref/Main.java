public class Main {
    public static void main(String[] args) {
        new Producator(lock, lista, size).start();
        new Consumator(lock, lista, size).start();
        }
    }


