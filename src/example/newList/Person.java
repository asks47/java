package example.newList;
import java.util.HashSet;

public class Person {
	public static int id = 0;
	String p1 = "Sanjay";
	String p2 = "Amarnath";
	String p3 = "Ashwini";
	String p4 = "Jitesh";
	
	Person(HashSet<String> personSet){
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
	}
	Person(){
		
	}
	public static int getID()
	{
		id = id+1;
		return id;
		}
	
		
	}

