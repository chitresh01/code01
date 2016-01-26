package threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock01 {
	
	private Lock lock = new ReentrantLock();
	private Condition cond1 = lock.newCondition();
	private Condition cond2 = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		ReEntrantLock01 rel = new ReEntrantLock01();
		
		
		
		

		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
//				for (int i = 0; i < 10000; i++) {
//					incrementCount();
//				}
				try {
					rel.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
//				for (int i = 0; i < 10000; i++) {
//					incrementCount2();
//				}
				try {
					rel.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("SynchronizedTest01.doWork()-- count = "+count);
		
	

	}
	
	private static int count;
	
	private void firstThread() throws InterruptedException{
		lock.lock();
		cond1.await();
		try {
			increment();
		} finally {
			System.out.println(" first unlocked");
			lock.unlock();
		}
		
	}

	private void increment() {
		for (int i = 0; i < 3000; i++) {
			count++;
		}
	}
	
	private void secondThread() throws InterruptedException{
		System.out.println("qqqqqqq");
		Thread.sleep(1000);
		
		lock.lock();
		System.out.println(" second locked,,, press return key");
		new Scanner(System.in).nextLine();
		System.out.println("got return key");
		cond2.signal();
		try {
			increment();
//			cond1.signal();
		} finally {
			System.out.println(" second unlocked");
			lock.unlock();
		}
		
		
	}

}
