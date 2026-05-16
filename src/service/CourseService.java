package service;

import model.Course;
import repository.Database;

public class CourseService {

	public boolean saveCourse(Course course) {

		for (Course c : Database.courses) {

			if (c.getCode().equals(course.getCode())) {

				System.out.println("Course code already exists.");
				return false;
			}
		}

		if (course.getCapacity() <= 0) {

			System.out.println("Invalid course capacity.");
			return false;
		}

		Database.courses.add(course);

		System.out.println("Course saved successfully.");

		return true;
	}

}
