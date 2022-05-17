package service;

import exception.SystemException;
import model.UserPojo;

public interface UserService {
	
	UserPojo register(UserPojo userPojo)throws SystemException, Exception;
	
	UserPojo validateUser(UserPojo userPojo)throws SystemException, Exception;
	
	void exitApplication();	
	
}