package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.SystemException;
import model.UserPojo;

public class UserDaoImpl implements UserDao{

	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
	
	@Override
	public UserPojo registerUser(UserPojo userPojo) throws SystemException, Exception {
		logger.info("Entered register() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO user_details(user_password, user_first_name, user_last_name, user_type, user_removed, user_name)" 
							+ " VALUES ('"+userPojo.getUserPassword()+"','"+userPojo.getUserFirstName()
							+"','"+userPojo.getUserLastName()+"','"+userPojo.getUserType()
							+"',"+userPojo.isUserRemoved()+",'"+userPojo.getUserName()+"') returning user_id";
			
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			userPojo.setUserId(resultSet.getInt(1));
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		logger.info("Exited register() in dao.");
		return userPojo;
	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws SystemException, Exception {
		logger.info("Entered validateUser() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user_details WHERE user_id="+userPojo.getUserId()
							+" and user_password='"+userPojo.getUserPassword()+"' and user_removed=false";
			
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
				userPojo.setUserFirstName(resultSet.getString(3));
				userPojo.setUserLastName(resultSet.getString(4));
				userPojo.setUserType(resultSet.getString(5));
				userPojo.setUserRemoved(resultSet.getBoolean(6));
				userPojo.setUserName(resultSet.getString(7));
			}
		} catch (SQLException e) {
			throw new SystemException();
			//throw new SystemException(e.getMessage());
		}
		
		//logger.info("Exited validateUser() in dao.");
		return userPojo;
	}

	@Override
	public void exitApplication() {
		DBUtil.closeConnection();
	}

	
}