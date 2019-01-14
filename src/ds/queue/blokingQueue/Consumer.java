package ds.queue.blokingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Message> bq;
	
	public Consumer(BlockingQueue<Message> bq){
		this.bq = bq;
	}
	@Override
	public void run() {

      try {
    	  Message msg;
		while(!(msg=bq.take()).name.equals("exit")){
			  System.out.println("Consumed: "+msg.name);
			  Thread.sleep(1000);
		  }
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
