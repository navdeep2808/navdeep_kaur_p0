package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.EmptyCourseCatalogException;
import exception.CourseNotFoundException;
import exception.SystemException;

import model.CoursePojo;

public class CourseDaoDatabaseImpl implements CourseDao {
	
		//@Override
		public CoursePojo addCourse(CoursePojo coursePojo) throws SystemException {
			Connection conn;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "INSERT INTO course_details(course_name, course_code, course_description, course_cost, course_duration, course_instructor_name, course_image_url) VALUES ('"+coursePojo.getCourseName()+"','"+coursePojo.getCourseCode()+"', '"+ coursePojo.getCourseDescription()+"', '"+ coursePojo.getCourseCost()+"', '"+ coursePojo.getCourseDuration()+"', '"+ coursePojo.getCourseInstructorName()+"','"+ coursePojo.getCourseImageUrl()+"','')";
				System.out.println(coursePojo.getCourseCost());

				int rowsAffected = stmt.executeUpdate(query);
			} catch (SQLException e) {
				throw new SystemException();
			}
			return coursePojo;
		}

		//@Override
		public CoursePojo updateCourse(CoursePojo coursePojo) {
		/*	for(int i=0;i<allCourses.size();i++) {
				if(allCourses.get(i).getCourseId() == coursePojo.getCourseId()) {
					allCourses.set(i, coursePojo); 
					break;
				}
			}*/
			return coursePojo;
		}

		//@Override
		public void deleteCourse(int courseId) {
		/*	Iterator<CoursePojo> allCoursesItr = allCourses.iterator();
			while(allCoursesItr.hasNext()) {
				CoursePojo getCourse = allCoursesItr.next();
				if(getCourse.getCourseId() == courseId) {
					allCourses.remove(getCourse);
					break;
				}
			}
			*/
		}

		//@Override
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
					CoursePojo coursePojo = new CoursePojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
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

		//@Override
		public CoursePojo getACourse(int courseId) throws SystemException {
			Connection conn = null;
			CoursePojo coursePojo = null;
			try {
				conn = DBUtil.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM course_details WHERE course_id="+courseId;
				ResultSet resultSet = stmt.executeQuery(query);
				if(resultSet.next()) {
					coursePojo = new CoursePojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
				}
			} catch (SQLException e) {
				throw new SystemException();
			}
			return coursePojo;
		}
	
}
