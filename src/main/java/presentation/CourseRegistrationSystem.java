package presentation;

	import java.util.List;
	import java.util.Scanner;
	import exception.EmptyCourseCatalogException;
	import exception.SystemException;
	import model.CoursePojo;
	import model.FacultyPojo;
	import service.CourseService;
	import service.CourseServiceImpl;
	import dao.CourseDao;
	import dao.CourseDaoCollectionImpl;
	import service.FacultyService;
	import service.FacultyServiceImpl;

	public class CourseRegistrationSystem {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			CourseService courseService = new CourseServiceImpl();
			FacultyService facultyService = new FacultyServiceImpl();

			String userInput = scan.nextLine();
			System.out.println("**************************************************");
			System.out.println("\t\t\t\t\t\t\t COURSE REGISTRATION SYSTEM");
			System.out.println("**************************************************");
			System.out.println("Enter User Category:");
			System.out.println("1. Faculty");
			System.out.println("2. Student");
			int userCategory = scan.nextInt();
			switch(userCategory) { //user category switch
				case 1: //usercategory = faculty
						System.out.println("*****************************");
						System.out.println("COURSE REGISTRATION SYSTEM");
						System.out.println("*****************************");
						System.out.println("**************************************************");
						System.out.println("Are you alreday registered user? (y/n)");
						char userStatus = scan.next().charAt(0);
						
						switch(userStatus) { //faculty user status switch open
							case 'y': // faculty user status = registered user (yes)
								
								int facultyId;
							    String facultyPassword;
	
							    System.out.println("Log in:");
							    System.out.println("Input your Faculty ID: ");
							    facultyId = scan.nextInt();
	
							    System.out.println("Input your password: ");
							    facultyPassword = scan.nextLine();
	
							    FacultyPojo getFacultyPojo = null;
								try {
									facultyService.loginFaculty(getFacultyPojo);
									System.out.print(getFacultyPojo);
								} catch (SystemException e1) {
									System.out.println(e1.getMessage());
									break;
								}	
//								if(facultyId.equals(facultyPojo.getFacultyId())) {
								System.out.println("Login Successful!");
								System.out.println("********************************************************************");
								System.out.println("WELCOME TO COURSE REGISTRATION SYSTEM");
								System.out.println("********************************************************************");
								char proceed = 'y';
								while(proceed == 'y') {
									System.out.println("**********************************************************");
									System.out.println("COURSE REGISTRATION SYSTEM");
									System.out.println("**********************************************************");
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
									
									switch(option) { //faculty options switch open
										case 1: // list all courses - faculty area
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
											System.out.println("ID\tNAME\tCode\tDESCRIPTION\t\t\tCOST\tDuration\t\t\t\tInstructor Name");
											System.out.println("*************************************************************************************");
											everyCourse.forEach((item)-> System.out.println(item.getCourseId() + "\t" + item.getCourseName() + "\t" +  item.getCourseCode() + "\t" + item.getCourseDescription() + "\t\t\t" + item.getCourseCost() + "\t" + item.getCourseDuration() + "\t\t\t" + item.getCourseInstructorName()));
											System.out.println("***************************************************************************************");
											System.out.println("Do you want to continue?(y/n)");
											proceed = scan.next().charAt(0);
											break;
											
										case 2: // add new course - faculty area
											//CoursePojo newCoursePojo = new CoursePojo();
						
											System.out.println("***************************************************************************************");
											System.out.println(" Add a new Course");
											System.out.println(" Input the Course Id");
											//scan.nextInt();
											newCoursePojo.setCourseId(scan.nextInt());
											System.out.println(" Input the Name of Course");
											scan.nextLine();
											newCoursePojo.setCourseName(scan.nextLine());
											System.out.println(" Input the Course code");
											//scan.nextLine();
											newCoursePojo.setCourseCode(scan.nextLine());					
											System.out.println(" Input the Course Description");
											//scan.nextLine();
											newCoursePojo.setCourseDescription(scan.nextLine());
											System.out.println(" Input the Cost of Course in USD");
											//scan.nextInt();
											newCoursePojo.setCourseCost(scan.nextInt());
											System.out.println(" Input the Duration of Course in Hours");
											//scan.nextInt();
											newCoursePojo.setCourseDuration(scan.nextInt());
											System.out.println(" Input the Name of Course Instructor");
											scan.nextLine();
											newCoursePojo.setCourseInstructorName(scan.nextLine());
											System.out.println("***************************************************************************************");
				
											CoursePojo coursePojo = null;
											try {
												coursePojo =  courseService.addCourse(newCoursePojo);
												
											} catch (SystemException e) {
												System.out.println(e.getMessage());
												break;
											}
											System.out.println("*****************************");
											System.out.println("New Course added successfully! ");
											
											System.out.println("New Course added is:");
											System.out.println("*****************************");
											System.out.println("Course ID : " + newCoursePojo.getCourseId());
											System.out.println("Course Name : " + newCoursePojo.getCourseName());
											System.out.println("Course Code : " + newCoursePojo.getCourseCode());
											System.out.println("Course Description : " + newCoursePojo.getCourseDescription());
											System.out.println("Course Cost : " + newCoursePojo.getCourseCost());
											System.out.println("Course Duration : " + newCoursePojo.getCourseDuration());
											System.out.println("Course Instructor Name : " + newCoursePojo.getCourseInstructorName());
											System.out.println("*****************************");
											System.out.println("Do you want to continue?(y/n)");
											proceed = scan.next().charAt(0);
											break;
											
										case 3: // delete a course - faculty area
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
											}else { // else part 
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
											}// else part closed here
											//CourseService deletedCourse = new CourseServiceImpl();
											//courseService.deleteCourse(userInputCourseId);
											System.out.println("Do you want to continue?(y/n)");
											proceed = scan.next().charAt(0);
											break;
											
										case 4: // update course - faculty area
											System.out.println("***************************************************************************************");
											System.out.println(" Update a  Course");
											System.out.println(" Input the course ID of the Course that you want to update");
											userInput = scan.nextLine();
																	
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
											
												System.out.println("***************************************************************************************");
												System.out.println(" Select from the options below the data that you want to update in a Course");
												System.out.println(" 1. Name of Course ");
												System.out.println(" 2. Course Code of Course ");
												System.out.println(" 3. Description of Course ");
												System.out.println(" 4. Cost of Course ");
												System.out.println(" 5. Duration of Course ");
												System.out.println(" 6. Name of Instructor of Course ");
												System.out.println(" 7. Update All Details ");
												
												int updationChoice = scan.nextInt();
												switch(updationChoice){ //update courses switch open - faculty area
													case 1: // update course name - faculty area
														
															System.out.println("*****************************");
															System.out.println(" Input the New Name of Course");
															scan.nextLine();
															updateCoursePojo.setCourseName(scan.nextLine());
															try {
																courseService.updateCourse(updateCoursePojo);
															} catch (SystemException e) {
																System.out.println(e.getMessage());
																break;
															}
															System.out.println("*****************************");
															System.out.println("Course Name updated successfully...");
															System.out.println("*****************************");
															break;
														
													case 2:// update course code - faculty area
														System.out.println("*****************************");
														System.out.println(" Input the New Course code");
														scan.nextLine();
														updateCoursePojo.setCourseCode(scan.nextLine());
														try {
															courseService.updateCourse(updateCoursePojo);
														} catch (SystemException e) {
															System.out.println(e.getMessage());
															break;
														}
														System.out.println("*****************************");
														System.out.println("Course Code updated successfully...");
														System.out.println("*****************************");
														break;
														
													case 3: // update course description - faculty area
														System.out.println("*****************************");
														System.out.println(" Input the New Course Description");
														scan.nextLine();
														updateCoursePojo.setCourseDescription(scan.nextLine());
														try {
															courseService.updateCourse(updateCoursePojo);
														} catch (SystemException e) {
															System.out.println(e.getMessage());
															break;
														}
														System.out.println("*****************************");
														System.out.println("Course Description updated successfully...");
														System.out.println("*****************************");
														break;
														
													case 4: // update course cost - faculty area
														System.out.println(" Input the New Cost of Course in USD");
														scan.nextInt();
														updateCoursePojo.setCourseCost(scan.nextInt());
														try {
															courseService.updateCourse(updateCoursePojo);
														} catch (SystemException e) {
															System.out.println(e.getMessage());
															break;
														}
														System.out.println("*****************************");
														System.out.println("Course Cost updated successfully...");
														System.out.println("*****************************");
														break;
														
													case 5:		 // update course duration - faculty area				
														System.out.println(" Input the New Duration of Course in Hours");
														scan.nextInt();
														updateCoursePojo.setCourseDuration(scan.nextInt());
														try {
															courseService.updateCourse(updateCoursePojo);
														} catch (SystemException e) {
															System.out.println(e.getMessage());
															break;
														}
														System.out.println("*****************************");
														System.out.println("Course Duration updated successfully...");
														System.out.println("*****************************");
														break;
													
													case 6: // update course instructor name - faculty area
														System.out.println(" Input the Name of Course Instructor");
														scan.nextLine();
														updateCoursePojo.setCourseInstructorName(scan.nextLine());
														try {
															courseService.updateCourse(updateCoursePojo);
														} catch (SystemException e) {
															System.out.println(e.getMessage());
															break;
														}
														System.out.println("*****************************");
														System.out.println("Course Instructor Name updated successfully...");
														System.out.println("*****************************");
														break;
														
													case 7: // update all course details - faculty area
														/*System.out.println("Please enter Course ID to be updated :");
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
								*/
															System.out.println("*****************************");
															System.out.println("Please enter new Course Name :");
															updateCoursePojo.setCourseName(scan.nextLine());
					
															System.out.println("Please enter new Course Code :");
															updateCoursePojo.setCourseCode(scan.nextLine());
					
															System.out.println("Please enter new Course Description :");
															updateCoursePojo.setCourseDescription(scan.nextLine());
					
															System.out.println("Please enter new Course Cost :");
															updateCoursePojo.setCourseCost(scan.nextInt());
															
															System.out.println("Please enter new Course Duration :");
															updateCoursePojo.setCourseDuration(scan.nextInt());
															
															System.out.println("Please enter new Course Instructor Name :");
															updateCoursePojo.setCourseInstructorName(scan.nextLine());
					
															//updateCoursePojo.setCourseCost(scan.nextInt());
															try {
																courseService.updateCourse(updateCoursePojo);
															} catch (SystemException e) {
																System.out.println(e.getMessage());
																break;
															}
															System.out.println("*****************************");
															System.out.println("Course updated successfully...");
															System.out.println("*****************************");
														//}
															break;
															
													default: // default case update course switch - faculty area
														System.out.println(" Input the correct option");
														break;
													}//update  course switch closed -faculty area
													System.out.println("***************************************************************************************");
													System.out.println("Updated Course is : ");
													System.out.println("*****************************");
													System.out.println("Course ID : " + updateCoursePojo.getCourseId());
													System.out.println("Course Name : " + updateCoursePojo.getCourseName());
													System.out.println("Course Code : " + updateCoursePojo.getCourseCode());
													System.out.println("Course Description : " + updateCoursePojo.getCourseDescription());
													System.out.println("Course Cost : " + updateCoursePojo.getCourseCost());
													System.out.println("Course Duration : " + updateCoursePojo.getCourseDuration());
													System.out.println("Course Instructor Name : " + updateCoursePojo.getCourseInstructorName());
													System.out.println("*****************************");
													System.out.println("Do you want to continue?(y/n)");
													proceed = scan.next().charAt(0);
											}
											break;
									
										case 5: // exit faculty course registration area case number 5
											System.out.println("***************************************************************************************");
											System.out.println("Thank you for using Course Registration System!!");
											System.out.println("***************************************************************************************");
											System.exit(0);
											break;
												
										default: // default case of faculty options course registration area
											System.out.println("***************************************************************************************");
											System.out.println("Thank you for using Course Registration System!!");
											System.out.println("***************************************************************************************");
											System.exit(0);
											break;
										}// faculty main all options closed faculty 5 options switch closed list all courses,add,delete,update etc
										
								}break; // case faculty user status =  registered (yes) closed here
									
								case 'n': // faculty user status = not registered (no)
									FacultyPojo newFacultyPojo = new FacultyPojo();
				
									System.out.println("***************************************************************************************");
									System.out.println(" Register Faculty");
									System.out.println(" Input the Faculty Id");
									//scan.nextInt();
									newFacultyPojo.setFacultyId(scan.nextInt());
									System.out.println(" Input your First Name : ");
									scan.nextLine();
									newFacultyPojo.setFacultyFirstName(scan.nextLine());
									System.out.println(" Input your Last Name :");
									//scan.nextLine();
									newFacultyPojo.setFacultyLastName(scan.nextLine());					
									System.out.println(" Input your Gender :");
									//scan.nextLine();
									newFacultyPojo.setFacultyGender(scan.nextLine());
									System.out.println(" Input your Department :");
									//scan.nextInt();
									newFacultyPojo.setFacultyDepartment(scan.nextLine());
									System.out.println(" Input your Designation :");
									//scan.nextInt();
									newFacultyPojo.setFacultyDesignation(scan.nextLine());
									System.out.println(" Input your Address :");
									scan.nextLine();
									newFacultyPojo.setFacultyAddress(scan.nextLine());
									System.out.println(" Input your Email ID :");
									scan.nextLine();
									newFacultyPojo.setFacultyEmailId(scan.nextLine());
									System.out.println(" Input your Username :");
									scan.nextLine();
									newFacultyPojo.setFacultyUserName(scan.nextLine());
									System.out.println(" Input your Password :");
									scan.nextLine();
									newFacultyPojo.setFacultyPassword(scan.nextLine());
									FacultyPojo facultyPojo = null;
									try {
										facultyPojo = facultyService.registerFaculty(newFacultyPojo);
									} catch (SystemException e) {
										System.out.println(e.getMessage());
										break;
									}
									System.out.println("*****************************");
									System.out.println("New Faculty Registered added successfully! \n Faculty ID is :" + facultyPojo.getFacultyId());
									System.out.println("*****************************");
									
									default: // default case of facultystatus registered user/not registered user switch
											System.out.println(" Input the correct option either y or n only....");
											break;
								}// yes no user status switch closed here
								
			case 2: //usercategory = student starts here
				System.out.println(" Student Area");
				break;
					
			default: // default case of user category = faculty/student switch
				System.out.println(" Input the correct option");
				break;
			}//usercategory = faculty/student switch closed here
	}//main method closed here
}// CourseRegistrationSystem Java Class closed here

