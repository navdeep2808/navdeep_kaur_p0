package model;

public class StudentPojo {

	private int studentRollNumber;
	private String studentFirstName;
	private String studentLastName;
	private String studentGender;
	private String studentAddress;
	private String studentEmailId;
	private long studentPhoneNumber;
	private String studentUserName;
	private String studentPassword;
	
	public StudentPojo(int studentRollNumber, String studentFirstName, String studentLastName, String studentGender,
			String studentAddress, String studentEmailId, long studentPhoneNumber, String studentUserName,
			String studentPassword) {
		super();
		this.studentRollNumber = studentRollNumber;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentGender = studentGender;
		this.studentAddress = studentAddress;
		this.studentEmailId = studentEmailId;
		this.studentPhoneNumber = studentPhoneNumber;
		this.studentUserName = studentUserName;
		this.studentPassword = studentPassword;
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

	public String getStudentUserName() {
		return studentUserName;
	}

	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "StudentPojo [studentRollNumber=" + studentRollNumber + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", studentGender=" + studentGender + ", studentAddress="
				+ studentAddress + ", studentEmailId=" + studentEmailId + ", studentPhoneNumber=" + studentPhoneNumber
				+ ", studentUserName=" + studentUserName + ", studentPassword=" + studentPassword + "]";
	}
	
	
	
}
