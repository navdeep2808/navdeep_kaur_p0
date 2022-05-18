package presentation;
	import java.util.List;
	import java.util.Scanner;
	import exception.CourseNotFoundException;
	import exception.EmptyCourseCatalogException;
	import exception.SystemException;
	import model.CoursePojo;
	import model.FacultyPojo;
	import model.StudentPojo;
	import service.CourseService;
	import service.CourseServiceImpl;
	import dao.CourseDao;
	import dao.CourseDaoCollectionImpl;
	import service.FacultyService;
	import service.FacultyServiceImpl;
	import service.StudentService;
	import service.StudentServiceImpl;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import model.UserPojo;
	import service.UserService;
	import service.UserServiceImpl;
	public class CourseRegistrationSystem {
	private static final Logger logger = LogManager.getLogger(CourseRegistrationSystem.class);
	
	//This is the main method to implement the Login and Registration Part of Course Registration System.
	//This method also includes calls to classes implementing the Faculty andStudent USer Stories from Dao Layer
		
		public static void main(String[] args) throws Exception {
			logger.info("User Management System Application started...");
			
			CourseService courseService = new CourseServiceImpl();
			FacultyService facultyService = new FacultyServiceImpl();
			StudentService studentService = new StudentServiceImpl();
			UserService userService = new UserServiceImpl();
			Scanner scan = new Scanner(System.in);

			String userInput = scan.nextLine();
			
			int option = 0;
			String ch = "y";
			// User Registration and Validation Method Calls
			while("y".equals(ch)) {
				System.out.println("*******************************************");
				System.out.println("WELCOME TO COURSE REGISTRATION SYSTEM");
				System.out.println("*******************************************");
				System.out.println("1. New user? Register here....");
				System.out.println("2. Already have an Account? Login here....");
				System.out.println("3. Exit.");
				System.out.println("**********************************");
				System.out.println("Enter your option:");
				option = Integer.parseInt(scan.nextLine());
				System.out.println("**********************************");
				
				switch(option) {
				case 1:
					UserPojo userPojo = new UserPojo();
					System.out.println("Enter user first name:");
					userPojo.setUserFirstName(scan.nextLine());
					
					System.out.println("Enter user last name:");
					userPojo.setUserLastName(scan.nextLine());
					
					System.out.println("Enter user password:");
					userPojo.setUserPassword(scan.nextLine());
					
					System.out.println("Enter username:");
					userPojo.setUserName(scan.nextLine());
					
					System.out.println("**********************************");
					System.out.println("Choose the type of account:");
					System.out.println("**********************************");
					System.out.println("1. Faculty");
					System.out.println("2. Student");
					System.out.println("**********************************");
					System.out.println("Enter your option:");
					int typeOption = Integer.parseInt(scan.nextLine());
					System.out.println("**********************************");
					if(typeOption == 1) {
						userPojo.setUserType("faculty");
					}else if(typeOption == 2) {
						userPojo.setUserType("student");
					}else {
						System.out.println("Wrong input......");
					}
					
					userPojo.setUserRemoved(false);
					
					UserPojo returnedUserPojo = null;
					try {
						//System.out.println(userPojo);
						returnedUserPojo = userService.registerUser(userPojo);
					} catch (SystemException e) {
						System.out.println("**********************************");
						System.out.println("Database Error!!!!");
						System.out.println("Please try after sometime....");
						System.out.println("**********************************");
						logger.error(e.getMessage());
						break;
					}
					System.out.println("**********************************");
					System.out.println("User registered successfully!!");
					System.out.println("**********************************");
					System.out.println("Your User ID is : " + returnedUserPojo.getUserId());
					break;
					
				case 2:
					UserPojo userLoginPojo = new UserPojo();
					
					System.out.println("Enter user id:");
					userLoginPojo.setUserId(Integer.parseInt(scan.nextLine()));
					//userLoginPojo.setUserName(scan.nextLine());

					System.out.println("Enter user password:");
					userLoginPojo.setUserPassword(scan.nextLine());
					
					UserPojo returnedLoginUserPojo = null;
					try {
						returnedLoginUserPojo = userService.validateUser(userLoginPojo);
					} catch (SystemException e) {
						System.out.println("**********************************");
						System.out.println("Database Error!! ");
						System.out.println("Please try after sometime....");
						System.out.println("**********************************");
						logger.error(e.getMessage());
						break;
					}
					
					String userType = returnedLoginUserPojo.getUserType();
					if(userType !=null && userType.equals("faculty")) {
						System.out.println("**********************************");
						System.out.println("Faculty Login successfull!!");
						System.out.println("**********************************");
						char proceed = 'y';
						// Beginning Faculty Stories....
						while(proceed == 'y') {
							System.out.println("**********************************************************");
							System.out.println("COURSE REGISTRATION SYSTEM FACULTY PORTAL");
							System.out.println("**********************************************************");
							System.out.println("HELLO "+returnedLoginUserPojo.getUserFirstName()+ " "+returnedLoginUserPojo.getUserLastName()+ "!");

							System.out.println("1. List all Courses");
							System.out.println("2. Add a new Course");
							System.out.println("3. Delete a Course");
							System.out.println("4. Update a Course");
							System.out.println("5. Exit");
							System.out.println("*****************************");
							System.out.println("Please enter an option:");
							int facultyOption = scan.nextInt();
							System.out.println("*****************************");
							//int userInputCourseId;
							CoursePojo newCoursePojo = new CoursePojo();
							
							switch(facultyOption) { //faculty options switch open
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
									System.out.println("ID\tNAME\tCode\tCOST\tDuration\tInstructor Name  \tDESCRIPTION\t\tTotal Students\tMaximum students Allowed");
									System.out.println("*************************************************************************************");
									everyCourse.forEach((item)-> System.out.println(item.getCourseId() + "\t" + item.getCourseName() + "\t" +  item.getCourseCode() + "\t" + item.getCourseCost() + "\t" + item.getCourseDuration() + "\t\t" + item.getCourseInstructorName() + "\t\t\t" + item.getCourseDescription() + "\t\t\t\t" + item.getTotalStudentsRegistered() + "\t\t" + item.getMaximumStudentsAllowed()));
									System.out.println("***************************************************************************************");
									System.out.println("Do you want to continue?(y/n)");
									proceed = scan.next().charAt(0);
									break;
									
								case 2: // add new course - faculty area
									//CoursePojo newCoursePojo = new CoursePojo();
				
									System.out.println("***************************************************************************************");
									System.out.println(" Add a new Course");
									//System.out.println(" Input the Course Id");
									//scan.nextInt();
									//newCoursePojo.setCourseId(scan.nextInt());
									System.out.println(" Input the Name of Course");
									scan.nextLine();
									newCoursePojo.setCourseName(scan.nextLine());
									System.out.println(" Input the Course code");
									//scan.nextLine();
									newCoursePojo.setCourseCode(scan.nextLine());					
									System.out.println(" Input the Cost of Course in USD");
									//scan.nextInt();
									newCoursePojo.setCourseCost(scan.nextInt());
									System.out.println(" Input the Duration of Course in Hours");
									//scan.nextInt();
									newCoursePojo.setCourseDuration(scan.nextInt());
									System.out.println(" Input the Name of Course Instructor");
									scan.nextLine();
									newCoursePojo.setCourseInstructorName(scan.nextLine());
									System.out.println(" Input the Course Description");
									//scan.nextLine();
									newCoursePojo.setCourseDescription(scan.nextLine());
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
									System.out.println("Course Cost (USD) : " + newCoursePojo.getCourseCost());
									System.out.println("Course Duration (Hours): " + newCoursePojo.getCourseDuration());
									System.out.println("Course Instructor Name : " + newCoursePojo.getCourseInstructorName());
									System.out.println("Course Description : " + newCoursePojo.getCourseDescription());
									System.out.println("Total Students Registered : " + newCoursePojo.getTotalStudentsRegistered());
									System.out.println("Maximum Students Allowed : " + newCoursePojo.getMaximumStudentsAllowed());
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
										System.out.println("Course Cost (USD) : " + getCoursePojo.getCourseCost());
										System.out.println("Course Duration (Hours) : " + getCoursePojo.getCourseDuration());
										System.out.println("Course Instructor Name : " + getCoursePojo.getCourseInstructorName());
										System.out.println("Course Description : " + getCoursePojo.getCourseDescription());
										System.out.println("Total Students Registered : " + getCoursePojo.getTotalStudentsRegistered());
										System.out.println("Maximum Students Allowed : " + getCoursePojo.getMaximumStudentsAllowed());
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
									System.out.println("***************************************************************************************");

									//List<CoursePojo> everyCourse;
								//	everyCourse = courseService.getAllCourses();
									
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
										//CourseService updateCourseService = new CourseDaoImpl();

										System.out.println(updateCoursePojo);
										System.out.println("*****************************");
										System.out.println("Course to be updated...");
										System.out.println("*****************************");
										System.out.println("Course ID : " + updateCoursePojo.getCourseId());
										System.out.println("Course Name : " + updateCoursePojo.getCourseName());
										System.out.println("Course Code : " + updateCoursePojo.getCourseCode());
										System.out.println("Course Cost (USD): " + updateCoursePojo.getCourseCost());
										System.out.println("Course Duration (Hours) : " + updateCoursePojo.getCourseDuration());
										System.out.println("Course Instructor Name : " + updateCoursePojo.getCourseInstructorName());
										System.out.println("Course Description : " + updateCoursePojo.getCourseDescription());
										System.out.println("Maximum Students Allowed  : " + updateCoursePojo.getMaximumStudentsAllowed());

									
										System.out.println("***************************************************************************************");
										System.out.println(" Select from the options below the data that you want to update in a Course");
										System.out.println(" 1. Name of Course ");
										System.out.println(" 2. Course Code of Course ");
										System.out.println(" 3. Cost of Course ");
										System.out.println(" 4. Duration of Course ");
										System.out.println(" 5. Name of Instructor of Course ");
										System.out.println(" 6. Description of Course ");
										System.out.println(" 7. Maximum Students Allowed ");
										System.out.println(" 8. Update All Details ");
										
										int updationChoice = scan.nextInt();
										switch(updationChoice){ //update courses switch open - faculty area
											case 1: // update course name - faculty area
												
													System.out.println("*****************************");
													System.out.println(" Input the New Name of Course : ");
													scan.nextLine();
												//	System.out.println(updateCoursePojo);
													updateCoursePojo.setCourseName(scan.nextLine());
													try {
														courseService.updateCourse(updateCoursePojo);
														System.out.println(updateCoursePojo);
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
												System.out.println(" Input the New Course code : ");
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
												
																						
											case 3: // update course cost - faculty area
												System.out.println(" Input the New Cost of Course in USD : ");
												//scan.nextInt();
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
												
											case 4:		 // update course duration - faculty area				
												System.out.println(" Input the New Duration of Course in Hours : ");
												//scan.nextInt();
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
											
											case 5: // update course instructor name - faculty area
												System.out.println(" Input the Name of Course Instructor : ");
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
												
											case 6: // update course description - faculty area
												System.out.println("*****************************");
												System.out.println(" Input the New Course Description : ");
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
												
											case 7: // update Maximum Students Allowed - faculty area
												System.out.println("*****************************");
												System.out.println(" Input the New Count for Maximum Students Allowed in this Course : ");
												//scan.nextInt();
												updateCoursePojo.setMaximumStudentsAllowed(scan.nextInt());
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
												
											case 8: // update all course details - faculty area
												System.out.println("Please enter Course ID to be updated :");
												int updateAllCourseId = scan.nextInt(); 
												CoursePojo updateCoursePojo1 = null;
												try {
													updateCoursePojo1 = courseService.getACourse(updateAllCourseId);
												} catch (SystemException e) {
													System.out.println(e.getMessage());
													break;
												}
												if(updateCoursePojo1 == null) {
													System.out.println("*****************************************************************");
													System.out.println("Course ID does not exist. \nPlease enter a valid Course ID!");
													System.out.println("******************************************************************");
													break;
												}else {
													System.out.println("******************************************************************");
													System.out.println("Course to be updated...");
													System.out.println("*******************************************************************");
													System.out.println("Course ID : " + updateCoursePojo1.getCourseId());
													System.out.println("Course Name : " + updateCoursePojo1.getCourseName());
													System.out.println("Course Code : " + updateCoursePojo1.getCourseCode());
													System.out.println("Course Cost (USD) : " + updateCoursePojo1.getCourseCost());
													System.out.println("Course Duration (Hours) : " + updateCoursePojo1.getCourseDuration());
													System.out.println("Course Instructor Name : " + updateCoursePojo1.getCourseInstructorName());
													System.out.println("Course Description : " + updateCoursePojo1.getCourseDescription());
													System.out.println("Maximum Students Allowed : " + updateCoursePojo1.getMaximumStudentsAllowed());
													System.out.println("*******************************************************************");
													System.out.println("Please enter new Course Name :");
													scan.nextLine();
													updateCoursePojo1.setCourseName(scan.nextLine());
			
													System.out.println("Please enter new Course Code :");
													scan.nextLine();
													updateCoursePojo1.setCourseCode(scan.nextLine());
																
													System.out.println("Please enter new Course Cost :");
													updateCoursePojo1.setCourseCost(scan.nextInt());
													
													System.out.println("Please enter new Course Duration :");
													updateCoursePojo1.setCourseDuration(scan.nextInt());
													
													System.out.println("Please enter new Course Instructor Name :");
													scan.nextLine();
													updateCoursePojo1.setCourseInstructorName(scan.nextLine());
													
													System.out.println("Please enter new Course Description :");
													scan.nextLine();
													updateCoursePojo1.setCourseDescription(scan.nextLine());
													
													System.out.println(" Input the New Count for Maximum Students Allowed in this Course : ");
													updateCoursePojo1.setMaximumStudentsAllowed(scan.nextInt());
			
													//updateCoursePojo.setCourseCost(scan.nextInt());
													try {
														courseService.updateCourse(updateCoursePojo1);
													} catch (SystemException e) {
														System.out.println(e.getMessage());
														break;
													}
													System.out.println("*****************************");
													System.out.println("Course updated successfully...");
													System.out.println("*****************************");
												//}
													break;
												}
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
											System.out.println("Course Cost (USD) : " + updateCoursePojo.getCourseCost());
											System.out.println("Course Duration (Hours) : " + updateCoursePojo.getCourseDuration());
											System.out.println("Course Instructor Name : " + updateCoursePojo.getCourseInstructorName());
											System.out.println("Course Description : " + updateCoursePojo.getCourseDescription());
											System.out.println("Maximum Students Allowed  : " + updateCoursePojo.getMaximumStudentsAllowed());

											System.out.println("***************************************************************************************");
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
									System.out.println("Do you want to continue?(y/n)");
									proceed = scan.next().charAt(0);
									break;
								}// faculty main all options closed faculty 5 options switch closed list all courses,add,delete,update etc
								
						}
						
						//Beginning Student Stories
					}else if(userType !=null && userType.equals("student")) {
						System.out.println("**********************************");
						System.out.println("Student Login successfull..!!");
						char proceed = 'y';
						while(proceed == 'y') {
							System.out.println("**********************************************************");
							System.out.println("COURSE REGISTRATION SYSTEM STUDENT PORTAL");
							System.out.println("**********************************************************");
							System.out.println("HELLO "+returnedLoginUserPojo.getUserFirstName()+ " "+returnedLoginUserPojo.getUserLastName()+ "!");
							System.out.println("1. View all Courses ");
							System.out.println("2. Register in a new Course ");
							System.out.println("3. Cancel a Registered course ");
							System.out.println("4. View My Registered Courses");
							System.out.println("5. Exit");
							System.out.println("*****************************");
							System.out.println("Please enter an option:");
							int studentOption = scan.nextInt();
							System.out.println("*****************************");
							//int userInputCourseId;
							CoursePojo newCoursePojo = new CoursePojo();
							
							switch(studentOption) { //student options switch open
								case 1: // list all courses - student area
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
									System.out.println("ID\tNAME\tCode\tCOST\tDuration\tInstructor Name  \tDESCRIPTION\t\tTotal Students\tMaximum students Allowed");
									System.out.println("*************************************************************************************");
									everyCourse.forEach((item)-> System.out.println(item.getCourseId() + "\t" + item.getCourseName() + "\t" +  item.getCourseCode() + "\t" + item.getCourseCost() + "\t" + item.getCourseDuration() + "\t\t" + item.getCourseInstructorName() + "\t\t\t" + item.getCourseDescription() + "\t\t\t\t" + item.getTotalStudentsRegistered() + "\t\t" + item.getMaximumStudentsAllowed()));
									System.out.println("***************************************************************************************");
									System.out.println("Do you want to continue?(y/n)");
									proceed = scan.next().charAt(0);
									break;			
									
								case 2: // register in a course - student area
									StudentPojo newStudentPojo = new StudentPojo();
									//int registeredStudentUserId = returnedLoginUserPojo.getUserId();
									
									System.out.println("***************************************************************************************");
									System.out.println(" Register in a new Course");
									System.out.println("***************************************************************************************");

									System.out.println(" Input your Roll Number");
									//scan.nextInt();
									newStudentPojo.setStudentRollNumber(scan.nextInt());
									System.out.println(" Input your First Name : ");
									scan.nextLine();
									newStudentPojo.setStudentFirstName(scan.nextLine());
									System.out.println(" Input your Last Name :");
									//scan.nextLine();
									newStudentPojo.setStudentLastName(scan.nextLine());					
									System.out.println(" Input your Gender :");
									//scan.nextLine();
									newStudentPojo.setStudentGender(scan.nextLine());
									System.out.println(" Input your Address :");
									//scan.nextLine();
									newStudentPojo.setStudentAddress(scan.nextLine());
									System.out.println(" Input your Email Id :");
									//scan.nextLine();
									newStudentPojo.setStudentEmailId(scan.nextLine());
									System.out.println(" Input your Phone Number :");
									//scan.nextLong();
									newStudentPojo.setStudentPhoneNumber(scan.nextLong());
									System.out.println(" Input Course Name that you want to register :");
									scan.nextLine();
									newStudentPojo.setCourseRegistered(scan.nextLine());
									System.out.println(" Input Course Id of the Course you want to register :");
									newStudentPojo.setCourseId(scan.nextInt());
									System.out.println(" Input your user id :");
									newStudentPojo.setUserId(scan.nextInt());
									
									StudentPojo studentPojo = null;
									try {
										studentPojo = studentService.registerStudentCourse(newStudentPojo);
									} catch (SystemException e) {
										System.out.println(e.getMessage());
										break;
									}
									System.out.println("*****************************");
									System.out.println("New Student Registered added successfully! \n Student Roll Number is :" + studentPojo.getStudentRollNumber());
									System.out.println("*****************************");
									
									CoursePojo coursePojo = null;
									try {
										coursePojo =  courseService.getACourse(studentPojo.getStudentRollNumber());
										
									} catch (SystemException e) {
										System.out.println(e.getMessage());
										break;
									}
									System.out.println("New Student Registered is:");
									System.out.println("*****************************");
									System.out.println("Student Roll Number : " + newStudentPojo.getStudentRollNumber());
									System.out.println("Student First Name : " + newStudentPojo.getStudentFirstName());
									System.out.println("Student Last Name : " + newStudentPojo.getStudentLastName());
									System.out.println("Student Gender : " + newStudentPojo.getStudentGender());
									System.out.println("Student Address : " + newStudentPojo.getStudentAddress());
									System.out.println("Student Email Id : " + newStudentPojo.getStudentEmailId());
									System.out.println("Student Phone Number" + newStudentPojo.getStudentPhoneNumber());
									System.out.println("Student Registered Course Id: " + newStudentPojo.getCourseId());
									System.out.println("Student User Id: " + newStudentPojo.getUserId());

									System.out.println("Student Password: ");

									System.out.println("*****************************");
									System.out.println("Do you want to continue?(y/n)");
									proceed = scan.next().charAt(0);
									break;
									
								case 3:// cancel a registered course - student area
									System.out.println("**********************************");
									System.out.println("Cancel a Registered course......... ");
									System.out.println("**********************************");
									System.out.println("Enter the course id that you want to cancel :  ");
									int cancelCourseId = scan.nextInt();
									StudentPojo newStudentPojo1 = new StudentPojo();
									StudentPojo registerdStudentPojo = null;
									CoursePojo cancelCoursePojo = null;
									cancelCoursePojo = courseService.getACourse(cancelCourseId);
									
									System.out.println("******************************************************************");
									System.out.println("Course to be deleted is......");
									System.out.println("*******************************************************************");
									System.out.println("Course ID : " + cancelCoursePojo.getCourseId());
									System.out.println("Course Name : " + cancelCoursePojo.getCourseName());
									System.out.println("Course Code : " + cancelCoursePojo.getCourseCode());
									System.out.println("Course Cost (USD) : " + cancelCoursePojo.getCourseCost());
									System.out.println("Course Duration (Hours) : " + cancelCoursePojo.getCourseDuration());
									System.out.println("Course Instructor Name : " + cancelCoursePojo.getCourseInstructorName());
									System.out.println("Course Description : " + cancelCoursePojo.getCourseDescription());
									System.out.println("Maximum Students Allowed 8 : " + cancelCoursePojo.getMaximumStudentsAllowed());
									System.out.println("*******************************************************************");
									
									try {
										registerdStudentPojo = studentService.cancelCourse(newStudentPojo1);
									} catch (SystemException e) {
										System.out.println(e.getMessage());
										break;
									}
									System.out.println("Course deleted from your account successfully........ ");
									System.out.println("Do you want to continue?(y/n)");
									proceed = scan.next().charAt(0);
									break;
									
								case 4: // view my registered courses - student area
									System.out.println("**********************************");
									System.out.println("View My Registered Courses");
									System.out.println("**********************************");
									System.out.println("Enter your user id");
									int inputUserId = scan.nextInt();
									List<StudentPojo> allCoursesRegistered;
									StudentPojo viewStudentPojo = new StudentPojo();
									//System.out.println(viewStudentPojo.getUserId());
									allCoursesRegistered = studentService.studentRegisteredCourses(inputUserId);
									
									System.out.println("***********************************************************************************************************************");
									System.out.println("STUDENT ID\tFIRST NAME\tLAST NAME\tEMAIL ID\tCOURSE ID\tCOURSE NAME");
									System.out.println("************************************************************************************************************************");
									allCoursesRegistered.forEach((item)-> System.out.println(item.getUserId() + "\t\t" + item.getStudentFirstName() + "\t\t" +  item.getStudentLastName() + "\t\t" + item.getStudentEmailId() + "\t\t" + item.getCourseId() + "\t\t" + item.getCourseRegistered()));
									System.out.println("************************************************************************************************************************");
									System.out.println("Do you want to continue?(y/n)");
									proceed = scan.next().charAt(0);
									break;
																			
								case 5: // exit case for exiting from student area
									System.out.println("**********************************");
									System.out.println("*******EXIT**********");
									System.out.println("**********************************");
									break;
									
								default : // default case of student area switch statement
									System.out.println("**********************************");
									System.out.println("        Wrong Choice!!!!    ");
									System.out.println("**********************************");
									break;														
							}
							
							System.out.println("Thankyou for using the Course Registration System!!");
							
							}// end of student options switch --- student area
					}else if(userType == null){
						System.out.println("**********************************");
						System.out.println("Login failed!!");
						System.out.println("**********************************");
					}
					break;
				case 3: // exit case to exit from overall course registration system........
					userService.exitApplication();
					System.out.println("Thankyou for using the Course Registration System!!");
					System.out.println("Exiting the application....");
					System.out.println("**********************************");
					logger.info("Course Registration System Application exited...");
					scan.close();
					System.exit(0);
					break;
					
				default: // default case of main login switch
					System.out.println("Please enter a valid option");
					continue;
				}// main switch login cases ends here.....
				
				System.out.println("**********************************");
				System.out.println("Do you want to continue? (y/n) :");
				ch = scan.nextLine();
				
				if("y".equalsIgnoreCase(ch)) {
					continue;
				} else {
					userService.exitApplication();
					System.out.println("**********************************");
					System.out.println("Thankyou for using Course Registration System!!");
					System.out.println("Exiting the application....");
					System.out.println("**********************************");
					logger.info("Course Registration System Application exited...");
					scan.close();
					System.exit(0);
				}	
			}
		//}

		} // main function closed here......
}// CourseRegistrationSystem Java Class closed here

