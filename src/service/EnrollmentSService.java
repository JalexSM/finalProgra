package service;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Enrollment;
import model.Student;
import repository.Database;

public class EnrollmentSService {

    private List<Enrollment> enrollments;

    public EnrollmentSService() {
        enrollments = new ArrayList<>();
    }

    public boolean enrollStudent(Student student, Course course) {

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) &&
                enrollment.getCourse().equals(course)) {

                System.out.println("This student is already enrolled in this course.");
                return false;
            }
        }

        if (enrollments.size() >= course.getCapacity()) {
            System.out.println("This course is full.");
            return false;
        } 
        Enrollment newEnrollment = new Enrollment(student, course);
        enrollments.add(newEnrollment);
        
        Database.enrollments.add(newEnrollment);

        System.out.println("Student enrolled successfully.");
        return true;
    
    }
}