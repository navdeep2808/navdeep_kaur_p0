package service;

import dao.FacultyDao;
import dao.FacultyDaoRegistrationImpl;
import exception.SystemException;
import model.FacultyPojo;

public class FacultyServiceImpl implements FacultyService {
	FacultyDao facultyDao;

	public FacultyServiceImpl() {
		facultyDao = new FacultyDaoRegistrationImpl();	}

	@Override
	public FacultyPojo registerFaculty(FacultyPojo facultyPojo) throws SystemException {
		return facultyDao.registerFaculty(facultyPojo);

	}

	@Override
	public FacultyPojo loginFaculty(FacultyPojo facultyPojo) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacultyPojo logoutFaculty(FacultyPojo facultyPojo) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacultyPojo getAFaculty(int facultyId) throws SystemException {
		return facultyDao.getAFaculty(facultyId);
	}

}
