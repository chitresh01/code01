package threads;

public class WaitNotify01 {

	public static void main(String[] args) throws InterruptedException {
		Processor2 processor = new Processor2();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				processor.produce();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				processor.consume();
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}

class Processor2 {
	
	//Object lock1 = new Object();
	public void produce(){
		synchronized (Processor2.class) {
			System.out.println("Produce started...");
			try {
				Processor2.class.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Produce resumed..");
		}
		
	}
	
	public synchronized static void consume(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			synchronized (Processor2.class) {
				System.out.println("consume started..");
				
				Processor2.class.notify();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("consume done..");
//			}
	}
}
