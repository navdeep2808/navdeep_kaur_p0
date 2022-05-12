package model;

public class FacultyPojo {
	
	private int facultyId;
	private String facultyFirstName;
	private String facultyLastName;
	private String facultyGender;
	private String facultyDepartment;
	private String facultyDesignation;
	private String facultyAddress;
	private String facultyEmailId;
	private long facultyPhoneNumber;
	private String facultyUserName;
	private String facultyPassword;
	
	public FacultyPojo(int facultyId, String facultyFirstName, String facultyLastName, String facultyGender,
			String facultyDepartment, String facultyDesignation, String facultyAddress, String facultyEmailId,
			long facultyPhoneNumber, String facultyUserName, String facultyPassword) {
		super();
		this.facultyId = facultyId;
		this.facultyFirstName = facultyFirstName;
		this.facultyLastName = facultyLastName;
		this.facultyGender = facultyGender;
		this.facultyDepartment = facultyDepartment;
		this.facultyDesignation = facultyDesignation;
		this.facultyAddress = facultyAddress;
		this.facultyEmailId = facultyEmailId;
		this.facultyPhoneNumber = facultyPhoneNumber;
		this.facultyUserName = facultyUserName;
		this.facultyPassword = facultyPassword;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyFirstName() {
		return facultyFirstName;
	}
	public void setFacultyFirstName(String facultyFirstName) {
		this.facultyFirstName = facultyFirstName;
	}
	public String getFacultyLastName() {
		return facultyLastName;
	}
	public void setFacultyLastName(String facultyLastName) {
		this.facultyLastName = facultyLastName;
	}
	public String getFacultyGender() {
		return facultyGender;
	}
	public void setFacultyGender(String facultyGender) {
		this.facultyGender = facultyGender;
	}
	public String getFacultyDepartment() {
		return facultyDepartment;
	}
	public void setFacultyDepartment(String facultyDepartment) {
		this.facultyDepartment = facultyDepartment;
	}
	public String getFacultyDesignation() {
		return facultyDesignation;
	}
	public void setFacultyDesignation(String facultyDesignation) {
		this.facultyDesignation = facultyDesignation;
	}
	public String getFacultyAddress() {
		return facultyAddress;
	}
	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}
	public String getFacultyEmailId() {
		return facultyEmailId;
	}
	public void setFacultyEmailId(String facultyEmailId) {
		this.facultyEmailId = facultyEmailId;
	}
	public long getFacultyPhoneNumber() {
		return facultyPhoneNumber;
	}
	public void setFacultyPhoneNumber(long facultyPhoneNumber) {
		this.facultyPhoneNumber = facultyPhoneNumber;
	}
	public String getFacultyUserName() {
		return facultyUserName;
	}
	public void setFacultyUserName(String facultyUserName) {
		this.facultyUserName = facultyUserName;
	}
	public String getFacultyPassword() {
		return facultyPassword;
	}
	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}
	@Override
	public String toString() {
		return "FacultyPojo [facultyId=" + facultyId + ", facultyFirstName=" + facultyFirstName + ", facultyLastName="
				+ facultyLastName + ", facultyGender=" + facultyGender + ", facultyDepartment=" + facultyDepartment
				+ ", facultyDesignation=" + facultyDesignation + ", facultyAddress=" + facultyAddress
				+ ", facultyEmailId=" + facultyEmailId + ", facultyPhoneNumber=" + facultyPhoneNumber
				+ ", facultyUserName=" + facultyUserName + ", facultyPassword=" + facultyPassword + "]";
	}
	
	
}
