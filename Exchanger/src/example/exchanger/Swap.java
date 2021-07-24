package example.exchanger;



public class Swap {


	public boolean SwapElement(boolean isProducer, Object lock,Status st) throws InterruptedException {
		
		Boolean status = st.getWaitingStatus();
		
		if(status==true) {
			String threadName =
		            Thread.currentThread().getName();
		System.out.println("Thread "+threadName+" entered" );	
		System.out.println("Waiting is "+st.getWaitingStatus());
		synchronized(lock) {
			lock.notifyAll();
		}
		System.out.println("Exchange is completed");
		if(isProducer) {
			isProducer = false;
		}else {
			isProducer = true;
		}
		return isProducer;
	}else {
		
		System.out.println("No one is waiting");
		String threadName =
	            Thread.currentThread().getName();	
		
		synchronized(lock) {
			st.setWaitingStatus(true);
			System.out.println("Thread "+threadName+" going for wait..");
			lock.wait();
			st.setWaitingStatus(false);
		}
		if(isProducer) {
			isProducer = false;
		}else {
			isProducer = true;
		}
		return isProducer;
		}
		
	}
}
