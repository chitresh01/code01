package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatch01 {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int j = 0; j < 3; j++) {
			executor.submit(new Processor01(j, latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done..");
		
		

	}

}

class Processor01 implements Runnable{
	
	private static int count;
	
	private CountDownLatch latch;
	private int id;
	
	public Processor01(int id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Started - "+id);
		
//		try {
//			Thread.sleep(600);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		for (int i = 0; i < 10000; i++) {
			incrementCount();
		}
		
		System.out.println("Before latch - "+id+" - count= "+count);
		latch.countDown();
		System.out.println("after latch - "+id+" - count= "+count);
		
	}

	private void incrementCount() {
		count++;
		
	}
	
}
