package example.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

	
	public static void main(String[] args){
		
		HashSet<String> personSet=new HashSet();
		Person person = new Person(personSet);
		System.out.println("personSet >> "+personSet);
		ReentrantLock bufferLock = new ReentrantLock(true);
		HashMap<String, Integer> bufferSet = new HashMap<String, Integer>();
		Trans1 t1 = new Trans1(bufferLock,personSet,bufferSet,"Ashwini","Sanjay");
		Trans2 t2 = new Trans2(bufferLock,personSet,bufferSet,"Jitesh","Amarnath");
		Trans3 t3 = new Trans3(bufferLock,personSet,bufferSet,"Sanjay","Jitesh");
		t1.start();
		t2.start();
		t3.start();
	
	}
	
}
