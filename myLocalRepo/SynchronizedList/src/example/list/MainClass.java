package example.list;
import java.util.HashSet;

public class MainClass {

	
	public static void main(String[] args){
		
		HashSet<String> personSet=new HashSet();
		Person person = new Person(personSet);
		System.out.println("personSet >> "+personSet);
		
		
		Trans1 t1 = new Trans1(personSet,"Ashwini","Sanjay");
		Trans2 t2 = new Trans2(personSet,"Jitesh","Amarnath");
		Trans3 t3 = new Trans3(personSet,"Sanjay","Jitesh");
		t1.start();
		t2.start();
		t3.start();
	
	}
	
}
