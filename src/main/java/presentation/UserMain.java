package presentation;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.SystemException;
import model.UserPojo;
import service.UserService;
import service.UserServiceImpl;

public class UserMain {
private static final Logger logger = LogManager.getLogger(UserMain.class);
	
	public static void main(String[] args) throws Exception {
		logger.info("User Management System Application started...");
		
		UserService userService = new UserServiceImpl();
		Scanner scan = new Scanner(System.in);
	
		int option = 0;
		String ch = "y";
		
		while("y".equals(ch)) {
			System.out.println("**********************************");
			System.out.println("WELCOME TO COURSE REGISTRATION SYSTEM");
			System.out.println("**********************************");
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
				
				System.out.println("**********************************");
				System.out.println("Choose the type of account:");
				System.out.println("**********************************");
				System.out.println("1. Faculty");
				System.out.println("2. Study");
				System.out.println("**********************************");
				System.out.println("Enter your option:");
				int typeOption = Integer.parseInt(scan.nextLine());
				System.out.println("**********************************");
				if(typeOption == 1) {
					userPojo.setUserType("faculty");
				}else if(typeOption == 2) {
					userPojo.setUserType("student");
				}
				
				userPojo.setUserRemoved(false);
				
				UserPojo returnedUserPojo = null;
				try {
					returnedUserPojo = userService.register(userPojo);
				} catch (SystemException e) {
					System.out.println("**********************************");
					System.out.println("Sorry!! There is some issue with the database...");
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
				
				System.out.println("Enter user password:");
				userLoginPojo.setUserPassword(scan.nextLine());
				
				UserPojo returnedLoginUserPojo = null;
				try {
					returnedLoginUserPojo = userService.validateUser(userLoginPojo);
				} catch (SystemException e) {
					System.out.println("**********************************");
					System.out.println("Sorry!! There is some issue with the database...");
					System.out.println("Please try after sometime....");
					System.out.println("**********************************");
					logger.error(e.getMessage());
					break;
				}
				
				String userType = returnedLoginUserPojo.getUserType();
				if(userType !=null && userType.equals("faculty")) {
					System.out.println("**********************************");
					System.out.println("Customer Login successfull!!");
					System.out.println("Display Faculty Menu.");
					System.out.println("**********************************");
				}else if(userType !=null && userType.equals("student")) {
					System.out.println("**********************************");
					System.out.println("Employee Login successfull!!");
					System.out.println("Display Student Menu.");
					System.out.println("**********************************");
				}else if(userType == null){
					System.out.println("**********************************");
					System.out.println("Login failed!!");
					System.out.println("**********************************");
				}
				break;
			case 3:
				userService.exitApplication();
				System.out.println("Thankyou for using the app!!");
				System.out.println("Exiting the application....");
				System.out.println("**********************************");
				logger.info("Course Management System Application exited...");
				scan.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Please enter a valid option");
				continue;
			}
			
			System.out.println("**********************************");
			System.out.println("Do you want to continue? (y/n) :");
			ch = scan.nextLine();
			
			if("y".equalsIgnoreCase(ch)) {
				continue;
			} else {
				userService.exitApplication();
				System.out.println("**********************************");
				System.out.println("Thankyou for using the app!!");
				System.out.println("Exiting the application....");
				System.out.println("**********************************");
				logger.info("User Management System Application exited...");
				scan.close();
				System.exit(0);
			}	
		}
	}


}