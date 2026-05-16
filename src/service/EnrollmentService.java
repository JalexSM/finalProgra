package service;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Enrollment;
import model.Student;
import repository.Database;

public class EnrollmentService {

    private List<Enrollment> enrollments;

    public EnrollmentService() {
        enrollments = new ArrayList<>();
    }

    public boolean enrollStudent(Student student, Course course) {

        for (Enrollment enrollment : Database.enrollments) {
            if (enrollment.getStudent().equals(student) &&
                enrollment.getCourse().equals(course)) {

                System.out.println("This student is already enrolled in this course.");
                return false;
            }
        }

        int enrolledInThisCourse = 0;

        for (Enrollment enrollment : Database.enrollments) {
            if (enrollment.getCourse().equals(course)) {
                enrolledInThisCourse++;
            }
        }

        if (enrolledInThisCourse >= course.getCapacity()) {
            System.out.println("This course is full.");
            return false;
        }

        Enrollment newEnrollment = new Enrollment(student, course);
        Database.enrollments.add(newEnrollment);

        System.out.println("Student enrolled successfully.");
        return true;
    }
} 