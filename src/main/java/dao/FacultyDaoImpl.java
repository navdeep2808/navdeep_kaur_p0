package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.SystemException;
import model.FacultyPojo;

public class FacultyDaoImpl implements FacultyDao{

	public FacultyDaoImpl() {
		
		//	List<FacultyPojo> allFaculty = new ArrayList<FacultyPojo>();
		
		//	FacultyPojo faculty1 = new FacultyPojo( 1001, "Joe", "San" , "Male", "Programming" , "Project Leader", 
		//			"#5, Wall Street, New York" , "joe.12@gmail.com" , "JoeSan12" , "Hello12" );
		//	FacultyPojo faculty2 = new FacultyPojo(1002, "Anna", "Roy" , "Female", "Programming" , "Coding Instructor", 
		//			"#23, Golfs Blvd, Illinois" , "anna.roy98@gmail.com" , "AnnaRoy98" , "Welcome98");
		//	FacultyPojo faculty3 = new FacultyPojo(1003, "Ted", "Robertson" , "Male", "Networking" , "Network Administrator", 
		//			"#42, Hewris Drive, California" , "ted.robertson@gmail.com" , "JTedRobertson3" , "Good674");
		//	allFaculty.add(faculty1);
		//	allFaculty.add(faculty2);
		//	allFaculty.add(faculty3);
		}

		@Override
		public FacultyPojo registerFaculty(FacultyPojo facultyPojo) throws SystemException {
			Connection conn = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				// next two lines commented to implement returning of primary key
//				String query = "INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('"+productPojo.getProductName()+"', '"+productPojo.getProductDescription()+"', "+productPojo.getProductCost()+", '')";
//				int rowsAffected = stmt.executeUpdate(query);
				
				// to get record that was inserted with the auto generated primary key
				String query = "INSERT INTO faculty_details(faculty_first_name, faculty_last_name, faculty_gender, faculty_department, faculty_designation, faculty_address, faculty_email_id, faculty_username, faculty_password) VALUES ('"+facultyPojo.getFacultyFirstName()+"', '"+facultyPojo.getFacultyLastName()+"','"+facultyPojo.getFacultyGender()+"','"+facultyPojo.getFacultyDepartment()+"','"+facultyPojo.getFacultyDesignation()+"','"+facultyPojo.getFacultyAddress()+"','"+facultyPojo.getFacultyEmailId()+"','"+facultyPojo.getFacultyUserName()+"','"+facultyPojo.getFacultyPassword()+"', '') returning faculty_id";
				// using executeQuery instead of executeUpdate as the INSERT query here returns a column data
				ResultSet resultSet = stmt.executeQuery(query);
				// moving the pointer from before first to first position in the result set
				resultSet.next();
				// assign the retrieved product id in the pojo
				facultyPojo.setFacultyId(resultSet.getInt(1));
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SystemException();
			}
			return facultyPojo;
			

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
		public FacultyPojo loginFaculty(FacultyPojo facultyPojo) throws SystemException {
			Connection conn = null;
			FacultyPojo newfacultyPojo = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "SELECT faculty_password FROM faculty_details WHERE faculty_id="+newfacultyPojo.getFacultyId();
				ResultSet resultSet = stmt.executeQuery(query);
				System.out.println(resultSet.getString(10));
				//if(resultSet.next()) {
			//		facultyPojo = new FacultyPojo(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
			//	}
			} catch (SQLException e) {
				throw new SystemException();
			}
			return newfacultyPojo;
		}
		

		@Override
		public FacultyPojo getAFaculty(int facultyId) throws SystemException {
			Connection conn = null;
			FacultyPojo facultyPojo = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM faculty_details WHERE faculty_id="+facultyId;
				ResultSet resultSet = stmt.executeQuery(query);
				if(resultSet.next()) {
					facultyPojo = new FacultyPojo(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
				}
			} catch (SQLException e) {
				throw new SystemException();
			}
			return facultyPojo;
		}
}
