package dao;

import model.FacultyPojo;

public interface FacultyDao {
	
	FacultyPojo registerFaculty(FacultyPojo facultyPojo);
	
	FacultyPojo loginFaculty(FacultyPojo facultyPojo);
	
	FacultyPojo logoutFaculty(FacultyPojo facultyPojo);

}
