package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import dao.CourseDao;
import exception.EmptyCourseCatalogException;
import exception.SystemException;
import model.CoursePojo;
import service.CourseService;
import service.CourseServiceImpl;


class CourseRegistrationSystemTest {

		// JUnit 5 test method  - addCourse
		@Test
		public void testAddCourse() {
			CourseService courseService = new CourseServiceImpl();
	
			CoursePojo expectedPojo = new CoursePojo(100, "JUnit 5", "CS189", 105, 35, "Maple", "Learn JUnit 5",0,20);
			CoursePojo actualPojo = null;
			try {
				CoursePojo coursePojo = new CoursePojo();

				actualPojo = courseService.addCourse(coursePojo);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			assertEquals(expectedPojo, actualPojo);
		}
		
		// JUnit 5 test method  - updateCourse
		@Test
		public void testUpdateCourse() {
			CourseService courseService = new CourseServiceImpl();
	
			CoursePojo expectedPojo = new CoursePojo(100, "JUnit 5", "CS189", 105, 35, "Maple", "Learn JUnit 5",0,20);
			CoursePojo actualPojo = null;
			try {
				CoursePojo coursePojo = new CoursePojo();

				actualPojo = courseService.updateCourse(coursePojo);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			assertEquals(expectedPojo, actualPojo);
		}
		
			// JUnit 5 test method  - getACourse
				@Test
				public void testGetAllCourses() throws EmptyCourseCatalogException {
					CourseService courseService = new CourseServiceImpl();
		
					CoursePojo expectedPojo = new CoursePojo(1, "C", "CS101", 95, 40, "Anna", "Learn C",1,20);
					List<CoursePojo> actualPojo = null;
					try {
					//	CoursePojo coursePojo = new CoursePojo();
						actualPojo = courseService.getAllCourses();
					} catch (SystemException e) {
						e.printStackTrace();
					}
					assertEquals(expectedPojo, actualPojo);
				}
				// JUnit 5 test method  - getACourse
				@Test
				public void testGetACourse() {
					CourseService courseService = new CourseServiceImpl();
		
					CoursePojo expectedPojo = new CoursePojo(1, "C", "CS101", 95, 40, "Anna", "Learn C",1,20);
					CoursePojo actualPojo = null;
					try {
						actualPojo = courseService.getACourse(1);
					} catch (SystemException e) {
						e.printStackTrace();
					}
					assertEquals(expectedPojo, actualPojo);
				}
			
			
}