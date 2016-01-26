package threads;

public class SynchronizedTest01 {
	
	private static int count;

	public static void main(String[] args) {
		SynchronizedTest01 st = new SynchronizedTest01();
		
		st.doWork();

	}

	private void doWork() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCount();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCount2();
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
		
		System.out.println("SynchronizedTest01.doWork()-- count = "+count);
		
	}

	protected synchronized void incrementCount() {
		count++;
		
	}
	
	protected synchronized void incrementCount2() {
		count++;
		
	}

}
