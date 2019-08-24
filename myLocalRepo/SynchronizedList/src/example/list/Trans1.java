package example.list;
import example.list.Operation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;


public class Trans1 extends Thread{
	
	String name1;
	String name2;
	HashMap<String, Integer> bufferSet = new HashMap<String, Integer>();
	HashSet<String> personSet=new HashSet();
	ReentrantLock bufferLock = new ReentrantLock();
	public Trans1(ReentrantLock bufferLock,HashSet<String> personSet,HashMap<String, Integer> bufferSet,String name1,String name2){
		this.name1 = name1;
		this.name2 = name2;
		this.personSet = personSet;
		this.bufferSet = bufferSet;
		}
	
	Person person = new Person();
	Operation opr = new Operation();
	public void run(){
		System.out.println("Bufferset >>>" +bufferSet);
		while(opr.exists(name1,name2,bufferSet)==true){
				synchronized (bufferSet){
				try {
					System.out.println("Trans1 Waiting <<element exists in bufferset>> ");
					bufferSet.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Trans1 Waiting finish  <<check element again>> ");
				
			}
		}
					
			opr.begin(bufferLock,person.getID(),personSet,bufferSet, name1, name2);
		
			}
	
	

}
