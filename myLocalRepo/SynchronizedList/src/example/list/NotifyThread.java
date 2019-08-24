package example.list;

public class NotifyThread extends Thread {

	public void run(){
		System.out.println("Notify invoked >>>");
	this.notifyAll();
	}
}
