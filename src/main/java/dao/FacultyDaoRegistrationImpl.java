package dao;

import java.util.ArrayList;
import java.util.List;

import model.FacultyPojo;

public class FacultyDaoRegistrationImpl implements FacultyDao {

	public FacultyDaoRegistrationImpl() {
		
		List<FacultyPojo> allFaculty = new ArrayList<FacultyPojo>();
	
		FacultyPojo faculty1 = new FacultyPojo( 1001, "Joe", "San" , "Male", "Programming" , "Project Leader", 
				"#5, Wall Street, New York" , "joe.12@gmail.com" , 98562 , "JoeSan12" , "Hello12" );
		FacultyPojo faculty2 = new FacultyPojo(1002, "Anna", "Roy" , "Female", "Programming" , "Coding Instructor", 
				"#23, Golfs Blvd, Illinois" , "anna.roy98@gmail.com" , 87598 , "AnnaRoy98" , "Welcome98");
		FacultyPojo faculty3 = new FacultyPojo(1003, "Ted", "Robertson" , "Male", "Networking" , "Network Administrator", 
				"#42, Hewris Drive, California" , "ted.robertson@gmail.com" , 97684 , "JTedRobertson3" , "Good674");
		allFaculty.add(faculty1);
		allFaculty.add(faculty2);
		allFaculty.add(faculty3);
	}

	@Override
	public FacultyPojo registerFaculty(FacultyPojo facultyPojo) {
		return facultyPojo;
		
		//Scanner sc = new Scanner();
		

	}

	//@Override
	//public FacultyPojo loginFaculty(FacultyPojo facultyPojo) {
	/*	Scanner scanner = new Scanner(System.in)) {
            System.out.print(" Enter user name => ");
            String userName = scanner.nextLine();

            System.out.print(" Enter password => ");
            String password = scanner.nextLine();

            if ("ramesh".equals(userName) && "password".equals(password)) {
                System.out.println(" User successfully logged-in.. ");
            } else {
                System.out.println(" In valid userName of password ");
            }*/
	//}

	@Override
	public FacultyPojo logoutFaculty(FacultyPojo facultyPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacultyPojo loginFaculty(FacultyPojo facultyPojo) {
		// TODO Auto-generated method stub
		return null;
	}

}
