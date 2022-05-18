package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.CourseNotFoundException;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;
import model.UserPojo;

public class StudentDaoImpl implements StudentDao {

	@Override
	public StudentPojo registerStudentCourse(StudentPojo studentPojo) throws SystemException {
		CoursePojo coursePojo = new CoursePojo();
		UserPojo userPojo = new UserPojo();

		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
		
			System.out.println(studentPojo.getCourseRegistered());
			String query1 = "SELECT course_id FROM course_details WHERE course_name='"+studentPojo.getCourseRegistered()+"'";
			ResultSet resultSet1 = stmt.executeQuery(query1);
			resultSet1.next();
			int studentCourseId = resultSet1.getInt(1);
			System.out.println("Student Course Registered from Courses Table is: " +studentPojo.getCourseRegistered());
			System.out.println("Foreign key course_id from course table in student table is :" +studentCourseId);
			
			String query4 = "Insert into student_details (student_first_name, student_last_name, student_gender, student_address, student_email_id, student_phone_number, student_password, student_course_registered, course_id, user_id) VALUES ('"+studentPojo.getStudentFirstName()+"','"+ studentPojo.getStudentLastName()+"', '"+ studentPojo.getStudentGender()+"', '"+ studentPojo.getStudentAddress()+"', '"+ studentPojo.getStudentEmailId()+"','"+studentPojo.getStudentPhoneNumber()+"','"+studentPojo.getStudentPassword()+"','"+studentPojo.getCourseRegistered()+"','"+studentPojo.getCourseId()+"','"+studentPojo.getUserId()+"') returning student_roll_number"; 
			ResultSet resultSet4 = stmt.executeQuery(query4);
			resultSet4.next();	
				
			String query5 = "UPDATE course_details SET total_students_registered = total_students_registered + 1 WHERE course_id = " +studentPojo.getCourseId();
			int rowsAffected5 = stmt.executeUpdate(query5);
		

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return studentPojo;
	}

	@Override
	public List<CoursePojo> getAllCourses()throws EmptyCourseCatalogException,SystemException {
		List<CoursePojo> allCourses = new ArrayList<CoursePojo>();
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM course_details";
			ResultSet resultSet = stmt.executeQuery(query);
			int counter = 0;
			while(resultSet.next()) {
				counter++;
				CoursePojo coursePojo = new CoursePojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9));
				allCourses.add(coursePojo);
			}
			if(counter == 0) {
				throw new EmptyCourseCatalogException();
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return allCourses;
	}


	
	@Override
	public StudentPojo cancelCourse(StudentPojo studentPojo) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			
			//System.out.println("Student registered CourseId is: "+studentPojo.getCourseId()+"Student User Id is: "+studentPojo.getUserId());

			String query = "DELETE FROM student_details WHERE course_id = "+studentPojo.getCourseId()+"AND user_id = "+studentPojo.getUserId();
			int rowsAffected = stmt.executeUpdate(query);
			
			String query1 = "UPDATE course_details SET total_students_registered = total_students_registered - 1 WHERE course_id = " +studentPojo.getCourseId();
			int rowsAffected1 = stmt.executeUpdate(query1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return studentPojo;
	}

	@Override
	public List<StudentPojo> studentRegisteredCourses(int userId)throws SystemException, CourseNotFoundException {
		List<StudentPojo> allRegisteredCourses = new ArrayList<StudentPojo>();

		Connection conn = null;
		StudentPojo studentPojo = new StudentPojo();
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			System.out.println(studentPojo.getUserId());
			String query = "SELECT * FROM student_details WHERE user_id="+userId;
			ResultSet resultSet = stmt.executeQuery(query);
			int counter = 0;
			while(resultSet.next()) {
				counter++;
				StudentPojo registeredStudentPojo = new StudentPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getString(8), resultSet.getString(9), resultSet.getInt(10), resultSet.getInt(11));
				allRegisteredCourses.add(registeredStudentPojo);
			}
			/*if(counter == 0) {
				throw new CourseNotFoundException();
			}*/
		} catch (SQLException e) {
			throw new SystemException();
		}
		return allRegisteredCourses;
	}
	
}
