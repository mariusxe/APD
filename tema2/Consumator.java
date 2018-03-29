public class Consumator {

    Queue <Integer> lista = new Queue <Integer> ();
	int size = 10;

    public Consumator(Queue <Integer> lista, int size) {
        this.lista = lista;
		this.size = size;
    }

	public void run() {
		while (lista.size > 0) {
			try {
			consumator.acquire();
			} 
			catch (InterruptedException e) {
			e.printStackTrace();
			}
			producator.release();
            }
        }
}

