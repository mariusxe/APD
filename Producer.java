import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer extends Thread {

    @Override
    public void run() {
        while(true) {
            try {
                PC.lista.put("ceva");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

