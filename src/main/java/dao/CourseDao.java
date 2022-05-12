package dao;

import java.util.List;
import exception.SystemException;
import model.CoursePojo;
import exception.EmptyCourseCatalogException;

public interface CourseDao {
	
	CoursePojo addCourse(CoursePojo coursePojo) throws SystemException;
	
	CoursePojo updateCourse(CoursePojo coursePojo) throws SystemException;
	
	void deleteCourse(int courseId) throws SystemException;
	
	List <CoursePojo> getAllCourses() throws EmptyCourseCatalogException, SystemException;
	
	CoursePojo getACourse(int courseId) throws SystemException;

}
