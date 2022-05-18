package model;

public class StudentPojo {

	private int studentRollNumber;
	private String studentFirstName;
	private String studentLastName;
	private String studentGender;
	private String studentAddress;
	private String studentEmailId;
	private long studentPhoneNumber;
	private String studentPassword;
	private String courseRegistered;
	private int courseId;
	private int userId;
	
	public StudentPojo() {
		//super();
	}

	public StudentPojo(int studentRollNumber, String studentFirstName, String studentLastName, String studentGender,
			String studentAddress, String studentEmailId, long studentPhoneNumber, String studentPassword,
			String courseRegistered, int courseId, int userId) {
		super();
		this.studentRollNumber = studentRollNumber;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentGender = studentGender;
		this.studentAddress = studentAddress;
		this.studentEmailId = studentEmailId;
		this.studentPhoneNumber = studentPhoneNumber;
		this.studentPassword = studentPassword;
		this.courseRegistered = courseRegistered;
		this.courseId = courseId;
		this.userId = userId;
	}

	public int getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public long getStudentPhoneNumber() {
		return studentPhoneNumber;
	}

	public void setStudentPhoneNumber(long studentPhoneNumber) {
		this.studentPhoneNumber = studentPhoneNumber;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getCourseRegistered() {
		return courseRegistered;
	}

	public void setCourseRegistered(String courseRegistered) {
		this.courseRegistered = courseRegistered;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "StudentPojo [studentRollNumber=" + studentRollNumber + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", studentGender=" + studentGender + ", studentAddress="
				+ studentAddress + ", studentEmailId=" + studentEmailId + ", studentPhoneNumber=" + studentPhoneNumber
				+ ", studentPassword=" + studentPassword + ", courseRegistered=" + courseRegistered + ", courseId="
				+ courseId + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((courseRegistered == null) ? 0 : courseRegistered.hashCode());
		result = prime * result + ((studentAddress == null) ? 0 : studentAddress.hashCode());
		result = prime * result + ((studentEmailId == null) ? 0 : studentEmailId.hashCode());
		result = prime * result + ((studentFirstName == null) ? 0 : studentFirstName.hashCode());
		result = prime * result + ((studentGender == null) ? 0 : studentGender.hashCode());
		result = prime * result + ((studentLastName == null) ? 0 : studentLastName.hashCode());
		result = prime * result + ((studentPassword == null) ? 0 : studentPassword.hashCode());
		result = prime * result + (int) (studentPhoneNumber ^ (studentPhoneNumber >>> 32));
		result = prime * result + studentRollNumber;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPojo other = (StudentPojo) obj;
		if (courseId != other.courseId)
			return false;
		if (courseRegistered == null) {
			if (other.courseRegistered != null)
				return false;
		} else if (!courseRegistered.equals(other.courseRegistered))
			return false;
		if (studentAddress == null) {
			if (other.studentAddress != null)
				return false;
		} else if (!studentAddress.equals(other.studentAddress))
			return false;
		if (studentEmailId == null) {
			if (other.studentEmailId != null)
				return false;
		} else if (!studentEmailId.equals(other.studentEmailId))
			return false;
		if (studentFirstName == null) {
			if (other.studentFirstName != null)
				return false;
		} else if (!studentFirstName.equals(other.studentFirstName))
			return false;
		if (studentGender == null) {
			if (other.studentGender != null)
				return false;
		} else if (!studentGender.equals(other.studentGender))
			return false;
		if (studentLastName == null) {
			if (other.studentLastName != null)
				return false;
		} else if (!studentLastName.equals(other.studentLastName))
			return false;
		if (studentPassword == null) {
			if (other.studentPassword != null)
				return false;
		} else if (!studentPassword.equals(other.studentPassword))
			return false;
		if (studentPhoneNumber != other.studentPhoneNumber)
			return false;
		if (studentRollNumber != other.studentRollNumber)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
