package ds.queue.blokingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	BlockingQueue<Message> bq;
	public Producer(BlockingQueue<Message> bq) {
		// TODO Auto-generated constructor stub
		this.bq=bq;
	}

	@Override
	public void run() {
		
		for(int i=0;i<50;i++){
			try {
				Message msg;
				bq.put((msg=new Message(new Integer(i).toString())));
				System.out.println("Produced :"+msg.name);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bq.put(new Message("exit"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
