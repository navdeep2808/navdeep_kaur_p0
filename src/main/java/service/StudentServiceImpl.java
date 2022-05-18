package service;

import java.util.List;


import dao.CourseDao;
import dao.CourseDaoDatabaseImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
import exception.CourseNotFoundException;
import exception.EmptyCourseCatalogException;
import exception.EmptyStudentListException;
import exception.SystemException;
import model.CoursePojo;
import model.StudentPojo;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao;
	CourseDao courseDao;

	public StudentServiceImpl() {

		studentDao = new StudentDaoImpl();
		courseDao = new CourseDaoDatabaseImpl();
	}

	@Override
	public StudentPojo registerStudentCourse(StudentPojo studentPojo) throws SystemException {
		return studentDao.registerStudentCourse(studentPojo);
	}

	@Override
	public StudentPojo cancelCourse(StudentPojo studentPojo) throws SystemException {
		return studentDao.cancelCourse(studentPojo);

	}

	@Override
	public List<StudentPojo> studentRegisteredCourses(int userId) throws SystemException, CourseNotFoundException {
		return studentDao.studentRegisteredCourses(userId);

	}
	
}
