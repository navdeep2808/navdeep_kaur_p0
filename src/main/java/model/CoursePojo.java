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
		private String courseCode;
		private int courseCost;
		private int courseDuration;
		private String courseInstructorName;
		private String courseDescription;
		private int totalStudentsRegistered=0;
		private int maximumStudentsAllowed=20;
	//	private String courseImageUrl;
	
		public CoursePojo() {
			// TODO Auto-generated constructor stub
		}

		public CoursePojo(int courseId, String courseName, String courseCode, int courseCost, int courseDuration,
			String courseInstructorName, String courseDescription, int totalStudentsRegistered,
			int maximumStudentsAllowed) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseCost = courseCost;
		this.courseDuration = courseDuration;
		this.courseInstructorName = courseInstructorName;
		this.courseDescription = courseDescription;
		this.totalStudentsRegistered = totalStudentsRegistered;
		this.maximumStudentsAllowed = maximumStudentsAllowed;
	}

		public int getCourseId() {
			return courseId;
		}


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


		public String getCourseDescription() {
			return courseDescription;
		}


		public void setCourseDescription(String courseDescription) {
			this.courseDescription = courseDescription;
		}


		public int getTotalStudentsRegistered() {
			return totalStudentsRegistered;
		}


		public void setTotalStudentsRegistered(int totalStudentsRegistered) {
			this.totalStudentsRegistered = totalStudentsRegistered;
		}


		public int getMaximumStudentsAllowed() {
			return maximumStudentsAllowed;
		}


		public void setMaximumStudentsAllowed(int maximumStudentsAllowed) {
			this.maximumStudentsAllowed = maximumStudentsAllowed;
		}


		@Override
		public String toString() {
			return "CoursePojo [courseId=" + courseId + ", courseName=" + courseName + ", courseCode=" + courseCode
					+ ", courseCost=" + courseCost + ", courseDuration=" + courseDuration + ", courseInstructorName="
					+ courseInstructorName + ", courseDescription=" + courseDescription + ", totalStudentsRegistered="
					+ totalStudentsRegistered + ", maximumStudentsAllowed=" + maximumStudentsAllowed + "]";
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
			result = prime * result + ((courseInstructorName == null) ? 0 : courseInstructorName.hashCode());
			result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
			result = prime * result + maximumStudentsAllowed;
			result = prime * result + totalStudentsRegistered;
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
			if (maximumStudentsAllowed != other.maximumStudentsAllowed)
				return false;
			if (totalStudentsRegistered != other.totalStudentsRegistered)
				return false;
			return true;
		}

}