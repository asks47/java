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
	/*
	 * static HashMap<String, Integer> bufferSet = new HashMap<String, Integer>();
	 * static HashSet<String> personSet = new HashSet(); 
	 * String arg1; String arg2;
	 */

	/*
	 * public Operation(String arg1, String arg2) { this.personSet = personSet;
	 * this.arg1 = arg1; this.arg2 = arg2; this.bufferSet=bufferSet; }
	 */
	Person per = new Person();
	public void begin(HashSet<String> personSet,HashMap<String, Integer> bufferSet,String arg1,String arg2) throws InterruptedException {
		lock.lock();
		System.out.println("bufferSet >>>" +bufferSet);
		try {
				if (!(bufferSet.containsKey(arg1)|| bufferSet.containsKey(arg2))) {
					System.out.printf("Inserting in personSet "+personSet, "," +arg1,","+arg2);
					update(arg1, arg2, per.getID(),personSet,bufferSet);
					System.out.println("personSet " + personSet);
				}
				else
				{
				System.out.println("Waiting ");
				exist.await();
				System.out.println("got signal ");
				update(arg1, arg2, per.getID(),personSet,bufferSet);
			} 
			
		}
		finally {
			lock.unlock();
			}
		
		

		}
	
		
	

	
	/*
	 * synchronized public void isExist() throws InterruptedException { lock.lock();
	 * try { while(!(bufferSet.containsKey(arg1)|| bufferSet.containsKey(arg2)))
	 * System.out.println("inside the loop");
	 * 
	 * exist.signal();
	 
			
		}
		finally {
			lock.unlock();
		}
		
		
			}
			*/
	synchronized public void update(String arg1, String arg2, Integer ID,HashSet<String> personSet,HashMap<String, Integer> bufferSet) throws InterruptedException {

		bufferSet.put(arg1, ID);
		bufferSet.put(arg2, ID);
		personSet.remove(arg2);
		personSet.add(arg1);
		bufferSet.remove(arg1);
		bufferSet.remove(arg2);
		lock.lock();
		try {
		exist.signal();

	}finally {
		lock.unlock();
		}
	}
	
}
