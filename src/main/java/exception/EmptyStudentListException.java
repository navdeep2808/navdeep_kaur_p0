package exception;

public class EmptyStudentListException extends Exception{

	public String getMessage() {
		return "No Student Registered in this Course!";
	}

	
}
