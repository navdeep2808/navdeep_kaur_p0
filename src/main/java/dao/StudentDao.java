package dao;

import java.util.List;

import exception.CourseNotFoundException;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;

public interface StudentDao {
	
	StudentPojo registerStudentCourse(StudentPojo studentPojo) throws SystemException;
	
	StudentPojo cancelCourse(StudentPojo studentPojo) throws SystemException;

	List<StudentPojo> studentRegisteredCourses(int userId) throws SystemException, CourseNotFoundException;

	List<CoursePojo> getAllCourses() throws EmptyCourseCatalogException, SystemException;
	
}
