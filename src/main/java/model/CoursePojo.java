package model;

public class CoursePojo {
	// private variables
	// default constructore
	// parametrized constructor
	// public getters/setters
	// toString
	// equals - if required
	// hashCode - if required
	
		private int courseId;
		private String courseName;
		private String courseDescription;
		private int courseCost;
		private int courseDuration;
		private String courseInstructorName;
		private String courseImageUrl;
		private String courseCode;
				
		public CoursePojo(int courseId, String courseName, String courseDescription, int courseCost, int courseDuration,
				String courseInstructorName, String courseImageUrl, String courseCode) {
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.courseDescription = courseDescription;
			this.courseCost = courseCost;
			this.courseDuration = courseDuration;
			this.courseInstructorName = courseInstructorName;
			this.courseImageUrl = courseImageUrl;
			this.courseCode = courseCode;
		}


		public CoursePojo() {
			// TODO Auto-generated constructor stub
		}


		public int getCourseId() {
				return courseId;
			}
		
	//	CREATE TABLE student_details(student_rollno INT PRIMARY KEY, student_first_name VARCHAR(20),student_last_name VARCHAR(20), student_gender  VARCHAR(20), student_address  VARCHAR(20), student_email_id  VARCHAR(30), student_phoneno INT, student_username  VARCHAR(20), student_password  VARCHAR(20));
	//	VALUES (505 , 'John' , 'Peter', 'Male', 'Programming' , 'Coding Instructor' , '#25 Highway Street , Toronto', 'john.peter@gmail.com' , 'johnPeter12345', 'PeterJohn54321'); 

	//	INSERT INTO student_details(student_rollno, student_first_name ,student_last_name , student_gender  , student_address  , student_email_id  , student_phoneno , student_username  , student_password  ) VALUES (301 , 'Jane' , 'Mall', 'Male', 'Surrey', 'janejmall@gmail.com' ,987564, 'janeMall45', 'good21ghr'); 
	//	INSERT INTO student_details(student_rollno, student_first_name ,student_last_name , student_gender  , student_address  , student_email_id  , student_phoneno , student_username  , student_password  ) VALUES (302 , 'Eron' , 'Bage', 'Male', 'NewYork', 'eron.bage11@gmail.com' ,877565, 'EronBage11', 'Eron11Bage11'); 
	//	INSERT INTO student_details(student_rollno, student_first_name ,student_last_name , student_gender  , student_address  , student_email_id  , student_phoneno , student_username  , student_password  ) VALUES (304 , 'Lisa' , 'Gauge', 'Female', 'Victoria', 'lisa11@gmail.com' ,87945, 'LisaGauge132', 'HelloLisa'); 

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}


		public String getCourseName() {
			return courseName;
		}


		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}


		public String getCourseCode() {
			return courseCode;
		}


		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}


		public String getCourseDescription() {
			return courseDescription;
		}


		public void setCourseDescription(String courseDescription) {
			this.courseDescription = courseDescription;
		}


		public int getCourseCost() {
			return courseCost;
		}


		public void setCourseCost(int courseCost) {
			this.courseCost = courseCost;
		}


		public int getCourseDuration() {
			return courseDuration;
		}


		public void setCourseDuration(int courseDuration) {
			this.courseDuration = courseDuration;
		}


		public String getCourseInstructorName() {
			return courseInstructorName;
		}


		public void setCourseInstructorName(String courseInstructorName) {
			this.courseInstructorName = courseInstructorName;
		}


		public String getCourseImageUrl() {
			return courseImageUrl;
		}


		public void setCourseImageUrl(String courseImageUrl) {
			this.courseImageUrl = courseImageUrl;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
			result = prime * result + courseCost;
			result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
			result = prime * result + courseDuration;
			result = prime * result + courseId;
			result = prime * result + ((courseImageUrl == null) ? 0 : courseImageUrl.hashCode());
			result = prime * result + ((courseInstructorName == null) ? 0 : courseInstructorName.hashCode());
			result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
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
			CoursePojo other = (CoursePojo) obj;
			if (courseCode == null) {
				if (other.courseCode != null)
					return false;
			} else if (!courseCode.equals(other.courseCode))
				return false;
			if (courseCost != other.courseCost)
				return false;
			if (courseDescription == null) {
				if (other.courseDescription != null)
					return false;
			} else if (!courseDescription.equals(other.courseDescription))
				return false;
			if (courseDuration != other.courseDuration)
				return false;
			if (courseId != other.courseId)
				return false;
			if (courseImageUrl == null) {
				if (other.courseImageUrl != null)
					return false;
			} else if (!courseImageUrl.equals(other.courseImageUrl))
				return false;
			if (courseInstructorName == null) {
				if (other.courseInstructorName != null)
					return false;
			} else if (!courseInstructorName.equals(other.courseInstructorName))
				return false;
			if (courseName == null) {
				if (other.courseName != null)
					return false;
			} else if (!courseName.equals(other.courseName))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "CoursePojo [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
					+ courseDescription + ", courseCost=" + courseCost + ", courseDuration=" + courseDuration
					+ ", courseInstructorName=" + courseInstructorName + ", courseImageUrl=" + courseImageUrl
					+ ", courseCode=" + courseCode + "]";
		}
		

}
