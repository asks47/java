package example.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

public class Operation {
	ReentrantLock bufferLock = new ReentrantLock(true);
	HashMap<String, Integer> bufferSet = new HashMap<String, Integer>();
	synchronized public void begin(int transID,HashSet<String> personSet,String arg1,String arg2){
	
	if(bufferLock.tryLock()==true){
		System.out.println("Got lock on bufferSet >>");
		bufferSet.put(arg1, transID);
		bufferSet.put(arg2, transID);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferLock.unlock();
		System.out.println("After addition bufferSet >>>" +bufferSet);
		update(bufferLock,arg1,arg2,personSet,bufferSet);
					}
	
			}
	synchronized public boolean exists(String arg1, String arg2,HashMap<String, Integer> bufferSet ){
		if (bufferSet.containsKey(arg1) || bufferSet.containsKey(arg1)){
			return true;
		}
		else {
			return false;
		}
			
	}

synchronized public void add(ReentrantLock bufferLock,String arg1,String arg2,HashSet<String> personSet,HashMap<String, Integer> bufferSet){
	if(bufferLock.tryLock()==true){
	personSet.add(arg1);
	personSet.add(arg2);
	bufferSet.remove(arg1);
	bufferSet.remove(arg2);
	bufferLock.unlock();
	}
	synchronized (bufferSet){
		bufferSet.notifyAll();
		System.out.println("Notifying all after bufferSet element removed >> ");
	}
	
	}
synchronized public void update(ReentrantLock bufferLock,String arg1,String arg2,HashSet<String> personSet,HashMap<String, Integer> bufferSet){
	if(bufferLock.tryLock()==true){
	personSet.remove(arg2);
	personSet.add(arg1);
	System.out.println("After update personSet >>>" +personSet);
	bufferSet.remove(arg1);
	bufferSet.remove(arg2);
	bufferLock.unlock();
	synchronized (bufferSet){
		bufferSet.notifyAll();
		System.out.println("Notifying all after bufferSet element removed >> ");
	}
	}
	System.out.println("After removal bufferSet >>>" +bufferSet);
	}

public static void rollback(){
	
}

}
