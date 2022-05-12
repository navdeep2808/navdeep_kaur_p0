package presentation;

import java.util.List;
import java.util.Scanner;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import service.CourseService;
import service.CourseServiceImpl;
import dao.CourseDao;
import dao.CourseDaoCollectionImpl;


public class CourseRegistrationSystem {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		CourseService courseService = new CourseServiceImpl();
		String userInput = scan.nextLine();

		char proceed = 'y';
		
		while(proceed == 'y') {
			System.out.println("*****************************");
			System.out.println("COURSE REGISTRATION SYSTEM");
			System.out.println("*****************************");
			System.out.println("1. List all Courses");
			System.out.println("2. Add a new Course");
			System.out.println("3. Delete a Course");
			System.out.println("4. Update a Course");
			System.out.println("5. Exit");
			System.out.println("*****************************");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("*****************************");
			//int userInputCourseId;
			CoursePojo newCoursePojo = new CoursePojo();
			switch(option) {
				case 1:
					List<CoursePojo> everyCourse;
					try {
						everyCourse = courseService.getAllCourses();
					} catch (EmptyCourseCatalogException e) {
						System.out.println(e.getMessage());
						break;
					} catch (SystemException e) {
						System.out.println(e.getMessage());
						break;
					}
					
					System.out.println("***************************************************************************************");
					System.out.println("ID\tNAME\tCode\tDESCRIPTION\tCOST\tDuration\tInstructor Name");
					System.out.println("***************************************************************************************");
					everyCourse.forEach((item)-> System.out.println(item.getCourseId() + "\t" + item.getCourseName() + "\t" +  item.getCourseCode() + "\t" + item.getCourseDescription() + "\t" + item.getCourseCost() + "\t" + item.getCourseDuration() + "\t\t" + item.getCourseInstructorName()));
					System.out.println("***************************************************************************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
					
				case 2:
					System.out.println("***************************************************************************************");
					System.out.println(" Add a new Course");
					System.out.println(" Input the Name of Course");
					scan.nextLine();
					newCoursePojo.setCourseName(scan.nextLine());
					System.out.println(" Input the Course code");
					scan.nextLine();
					newCoursePojo.setCourseCode(scan.nextLine());					
					System.out.println(" Input the Course Description");
					scan.nextLine();
					newCoursePojo.setCourseDescription(scan.nextLine());
					System.out.println(" Input the Cost of Course in USD");
					scan.nextInt();
					newCoursePojo.setCourseCost(scan.nextInt());
					System.out.println(" Input the Duration of Course in Hours");
					scan.nextInt();
					newCoursePojo.setCourseDuration(scan.nextInt());
					System.out.println(" Input the Name of Course Instructor");
					scan.nextLine();
					newCoursePojo.setCourseInstructorName(scan.nextLine());
					System.out.println("***************************************************************************************");
					//System.out.println(" Below are the details of Course added by you:");
				//	System.out.println("***************************************************************************************");
					//System.out.println("ID\tNAME\tCode\tDESCRIPTION\tCOST\tDuration\tInstructor Name");
					//System.out.println("***************************************************************************************");
					//addCourseService.forEach((newItem)-> System.out.println(newItem.getCourseId() + "\t" + newItem.getCourseName() + "\t" +  newItem.getCourseCode() + "\t" + newItem.getCourseDescription() + "\t" + newItem.getCourseCost() + "\t" + newItem.getCourseDuration() + "\t\t" + newItem.getCourseInstructorName()));
					CoursePojo coursePojo = null;
					try {
						coursePojo =  courseService.addCourse(newCoursePojo);
					} catch (SystemException e) {
						System.out.println(e.getMessage());
						break;
					}
					System.out.println("*****************************");
					System.out.println("New Course added successfully! \nCourse ID is :" + coursePojo.getCourseId());
					System.out.println("*****************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
					
				case 3:
					System.out.println("***************************************************************************************");
					System.out.println(" Delete a  Course");
					System.out.println(" Input the course ID of the Course that you want to delete");
					int courseId = scan.nextInt(); 
					CoursePojo getCoursePojo = null;
					try {
						getCoursePojo = courseService.getACourse(courseId);
					} catch (SystemException e1) {
						System.out.println(e1.getMessage());
						break;
					}
					if(getCoursePojo == null) {
						System.out.println("*****************************");
						System.out.println("Course ID does not exist. \nPlease enter a valid Course ID!");
						System.out.println("*****************************");
						break;
					}else {
						System.out.println("*****************************");
						System.out.println("Course to be removed...");
						System.out.println("*****************************");
						System.out.println("Course ID : " + getCoursePojo.getCourseId());
						System.out.println("Course Name : " + getCoursePojo.getCourseName());
						System.out.println("Course Code : " + getCoursePojo.getCourseCode());
						System.out.println("Course Description : " + getCoursePojo.getCourseDescription());
						System.out.println("Course Cost : " + getCoursePojo.getCourseCost());
						System.out.println("Course Duration : " + getCoursePojo.getCourseDuration());
						System.out.println("Course Instructor Name : " + getCoursePojo.getCourseInstructorName());

						System.out.println("*****************************");
						System.out.println("Are you sure you want to remove this Course? (y/n) :");
						char answer = scan.next().charAt(0);
						System.out.println("*****************************");
						if(answer == 'y') {
							try {
								courseService.deleteCourse(courseId);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("Course removed from Course Catalog...");
						}else {
							System.out.println("Course not removed from Course Catalog...");
						}
						System.out.println("*****************************");
					}
					//CourseService deletedCourse = new CourseServiceImpl();
					//courseService.deleteCourse(userInputCourseId);
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
					
				case 4:
					System.out.println("***************************************************************************************");
					System.out.println(" Update a  Course");
					System.out.println(" Input the course ID of the Course that you want to update");
					userInput = scan.nextLine();
					System.out.println("***************************************************************************************");
					System.out.println(" Select from the options below the data that you want to update in a Course");
					System.out.println(" 1. Name of Course ");
					System.out.println(" 2. Course Code of Course ");
					System.out.println(" 3. Description of Course ");
					System.out.println(" 4. Cost of Course ");
					System.out.println(" 5. Duration of Course ");
					System.out.println(" 6. Name of Instructor of Course ");
					System.out.println(" 7. Update All Details ");

					int updationChoice;
					updationChoice = scan.nextInt();
					switch(updationChoice){
					case 1: 
						System.out.println(" Input the New Name of Course");
						scan.nextLine();
						newCoursePojo.setCourseName(scan.nextLine());
						break;
						
					case 2:
						System.out.println(" Input the New Course code");
						scan.nextLine();
						newCoursePojo.setCourseCode(scan.nextLine());
						break;
						
					case 3:
						System.out.println(" Input the New Course Description");
						scan.nextLine();
						newCoursePojo.setCourseDescription(scan.nextLine());
						break;
						
					case 4:
						System.out.println(" Input the New Cost of Course in USD");
						scan.nextInt();
						newCoursePojo.setCourseCost(scan.nextInt());
						break;
						
					case 5:						
						System.out.println(" Input the New Duration of Course in Hours");
						scan.nextInt();
						newCoursePojo.setCourseDuration(scan.nextInt());	
						break;
					
					case 6:
						System.out.println(" Input the Name of Course Instructor");
						scan.nextLine();
						newCoursePojo.setCourseInstructorName(scan.nextLine());
						break;
						
					case 7: 
						System.out.println("Please enter Course ID to be updated :");
						int updateCourseId = scan.nextInt(); 
						CoursePojo updateCoursePojo = null;
						try {
							updateCoursePojo = courseService.getACourse(updateCourseId);
						} catch (SystemException e) {
							System.out.println(e.getMessage());
							break;
						}
						if(updateCoursePojo == null) {
							System.out.println("*****************************");
							System.out.println("Course ID does not exist. \nPlease enter a valid Course ID!");
							System.out.println("*****************************");
							break;
						}else {
							System.out.println("*****************************");
							System.out.println("Course to be updated...");
							System.out.println("*****************************");
							System.out.println("Course ID : " + updateCoursePojo.getCourseId());
							System.out.println("Course Name : " + updateCoursePojo.getCourseName());
							System.out.println("Course Code : " + updateCoursePojo.getCourseCode());
							System.out.println("Course Description : " + updateCoursePojo.getCourseDescription());
							System.out.println("Course Cost : " + updateCoursePojo.getCourseCost());
							System.out.println("Course Duration : " + updateCoursePojo.getCourseDuration());
							System.out.println("Course Instructor Name : " + updateCoursePojo.getCourseInstructorName());

							System.out.println("*****************************");
							System.out.println("Please enter new Course Cost :");
							
							updateCoursePojo.setCourseCost(scan.nextInt());
							try {
								courseService.updateCourse(updateCoursePojo);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("*****************************");
							System.out.println("Course updated successfully...");
							System.out.println("*****************************");
						}
						break;
						
					default:
						System.out.println(" Input the correct option");
						break;
					}
					System.out.println("***************************************************************************************");
				//	System.out.println(" Below are the details of Course added by you:");
				//	System.out.println("***************************************************************************************");
				//	System.out.println("ID\tNAME\tCode\tDESCRIPTION\tCOST\tDuration\tInstructor Name");
				//	System.out.println("***************************************************************************************");
					//addCourseService.forEach((newItem)-> System.out.println(newItem.getCourseId() + "\t" + newItem.getCourseName() + "\t" +  newItem.getCourseCode() + "\t" + newItem.getCourseDescription() + "\t" + newItem.getCourseCost() + "\t" + newItem.getCourseDuration() + "\t\t" + newItem.getCourseInstructorName()));
					
				//	courseService.updateCourse(CoursePojo);
					break;
					
				case 5:
					System.out.println("***************************************************************************************");
					System.out.println("Thank you for using Course Registration System!!");
					System.out.println("***************************************************************************************");
					System.exit(0);
					
				default:
					
			}
			
		}
		System.out.println("***************************************************************************************");
		System.out.println("Thank you for using Course Registration System!!");
		System.out.println("***************************************************************************************");
		System.exit(0);
	}

}
