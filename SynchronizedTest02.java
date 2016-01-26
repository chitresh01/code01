package threads;

public class SynchronizedTest02 {
	
	private static int count;

	public static void main(String[] args) {
		SynchronizedTest02 st = new SynchronizedTest02();
		
		st.doWork();

	}

	private void doWork() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
//				for (int i = 0; i < 10000; i++) {
//					incrementCount();
//				}
				testmethod();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
//				for (int i = 0; i < 10000; i++) {
//					incrementCount2();
//				}
				teststaticmethod();
				
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

	protected synchronized void incrementCount() {
		count++;
		
	}
	
	protected synchronized void incrementCount2() {
		count++;
		
	}
	
	protected synchronized void testmethod() {
		System.out.println("testmethod called");
		try {
			Thread.sleep(2000);
			System.out.println("count == "+count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("testmethod finished");
	}
	
	protected static synchronized void teststaticmethod() {
		System.out.println("teststaticmethod called");
		try {
			for (int i = 0; i < 1000; i++) {
				count++;
			}
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("teststaticmethod finished");
		
	}


}
