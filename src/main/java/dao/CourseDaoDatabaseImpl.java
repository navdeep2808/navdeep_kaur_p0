package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import exception.EmptyCourseCatalogException;
import exception.CourseNotFoundException;
import exception.SystemException;

import model.CoursePojo;
import model.StudentPojo;

public class CourseDaoDatabaseImpl implements CourseDao{
	
	//List<CoursePojo> allCourses = new ArrayList<CoursePojo>(); 
	
		//@Override
		public CoursePojo addCourse(CoursePojo coursePojo) throws SystemException {
			Connection conn = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "INSERT INTO course_details(course_name, course_code, course_cost, course_duration, course_instructor_name, course_description, total_students_registered, maximum_students_allowed)  VALUES ('"+coursePojo.getCourseName()+"','"+coursePojo.getCourseCode()+"', '"+ coursePojo.getCourseCost()+"', '"+ coursePojo.getCourseDuration()+"', '"+ coursePojo.getCourseInstructorName()+"','"+ coursePojo.getCourseDescription()+"','"+coursePojo.getTotalStudentsRegistered()+"','"+coursePojo.getMaximumStudentsAllowed()+"') returning course_id";
				ResultSet resultSet = stmt.executeQuery(query);
				resultSet.next();
			
				coursePojo.setCourseId(resultSet.getInt(1));

				//	String query = "INSERT INTO course_details(course_name, course_code, course_description, course_cost, course_duration, course_instructor_name, course_image_url) VALUES ('"+coursePojo.getCourseName()+"','"+coursePojo.getCourseCode()+"', '"+ coursePojo.getCourseDescription()+"', '"+ coursePojo.getCourseCost()+"', '"+ coursePojo.getCourseDuration()+"', '"+ coursePojo.getCourseInstructorName()+"','"+ coursePojo.getCourseImageUrl()+"','')";
				//System.out.println(coursePojo.getCourseCost());
				//String query = "INSERT INTO course_details(course_name, course_code,) VALUES ('"+coursePojo.getCourseName()+"','"+coursePojo.getCourseCode()+"','')";
				//int rowsAffected = stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SystemException();
			}
			return coursePojo;
		}

		@Override
		public CoursePojo updateCourse(CoursePojo coursePojo) throws SystemException {
			Connection conn = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				System.out.println(coursePojo.getCourseName());
				
				String query1 = "UPDATE course_details SET course_name = '"+coursePojo.getCourseName()+ "' WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected = stmt.executeUpdate(query1);
				 
				String query2 = "UPDATE course_details SET course_code = '"+coursePojo.getCourseCode()+ "' WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected2 = stmt.executeUpdate(query2);
				
				String query3 = "UPDATE course_details SET course_cost = "+coursePojo.getCourseCost()+ " WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected3 = stmt.executeUpdate(query3);
				
				String query4 = "UPDATE course_details SET course_duration = "+coursePojo.getCourseDuration()+ " WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected4 = stmt.executeUpdate(query4);
				
				String query5 = "UPDATE course_details SET course_instructor_name = '"+coursePojo.getCourseInstructorName()+ "' WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected5 = stmt.executeUpdate(query5);
				
				String query6 = "UPDATE course_details SET course_description = '"+coursePojo.getCourseDescription()+ "' WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected6 = stmt.executeUpdate(query6);
				
				String query7 = "UPDATE course_details SET maximum_students_allowed = "+coursePojo.getMaximumStudentsAllowed()+ " WHERE course_id = " +coursePojo.getCourseId();
				int rowsAffected7 = stmt.executeUpdate(query7);
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SystemException();
			}
			return coursePojo;
		}
		
		@Override
		public void deleteCourse(int courseId) throws SystemException {
			Connection conn = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				System.out.println(courseId);

				String query = "DELETE FROM course_details WHERE course_id="+courseId;
				int rowsAffected = stmt.executeUpdate(query);
				
				String query1 = "DELETE FROM student_details WHERE course_id="+courseId;
				int rowsAffected1 = stmt.executeUpdate(query1);
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SystemException();
			}
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
		public CoursePojo getACourse(int courseId) throws SystemException {
			Connection conn = null;
			CoursePojo coursePojo = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM course_details WHERE course_id="+courseId;
				ResultSet resultSet = stmt.executeQuery(query);
				if(resultSet.next()) {
					coursePojo = new CoursePojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9));
				}
			} catch (SQLException e) {
				throw new SystemException();
			}
			return coursePojo;
		}
/*
		@Override
		public List<CoursePojo> studentRegisteredCourses(StudentPojo studentPojo) throws EmptyCourseCatalogException, SystemException, CourseNotFoundException {
			List<CoursePojo> allRegisteredCourses = new ArrayList<CoursePojo>();
			CoursePojo coursePojo = new CoursePojo();
			
			StudentPojo studentPojoCourses = null;
		
			Connection conn = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query1 = "SELECT student_roll_number, student_first_name, student_last_name, course_id, student_course_registered FROM student_details WHERE user_id = "+studentPojo.getUserId()+"and course_id="+coursePojo.getCourseId();
				ResultSet resultSet1 = stmt.executeQuery(query1);
				int counter = 0;
				while(resultSet1.next()) {
					counter++;
					//StudentPojo studentPojoCourses1 ;
					StudentPojo studentPojoCourses1 = new StudentPojo (resultSet1.getInt(1), resultSet1.getString(2), resultSet1.getString(3), resultSet1.getString(4), resultSet1.getString(5), resultSet1.getString(6), resultSet1.getLong(7), resultSet1.getString(8), resultSet1.getString(9), resultSet1.getInt(10), resultSet1.getInt(11));
					//allRegisteredCourses.add(studentPojoCourses1);
					//allRegisteredCourses.addAll((Collection<? extends CoursePojo>) studentPojoCourses1);
				}
				if(counter == 0) {
					throw new CourseNotFoundException();
				}
			} catch (SQLException e) {
				throw new SystemException();
			}
			return allRegisteredCourses;
		}
	*/
		/*
		@Override
		public List<StudentPojo> studentRegisteredCourses(StudentPojo studentPojo) throws EmptyCourseCatalogException, SystemException, CourseNotFoundException {
			List<StudentPojo> allRegisteredCourses = new ArrayList<StudentPojo>();
			CoursePojo coursePojo = new CoursePojo();
			
			//StudentPojo studentPojoCourses = null;
		
			Connection conn = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query1 = "SELECT student_roll_number, student_first_name, student_last_name, course_id, student_course_registered FROM student_details WHERE user_id = "+studentPojo.getUserId()+"and course_id="+coursePojo.getCourseId();
				ResultSet resultSet1 = stmt.executeQuery(query1);
				int counter = 0;
				while(resultSet1.next()) {
					counter++;
					//StudentPojo studentPojoCourses1 ;
					StudentPojo studentPojoCourses1 = new StudentPojo (resultSet1.getInt(1), resultSet1.getString(2), resultSet1.getString(3), resultSet1.getString(4), resultSet1.getString(5), resultSet1.getString(6), resultSet1.getLong(7), resultSet1.getString(8), resultSet1.getString(9), resultSet1.getInt(10), resultSet1.getInt(11));
					allRegisteredCourses.add(studentPojoCourses1);
					//allRegisteredCourses.addAll((Collection<? extends CoursePojo>) studentPojoCourses1);
				}
				if(counter == 0) {
					throw new CourseNotFoundException();
				}
			} catch (SQLException e) {
				throw new SystemException();
			}
			return allRegisteredCourses;
		}
		*/
}
