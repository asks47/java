package example.newList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operation {
	final Lock lock = new ReentrantLock();
	final Condition exist = lock.newCondition();
	final Condition notExist = lock.newCondition();
	final Condition update = lock.newCondition();

	Person per = new Person();
	public void begin(HashSet<String> personSet,HashMap<String, Integer> bufferSet,String arg1,String arg2) throws InterruptedException {
		lock.lock();
		System.out.println("bufferSet >>>" +bufferSet);
		try {
				if ((bufferSet.containsKey(arg1)|| bufferSet.containsKey(arg2))) {
					System.out.println("Waiting for signal>>>>");
					exist.await();
				}
				else
				{
							} 
			update(arg1,arg2,per.getID(),bufferSet);
		}
		finally {
			lock.unlock();
			}
		
		

		}

	synchronized public void update(String arg1, String arg2, Integer ID,HashMap<String, Integer> bufferSet) throws InterruptedException {

		bufferSet.put(arg1, ID);
		bufferSet.put(arg2, ID);
		
		}
	
	synchronized public void commit(String arg1, String arg2,HashSet<String> personSet,HashMap<String, Integer> bufferSet) throws InterruptedException {
		lock.lock();
		try {
		personSet.remove(arg2);
		personSet.add(arg1);
		bufferSet.remove(arg1);
		bufferSet.remove(arg2);
		System.out.println("Sending signal>>>>");
		exist.signal();

	}finally {
		lock.unlock();
		}
	}
	
}
