package service;

import java.util.List;

import exception.CourseNotFoundException;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;

public interface StudentService {
	
	StudentPojo registerStudentCourse(StudentPojo studentPojo) throws SystemException;
	
	StudentPojo cancelCourse(StudentPojo studentPojo) throws SystemException;

	List<StudentPojo> studentRegisteredCourses(int userId) throws SystemException, CourseNotFoundException;

	//List<CoursePojo> studentRegisteredCourses(StudentPojo studentPojo) throws SystemException;

}
