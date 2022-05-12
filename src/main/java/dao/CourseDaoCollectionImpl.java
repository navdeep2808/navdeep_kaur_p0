package dao;

import java.util.ArrayList;
import java.util.List;

import exception.EmptyCourseCatalogException;

import java.util.Iterator;

import model.CoursePojo;

public class CourseDaoCollectionImpl implements CourseDao {
	// this is the data store
		List<CoursePojo> allCourses = new ArrayList<CoursePojo>(); // recommended as the class ArrayList is abstracted through the interface List
		//ArrayList<CoursePojo> allCourses = new ArrayList<CoursePojo>(); // not recomended, as we do not want to access the ArrayList class directly,
																			  // there is no abstraction here
		
		public CourseDaoCollectionImpl() {
		/*	CoursePojo course1 = new CoursePojo(101, "C", "CS101", "Learning C", 150, 40, "Aden", "");
			CoursePojo course2 = new CoursePojo(102, "C++", "CS102","Learn C++", 180, 50,"Joe","");
			CoursePojo course3 = new CoursePojo(103, "Java","CS103", "Learn Java", 120, 65, "Anna","");
			allCourses.add(course1);
			allCourses.add(course2);
			allCourses.add(course3);*/
		}

		@Override
		public CoursePojo addCourse(CoursePojo coursePojo) {
			// generate the new course id
			int newCourseId = allCourses.get(allCourses.size()-1).getCourseId() + 1;
			// set it in the course pojo
			coursePojo.setCourseId(newCourseId);
			// all the courses to the data store
			allCourses.add(coursePojo);
			
			return coursePojo;
			
		}

		@Override
		public CoursePojo updateCourse(CoursePojo coursePojo) {
			for(int i=0;i<allCourses.size();i++) {
				if(allCourses.get(i).getCourseId() == coursePojo.getCourseId()) {
					allCourses.set(i, coursePojo); 
					break;
				}
			}
			return coursePojo;
		}

		@Override
		public void deleteCourse(int courseId) {
			Iterator<CoursePojo> allCoursesItr = allCourses.iterator();
			while(allCoursesItr.hasNext()) {
				CoursePojo getCourse = allCoursesItr.next();
				if(getCourse.getCourseId() == courseId) {
					allCourses.remove(getCourse);
					break;
				}
			}
			
		}

		@Override
		public List<CoursePojo> getAllCourses()throws EmptyCourseCatalogException {
			if(allCourses.isEmpty()) {
				EmptyCourseCatalogException ecce = new EmptyCourseCatalogException();
				throw ecce;
			}
			return allCourses;
		}

		@Override
		public CoursePojo getACourse(int courseId) {
			CoursePojo foundCourse = null;
			for(int i=0;i<allCourses.size();i++) {
				if(allCourses.get(i).getCourseId() == courseId) {
					foundCourse = allCourses.get(i); // when match found , assign the found reference variable to foundCourse
					break;
				}
			}
			return foundCourse;
		}
	
}
