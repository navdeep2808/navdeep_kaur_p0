package exception;

public class EmptyCourseCatalogException extends Exception {

	@Override
	public String getMessage() {
		return "Course Catalog is Empty!";
	}

	

}
