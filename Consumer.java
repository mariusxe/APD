import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer extends Thread {

    @Override
    public  void run() {
       while (true) {
           try {
               PC.lista.get();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

