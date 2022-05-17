package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;

public class StudentDaoImpl implements StudentDao {

	@Override
	public StudentPojo registerStudentCourse(StudentPojo studentPojo) throws SystemException {
		CoursePojo coursePojo = new CoursePojo();
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			System.out.println(studentPojo.getCourseRegistered());
			String query = "SELECT course_id FROM course_details WHERE course_name='"+studentPojo.getCourseRegistered()+"'";
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			int studentCourseId = resultSet.getInt(1);
			System.out.println("Foreign key course_id from course table in student table is :" +studentCourseId);
			
			String query1 = "Insert into student_details (student_first_name, student_last_name, student_gender, student_address, student_email_id, student_phone_number, student_password, student_course_registered, course_id) VALUES ('"+studentPojo.getStudentFirstName()+"','"+ studentPojo.getStudentLastName()+"', '"+ studentPojo.getStudentGender()+"', '"+ studentPojo.getStudentAddress()+"', '"+ studentPojo.getStudentEmailId()+"','"+studentPojo.getStudentPhoneNumber()+"','"+studentPojo.getStudentPassword()+"','"+studentPojo.getCourseRegistered()+"','"+studentCourseId+"') returning student_roll_number"; 
			ResultSet resultSet1 = stmt.executeQuery(query1);
			resultSet1.next();
			studentPojo.setStudentRollNumber(resultSet1.getInt(1));
			String query2 = "UPDATE course_details SET total_students_registered = total_students_registered + 1 WHERE course_id = " +coursePojo.getCourseId();
			int rowsAffected2 = stmt.executeUpdate(query2);

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentPojo studentRegisteredCourses(int studentRollNumber) throws SystemException {
		Connection conn = null;
		StudentPojo registeredStudentPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM student_details WHERE student_roll_number="+studentRollNumber;
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
				registeredStudentPojo = new StudentPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getString(8), resultSet.getString(9), resultSet.getInt(10));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return registeredStudentPojo;
	}

	

	
}
