package service;

import java.util.List;

import exception.CourseNotFoundException;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;

public interface CourseService {

	CoursePojo addCourse(CoursePojo coursePojo)throws SystemException;
	
	CoursePojo updateCourse(CoursePojo coursePojo)throws SystemException;
	
	void deleteCourse(int courseId)throws SystemException;
	
	List <CoursePojo> getAllCourses() throws EmptyCourseCatalogException, SystemException;
	
	CoursePojo getACourse(int courseId)throws SystemException;

}
