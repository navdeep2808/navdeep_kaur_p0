package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.EmptyCourseCatalogException;
import exception.CourseNotFoundException;
import exception.SystemException;

import model.CoursePojo;

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

				String query = "DELETE FROM course_details WHERE course_id="+courseId;
				int rowsAffected = stmt.executeUpdate(query);
				
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
	
}
