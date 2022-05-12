package service;

import java.util.List;

import dao.CourseDao;
import dao.CourseDaoCollectionImpl;
import dao.CourseDaoDatabaseImpl;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;

public class CourseServiceImpl implements CourseService{
	
	CourseDao courseDao;

	public CourseServiceImpl() {
		//courseDao = new CourseDaoCollectionImpl();
		courseDao = new CourseDaoDatabaseImpl();
	}

	@Override
	public CoursePojo addCourse(CoursePojo coursePojo) throws SystemException {
		return courseDao.addCourse(coursePojo);
	}

	@Override
	public CoursePojo updateCourse(CoursePojo coursePojo) throws SystemException {
		return courseDao.updateCourse(coursePojo);
	}

	@Override
	public void deleteCourse(int courseId) throws SystemException {
		courseDao.deleteCourse(courseId);
	}
	
	@Override
	public List<CoursePojo> getAllCourses() throws EmptyCourseCatalogException, SystemException{
		return courseDao.getAllCourses();
	}

	@Override
	public CoursePojo getACourse(int courseId) throws SystemException {
		return courseDao.getACourse(courseId);
	}

	
}
