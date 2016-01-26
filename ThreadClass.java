package threads;

public class ThreadClass {

	public static void main(String[] args) {
		SampleThread sample1 = new SampleThread();
		
		SampleThread sample2 = new SampleThread();
		System.out.println("ThreadClass.main()111");
		sample1.start();
		sample2.start();
		
		System.out.println("ThreadClass.main()222");
		

	}

}

class SampleThread extends Thread{

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
