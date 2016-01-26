package threads;

public class RunnableClass {

	public static void main(String[] args) {
		Thread t1 = new Thread(new SampleRunnable());		
		Thread t2 = new Thread(new SampleRunnable());
		
		System.out.println("RunnableClass.main()111");
		t1.start();
		t2.start();
		System.out.println("RunnableClass.main()222");
		
//		SampleRunnable s1 = new SampleRunnable();
//		System.out.println("RunnableClass.main()333");
//		s1.run();
//		System.out.println("RunnableClass.main()444");

	}

}

class SampleRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("i = "+i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
