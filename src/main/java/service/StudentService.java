package service;

import java.util.List;

import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;

public interface StudentService {
	
	StudentPojo registerStudentCourse(StudentPojo studentPojo) throws SystemException;
	
	List <CoursePojo> getAllCourses() throws EmptyCourseCatalogException, SystemException;
	
	StudentPojo cancelCourse(StudentPojo studentPojo) throws SystemException;

	StudentPojo studentRegisteredCourses(int studentRollNumber)throws SystemException;

}
