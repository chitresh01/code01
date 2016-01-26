package threads;

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		Processor1 processor = new Processor1();
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

class Processor1 {
	
	Object lock1 = new Object();
	public void produce(){
		synchronized (lock1) {
			System.out.println("Produce started...");
			try {
				lock1.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Produce resumed..");
		}
		
	}
	
	public void consume(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			synchronized (lock1) {
				System.out.println("consume started..");
				
				lock1.notify();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("consume done..");
			}
	}
}
