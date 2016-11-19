import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Assignment 7 Written by Charlie Quinn Student ID: 951334907
public class Main {
	private static final int COUNT = 2000000;
	private static final int QUEUESIZE = 100000;
	
	
	
	public static void main(String[] args )
	{
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(QUEUESIZE);
		
		Producer producer = new Producer(q,"producer");
		Consumer consumer = new Consumer(q,producer,"consumer 1");
		Consumer consumertwo = new Consumer(q,producer, "consumer 2");
		
		ExecutorService x = Executors.newCachedThreadPool();
		x.execute(producer);
		x.execute(consumer);
		x.execute(consumertwo);
		x.shutdown();
		
		System.out.println(Thread.currentThread().getName() + " done!");
	}
	
	
	
	private static class Producer implements Runnable {
		private final ArrayBlockingQueue <String> _queue;// = new ArrayBlockingQueue<Integer>(100000);
		private static int c = 0;
		private boolean _running = true;
		private String _name;
		
		public Producer(ArrayBlockingQueue<String> queue, String threadName)
		{
			_queue = queue;
			_name = threadName;
		}
		
		@Override
		public void run() {
			Thread.currentThread().setName(_name);
			for (int i = 0; i < COUNT; i++){
				synchronized (_queue) {
				try {
					final String u = UUID.randomUUID().toString();
					_queue.put(u);
					c++;
					if((c%1000)==0)
					{
						System.out.println("Produced: " + c);
					}
					
				}
				catch(InterruptedException ex)
				{
					System.out.println(ex);
				}
				}
			}
			System.out.println(Thread.currentThread().getName() + " done!");
			_running = false;
		}
		
		public boolean isRunning()
		{
			return _running;
		}
		
	}
	
	private static class Consumer implements Runnable {
		private final ArrayBlockingQueue <String> _queue;
		Producer _p;
		private int c = 0;
		private String max = "";
		private String _name;
		public Consumer(ArrayBlockingQueue<String> queue, Producer p, String threadName)
		{
			_queue = queue;
			_p = p;
			_name = threadName;
		}
		@Override
		public void run() {
			Thread.currentThread().setName(_name);
			while(_queue.size() > 0 || _p.isRunning()){
				try {
					
					String n = _queue.take();
					c++;
					if(n.compareTo(max)>0)
					{
						max = n;
						//System.out.println("new max");
					}
					if ((c%1000)==0)
					{
						System.out.println(Thread.currentThread().getName() + " consumed: " + c);
					}
					
					//System.out.println("consumed: " + n);
					
					Thread.sleep(10);
					
				} catch (InterruptedException ex) {
					System.out.println(ex);
				}
			}
			
			System.out.println(Thread.currentThread().getName() + " done consuming! " + c + " consumed.");
			System.out.println(Thread.currentThread().getName() + " max String: " + max);
			}
	}

}
