package example.newList;

import java.util.HashMap;
import java.util.HashSet;

public class Trans3 extends Thread {
	
	String name1;
	String name2;
	HashSet<String> personSet=new HashSet();
	HashMap<String, Integer> bufferSet = new HashMap<String, Integer>();
	
	public Trans3(HashSet<String> personSet,HashMap<String, Integer> bufferSet,String name1,String name2){
		this.name1 = name1;
		this.name2 = name2;
		this.personSet = personSet;
		this.bufferSet = bufferSet;
		}
	
	Operation opr = new Operation();
	
	public void run() {
		try {
			//System.out.println("personSet<<>> "+personSet);
			System.out.println("Trans3 calling begin<<>>");
			opr.begin(personSet,bufferSet,name1,name2);
			System.out.println("Trans3 calling COMMIT<<>>");
			opr.commit(name1, name2, personSet, bufferSet);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
