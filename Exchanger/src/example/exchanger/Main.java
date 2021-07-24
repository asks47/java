package example.exchanger;



public class Main {

	public static void main(String[] args) throws InterruptedException {
		Swap sw = new Swap();
		final Object lock = new Object();
		Status st = new Status();
		Thread t1 = new Thread(new P1(false,sw,lock,st));
		Thread t2 = new Thread(new P2(false,sw,lock,st));
		t1.setName("T1");
		t2.setName("T2");
		
		t1.start();
		t2.start();		
		
	}

}
