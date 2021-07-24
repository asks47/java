package example.exchanger;



public class P1 extends Thread {
	boolean isProducer;	
	//Exchange ex;
	Swap ex;
	Status st;
	Object lock;
	P1(boolean isProducer,Swap ex,Object lock,Status st){		
		this.isProducer = isProducer;
		this.ex = ex;
		this.st=st;
		this.lock = lock;
	}

	public void run(){
		
		while(true){
			try {
				this.sleep(10);
				isProducer = ex.SwapElement(isProducer,lock,st);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

		}
}
}
