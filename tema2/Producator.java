class Producator {

    Queue <Integer> lista = new Queue <Integer> ();
    int size = 10;
	Random rand = new Random();

    public Producator(Queue <Integer> lista, int size) {
        this.lista = lista;
        this.size = size;
    }

	public void run() {
		while (lista.size != 0) {
			try {
			producator.acquire();
			} 
			catch (InterruptedException e) {
			e.printStackTrace();
			}
			
			element = rand.nextInt(10);
			lista.add(element);
			consumator.release();
			}
    }
}



