package example.list;
import example.list.Operation;

import java.util.HashMap;
import java.util.HashSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Trans4 extends Thread{
	
	String name1;
	String name2;
	ObservableMap<String,Integer> bufferSet = FXCollections.observableMap(arg0);
	//HashMap<String, Integer> bufferSet = new HashMap<String, Integer>();
	HashSet<String> personSet=new HashSet();
	//HashMap<Integer, String> threadList = new HashMap<Integer, String>();
	public Trans4(HashSet<String> personSet,ObservableMap<String,Integer> bufferSet,String name1,String name2){
		this.name1 = name1;
		this.name2 = name2;
		this.personSet = personSet;
		this.bufferSet = bufferSet;
		}
	NotifyThread notify = new NotifyThread();
	Person person = new Person();
	Operation opr = new Operation();
	public void run(){
		System.out.println("Bufferset >>>" +bufferSet);
		if(bufferSet.containsValue(name1) || bufferSet.containsValue(name2)){
				synchronized (bufferSet){
				try {
					bufferSet.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//opr.begin(person.getID(),personSet,bufferSet, name1, name2);
			}
		}
		else{			
			opr.begin(person.getID(),personSet,bufferSet, name1, name2);
		}
			}
	
	

}
