package service;

import java.util.List;

import dao.CourseDao;
import dao.CourseDaoDatabaseImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
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
	public StudentPojo studentRegisteredCourses(int studentRollNumber) throws SystemException {
		return studentDao.studentRegisteredCourses(studentRollNumber);
	}

	@Override
	public List<CoursePojo> getAllCourses() throws EmptyCourseCatalogException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
