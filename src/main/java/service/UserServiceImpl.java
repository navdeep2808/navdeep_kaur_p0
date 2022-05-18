
package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDao;
import dao.UserDaoImpl;
import model.UserPojo;

public class UserServiceImpl implements UserService  {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public UserPojo registerUser(UserPojo userPojo) throws Exception {
		logger.info("Entered register() in service.");
		UserPojo returnUserPojo = this.userDao.registerUser(userPojo);
		logger.info("Exited register() in service.");
		return returnUserPojo;	
	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws Exception {
		logger.info("Entered validateUser() in service.");
		UserPojo returnUserPojo = this.userDao.validateUser(userPojo);
		logger.info("Exited validateUser() in service.");
		return returnUserPojo;	
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		userDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}
}