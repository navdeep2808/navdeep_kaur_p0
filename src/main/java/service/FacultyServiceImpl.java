package service;

import dao.FacultyDao;
import dao.FacultyDaoImpl;
import exception.SystemException;
import model.FacultyPojo;

public class FacultyServiceImpl implements FacultyService {
	FacultyDao facultyDao;

	public FacultyServiceImpl() {
		facultyDao = new FacultyDaoImpl();	}

	@Override
	public FacultyPojo registerFaculty(FacultyPojo facultyPojo) throws SystemException {
		return facultyDao.registerFaculty(facultyPojo);

	}

	@Override
	public FacultyPojo loginFaculty(FacultyPojo facultyPojo) throws SystemException {
		return facultyDao.loginFaculty(facultyPojo);
	}

	@Override
	public FacultyPojo logoutFaculty(FacultyPojo facultyPojo) throws SystemException {
		return facultyDao.logoutFaculty(facultyPojo);

	}

	@Override
	public FacultyPojo getAFaculty(int facultyId) throws SystemException {
		return facultyDao.getAFaculty(facultyId);
	}

}
