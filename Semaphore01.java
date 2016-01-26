package threads;

import java.util.concurrent.Semaphore;

public class Semaphore01 {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(10);
		
		System.out.println("Semaphore01.main()--availablePermits------ "+semaphore.availablePermits());
		semaphore.release();
		System.out.println("Semaphore01.main()--availablePermits------ "+semaphore.availablePermits());
		semaphore.acquire();;
		System.out.println("Semaphore01.main()--availablePermits------ "+semaphore.availablePermits());
		semaphore.release();
		System.out.println("Semaphore01.main()--availablePermits------ "+semaphore.availablePermits());
		semaphore.drainPermits();
		System.out.println("Semaphore01.main()--availablePermits------ "+semaphore.availablePermits());

	}

}
