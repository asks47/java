package example.exchanger;

public class P2 extends Thread {

	boolean isProducer;
	Swap ex;
	Object lock;
	Status st;
	P2(boolean isProducer,Swap ex,Object lock,Status st){
		this.isProducer = isProducer;
		this.ex = ex;
		this.lock = lock;
		this.st = st;
	}
	
	public void run(){
		
		
		while(true){
			
			while(true){
				try {
					//this.sleep(1);
					System.out.println("isProducer "+isProducer);
					isProducer = ex.SwapElement(isProducer,lock,st);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
			
		}
}
	}
}
	
			
