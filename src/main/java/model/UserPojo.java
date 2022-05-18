package model;

public class UserPojo {

	int userId;
	String userPassword;
	String userFirstName;
	String userLastName;
	String userType;
	boolean userRemoved;
	String userName;
	
	public UserPojo() {
	}

	public UserPojo(int userId, String userPassword, String userFirstName, String userLastName, String userType,
			boolean userRemoved, String userName) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userType = userType;
		this.userRemoved = userRemoved;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isUserRemoved() {
		return userRemoved;
	}

	public void setUserRemoved(boolean userRemoved) {
		this.userRemoved = userRemoved;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userPassword=" + userPassword + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userType=" + userType + ", userRemoved=" + userRemoved
				+ ", userName=" + userName + "]";
	}

}
