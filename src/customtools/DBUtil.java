package customtools;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//A comment goes here for pmd
public class DBUtil {
	// field
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("HarrisonCollege");
	// Empty constructor
	public DBUtil(){
		
	}
	//A comment goes here i guess
	public static EntityManagerFactory getEmFactory() {
	//Comment here any better
		return EMF;

	}
}
