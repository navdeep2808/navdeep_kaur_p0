package dao;

import exception.SystemException;
import model.FacultyPojo;

public interface FacultyDao {
	
	FacultyPojo registerFaculty(FacultyPojo facultyPojo) throws SystemException;
	
	FacultyPojo loginFaculty(FacultyPojo facultyPojo)throws SystemException;
	
	FacultyPojo logoutFaculty(FacultyPojo facultyPojo)throws SystemException;
	
	FacultyPojo getAFaculty(int facultyId)throws SystemException;


}
