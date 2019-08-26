package example.list;
import example.list.Operation;
import java.util.HashSet;


public class Trans2 extends Thread{
	
	String name1;
	String name2;
	HashSet<String> personSet=new HashSet();
	public Trans2(HashSet<String> personSet,String name1,String name2){
		this.name1 = name1;
		this.name2 = name2;
		this.personSet = personSet;
		}
	
	Person person = new Person();
	Operation opr = new Operation();
	public void run(){
		System.out.println("Bufferset >>>" +opr.bufferSet);
		while(opr.exists(name1,name2,opr.bufferSet)==true){
				synchronized (opr.bufferSet){
				try {
					System.out.println("Trans1 Waiting <<element exists in bufferset>> ");
					opr.bufferSet.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Trans1 Waiting finish  <<check element again>> ");
				
			}
		}
					
			opr.begin(person.getID(),personSet, name1, name2);
		
			}
	
	

}
