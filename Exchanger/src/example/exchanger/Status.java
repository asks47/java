package example.exchanger;

public class Status {

	static boolean waiting =false;
	
	public synchronized boolean getWaitingStatus() {
		return Status.waiting;
	}
	
	public synchronized void setWaitingStatus(boolean waiting) {
		Status.waiting=waiting;
	}
}
