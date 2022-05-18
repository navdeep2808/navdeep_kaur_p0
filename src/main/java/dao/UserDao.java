package dao;

import exception.SystemException;
import model.UserPojo;

public interface UserDao {
	
		UserPojo registerUser(UserPojo userPojo)throws SystemException, Exception;
		
		UserPojo validateUser(UserPojo userPojo)throws SystemException, Exception;
		
		void exitApplication();

}
