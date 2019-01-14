package ds.queue.blokingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	
	public static void main(String[] args) {
		Test t = new Test();
		BlockingQueue<Message> bq = new ArrayBlockingQueue<>(10);
		Producer p = new Producer(bq);
		Consumer c = new Consumer(bq);
		new Thread(c).start();
		new Thread(p).start();
		System.out.println("Threads stated.....");
		
	}
}
